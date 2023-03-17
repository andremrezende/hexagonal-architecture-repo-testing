package br.com.rezende.budget.kernel.domain;

import java.util.Objects;

public class PersonalId  {

    private final String value;
    private final String type;

    private PersonalId(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String value() {
        return value;
    }

    public String type() {
        return type;
    }

    public String getValue() {
        return value();
    }

    public String getType() {
        return type();
    }

    public static PersonalId with(String value, String type) {
        return new PersonalId(value, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalId that = (PersonalId) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
