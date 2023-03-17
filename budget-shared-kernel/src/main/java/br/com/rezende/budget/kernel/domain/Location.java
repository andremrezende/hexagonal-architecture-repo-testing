package br.com.rezende.budget.kernel.domain;

import br.com.rezende.kernel.fwk.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Location extends ValueObject {

    private final String state;
    private final String city;

    private Location(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public static Location in(String state, String city) {
        return new Location(state, city);
    }

}
