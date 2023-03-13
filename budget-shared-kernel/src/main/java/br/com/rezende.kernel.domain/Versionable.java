package br.com.rezende.kernel.domain;

public interface Versionable {

    void setVersion(ApplicationVersion applicationVersion);
    ApplicationVersion getVersion();

}
