package br.com.rezende.budget.kernel.domain;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public final class CorrelationId {

    @NotNull
    private final String value;

    private CorrelationId(String correlationId) {
        this.value = correlationId;
    }

    public static CorrelationId of(String correlationId) {
        return new CorrelationId(correlationId);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrelationId that = (CorrelationId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
