package br.com.rezende.budget.budget;

import br.com.rezende.kernel.fwk.ValueObject;

import java.util.Objects;

class CompanyId extends ValueObject {

    private final String value;

    private CompanyId(String value) {
        this.value = value;
    }

    static CompanyId of(String value) {
        return new CompanyId(value);
    }

    String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyId that = (CompanyId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
