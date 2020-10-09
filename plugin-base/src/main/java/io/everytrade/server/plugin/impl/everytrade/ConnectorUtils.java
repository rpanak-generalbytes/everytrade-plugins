package io.everytrade.server.plugin.impl.everytrade;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.trade.UserTrade;

import java.util.List;

public class ConnectorUtils {

    private ConnectorUtils() {
    }

    public static CurrencyPair createPair(String pair) {
        final String[] split = pair.split("/");
        if (split.length != 2) {
            throw new IllegalArgumentException(String.format("Illegal pair value '%s'.", pair));
        }
        final Currency base = Currency.getInstanceNoCreate(split[0]);
        final Currency quote = Currency.getInstanceNoCreate(split[1]);
        if (base == null) {
            throw new IllegalArgumentException(String.format("Illegal base value '%s'.", split[0]));
        }
        if (quote == null) {
            throw new IllegalArgumentException(String.format("Illegal quote value '%s'.", split[1]));
        }
        return new CurrencyPair(base, quote);
    }

    public static int occurrenceCount(String input, String search) {
        int startIndex = 0;
        int index = 0;
        int counter = 0;
        while (index > -1 && startIndex < input.length()) {
            index = input.indexOf(search, startIndex);
            if (index > -1) {
                counter++;
            }
            startIndex = index + 1;
        }
        return counter;
    }

    public static int findDuplicate(String transactionId, List<UserTrade> userTradesBlock) {
        for (int i = 0; i < userTradesBlock.size(); i++) {
            final UserTrade userTrade = userTradesBlock.get(i);
            if (userTrade.getId().equals(transactionId)) {
                return i;
            }
        }
        return -1;
    }
}