package br.com.rezende.budget.budget;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;

public class ProductPrice extends Price {
    @NotNull
    private final Double buyPrice;

    public ProductPrice(Date updated, Double sellPrice, Double buyPrice) {
        super(updated, sellPrice);
        this.buyPrice = buyPrice;
    }

    public static ProductPrice with(Date updated, Double sellPrice, Double buyPrice) {
        return new ProductPrice(updated, sellPrice, buyPrice);
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(buyPrice, that.buyPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buyPrice);
    }
}
