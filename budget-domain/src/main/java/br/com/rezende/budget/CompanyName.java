package br.com.rezende.budget;

import br.com.rezende.kernel.fwk.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
public class CompanyName extends ValueObject {
    @NotNull
    private final String realName;

    @NotNull
    private final String fantasyName;

    public CompanyName(String realName, String fantasyName) {
        this.realName = realName;
        this.fantasyName = fantasyName;
    }

    public String getRealName() {
        return realName;
    }

    public String fullName() {
        return realName + " " + fantasyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyName that = (CompanyName) o;
        return Objects.equals(realName, that.realName) &&
                Objects.equals(fantasyName, that.fantasyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realName, fantasyName);
    }

}
