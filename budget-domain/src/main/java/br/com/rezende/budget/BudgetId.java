package br.com.rezende.budget;

import br.com.rezende.kernel.fwk.ValueObject;

import java.util.Objects;
public class BudgetId extends ValueObject {

    private final String value;

    private BudgetId(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }

    static BudgetId of(String value) {
        if(Objects.isNull(value)) {
            return null;
        }
        return new BudgetId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetId budgetId = (BudgetId) o;
        return Objects.equals(value, budgetId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}