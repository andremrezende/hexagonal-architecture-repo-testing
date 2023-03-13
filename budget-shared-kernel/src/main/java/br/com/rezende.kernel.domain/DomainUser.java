package br.com.rezende.kernel.domain;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DomainUser {

    private static final String DEFAULT_LANGUAGE = "en";
    public static final String DEFAULT_PROFILE = "DEFAULT_PROFILE";
    private final String username;
    private final List<String> profiles;
    private final Locale locale;

    public DomainUser(String username, List<String> profiles) {
        this(username, profiles, DEFAULT_LANGUAGE, null);
    }

    public DomainUser(String username, List<String> profiles, String languageCode, String countryCode) {
        this.username = username;
        this.profiles = profiles;
        if(countryCode != null && !countryCode.isEmpty()) {
            this.locale = new Locale(languageCode, countryCode);
        }
        else {
            this.locale = new Locale(languageCode);
        }
    }

    public static DomainUser unknownUser() {
        return new DomainUser("UNKNOWN_USER", Collections.singletonList(DEFAULT_PROFILE));
    }

    public String getUsername() {
        return username;
    }

    public List<String> getProfiles() {
        return Collections.unmodifiableList(profiles);
    }

    public String getProfilesAsCommaSeparatedString() {
        return String.join(",", profiles);
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getLanguageCode() {
        return this.locale.getLanguage();
    }

    public String getCountryCode() {
        return this.locale.getCountry();
    }

    public String getFullLocale() {
        return this.locale.getLanguage() + "-" + this.locale.getCountry();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainUser that = (DomainUser) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(profiles, that.profiles);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, profiles);
    }
}
