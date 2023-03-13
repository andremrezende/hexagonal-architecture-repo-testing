package br.com.rezende.kernel.domain;

public final class ApplicationVersion {

    private final String version;

    private ApplicationVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public static ApplicationVersion of(String version) {
        return new ApplicationVersion(version);
    }



}
