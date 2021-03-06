package io.everytrade.server.plugin.api.parser;

import io.everytrade.server.model.Currency;
import io.everytrade.server.model.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class BuySellImportedTransactionBean extends ImportedTransactionBean{
    private final BigDecimal baseQuantity;
    private final BigDecimal unitPrice;

    public BuySellImportedTransactionBean(
        String uid,
        Instant executed,
        Currency base,
        Currency quote,
        TransactionType action,
        BigDecimal baseQuantity,
        BigDecimal unitPrice
    ) {
        super(
            uid,
            executed,
            base,
            quote,
            action
        );

        Objects.requireNonNull(this.baseQuantity = baseQuantity);
        Objects.requireNonNull(this.unitPrice = unitPrice);
    }

    public BigDecimal getBaseQuantity() {
        return baseQuantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }


    @Override
    public String toString() {
        return "BuySellImportedTransactionBean{" +
            "uid='" + getUid() + '\'' +
            ", executed=" + getExecuted() +
            ", base=" + getBase() +
            ", quote=" + getQuote() +
            ", action=" + getAction() +
            ", baseQuantity=" + baseQuantity +
            ", unitPrice=" + unitPrice +
            '}';
    }
}
