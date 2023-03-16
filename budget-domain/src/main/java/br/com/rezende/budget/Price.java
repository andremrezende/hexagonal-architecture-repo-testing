package br.com.rezende.budget;

import br.com.rezende.kernel.fwk.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;

public class Price extends ValueObject {
    @NotNull
    private final Date updated;

    @NotNull
    private final Double sellPrice;

    public Price(Date updated, Double sellPrice) {
        this.updated = updated;
        this.sellPrice = sellPrice;
    }

    public Date getUpdated() {
        return updated;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(updated, price.updated) && Objects.equals(sellPrice, price.sellPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updated, sellPrice);
    }
}
