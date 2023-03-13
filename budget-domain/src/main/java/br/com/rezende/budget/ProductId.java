package br.com.rezende.budget;

import com.twba.kernel.fwk.ValueObject;

import java.util.Objects;

public class ProductId extends ValueObject {

    private final String value;

    private ProductId(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }

    static ProductId of(String value) {
        if(Objects.isNull(value)) {
            return null;
        }
        return new ProductId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(value, productId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}