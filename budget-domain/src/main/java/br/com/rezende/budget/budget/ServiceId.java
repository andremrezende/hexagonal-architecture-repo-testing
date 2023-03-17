package br.com.rezende.budget.budget;

import br.com.rezende.kernel.fwk.ValueObject;

import java.util.Objects;

public class ServiceId extends ValueObject {

    private final String value;

    private ServiceId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static ServiceId of(String value) {
        if(Objects.isNull(value)) {
            return null;
        }
        return new ServiceId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceId serviceId = (ServiceId) o;
        return Objects.equals(value, serviceId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}