package br.com.rezende.budget.budget;

import br.com.rezende.kernel.fwk.ValueObject;

import java.util.Objects;

class CategoryId extends ValueObject {

    private final String value;

    private CategoryId(String value) {
        this.value = value;
    }

    static CategoryId of(String value) {
        return new CategoryId(value);
    }

    String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryId that = (CategoryId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
