package br.com.rezende.budget.kernel.domain;

public interface Versionable {

    void setVersion(ApplicationVersion applicationVersion);
    ApplicationVersion getVersion();

}
