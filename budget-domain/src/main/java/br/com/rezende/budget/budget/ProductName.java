package br.com.rezende.budget.budget;

import br.com.rezende.kernel.fwk.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class ProductName extends ValueObject {
    @NotNull
    private final String name;

    public ProductName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ProductName with(String name) {
        return new ProductName(name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductName that = (ProductName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
