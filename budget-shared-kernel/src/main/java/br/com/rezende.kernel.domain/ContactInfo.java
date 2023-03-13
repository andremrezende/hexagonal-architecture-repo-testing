package br.com.rezende.kernel.domain;

import br.com.rezende.kernel.fwk.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ContactInfo extends ValueObject {

    @NotNull
    private final List<String> phoneNumbers;

    @NotNull
    private final List<String> emailAddresses;

    private ContactInfo(List<String> phoneNumbers, List<String> emailAddresses) {
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
        this.validate();
    }

    public static ContactInfo with(String emailAddress, String... phoneNumber) {
        return new ContactInfo(Arrays.asList(phoneNumber), Arrays.asList(emailAddress));
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return Objects.equals(phoneNumbers, that.phoneNumbers) &&
                Objects.equals(emailAddresses, that.emailAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumbers, emailAddresses);
    }

    public Optional<String> getMainPhoneNumber() {
        return phoneNumbers.stream().findFirst();
    }
    public Optional<String> getMainEmailAddress() {
        return emailAddresses.stream().findFirst();
    }
}
