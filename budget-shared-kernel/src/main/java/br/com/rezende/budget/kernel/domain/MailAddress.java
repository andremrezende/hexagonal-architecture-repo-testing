package br.com.rezende.budget.kernel.domain;

import br.com.rezende.kernel.fwk.ValueObject;
import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.Optional;

@EqualsAndHashCode
public class MailAddress extends ValueObject {

    private final String streetFirst;
    private final String streetSecond;
    private final String number;
    private final String zip;
    private final String country;
    private final String countryCode;
    private final String city;
    private final String state;
    private final String area;


    private MailAddress(String streetFirst,
                        String streetSecond,
                        String number,
                        String zip,
                        String country,
                        String countryCode,
                        String city,
                        String state,
                        String area) {
        this.streetFirst = streetFirst;
        this.streetSecond = streetSecond;
        this.number = number;
        this.zip = zip;
        this.country = country;
        this.countryCode = countryCode;
        this.city = city;
        this.state = state;
        this.area = area;
        this.validate();
    }

    public String getStreetFirst() {
        return streetFirst;
    }

    public Optional<String> getStreetSecond() {
        return Optional.ofNullable(streetSecond);
    }

    public String getNumber() {
        return number;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public Optional<String> getCountryCode() {
        return Optional.ofNullable(countryCode);
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Optional<String> getArea() {
        return Optional.ofNullable(area);
    }

    public static MailAddressBuilder builder() {
        return new MailAddressBuilder();
    }

    public static MailAddress defaultAddress() {
        return new MailAddress("N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A");
    }

    public static class MailAddressBuilder {

        private String streetFirst;
        private String streetSecond;
        private String number;
        private String zip;
        private String country;
        private String countryCode;
        private String city;
        private String state;
        private String area;

        public String getStreetFirst() {
            return streetFirst;
        }

        public String getStreetSecond() {
            return streetSecond;
        }

        public String getNumber() {
            return number;
        }

        public String getZip() {
            return zip;
        }

        public String getCountry() {
            return country;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getArea() {
            return area;
        }

        public MailAddressBuilder withStreetFirst(String streetFirst) {
            this.streetFirst = streetFirst;
            return this;
        }

        public MailAddressBuilder withStreetSecond(String streetSecond) {
            this.streetSecond = streetSecond;
            return this;
        }

        public MailAddressBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public MailAddressBuilder withZip(String zip) {
            this.zip = zip;
            return this;
        }

        public MailAddressBuilder withCountry(String country) {
            if(Objects.isNull(country)) {
                this.country = "UNKNOWN";
            }
            else {
                this.country = country;
            }
            return this;
        }

        public MailAddressBuilder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public MailAddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public MailAddressBuilder withState(String state) {
            this.state = state;
            return this;
        }

        public MailAddressBuilder withArea(String area) {
            this.area = area;
            return this;
        }

        public MailAddress build() {
            return instanceNew(this);
        }

        private static MailAddress instanceNew(MailAddressBuilder mailAddressBuilder) {
            return new MailAddress(mailAddressBuilder.getStreetFirst(),
                    mailAddressBuilder.getStreetSecond(),
                    mailAddressBuilder.getNumber(),
                    mailAddressBuilder.getZip(),
                    mailAddressBuilder.getCountry(),
                    mailAddressBuilder.getCountryCode(),
                    mailAddressBuilder.getCity(),
                    mailAddressBuilder.getState(),
                    mailAddressBuilder.getArea());
        }
    }

}
