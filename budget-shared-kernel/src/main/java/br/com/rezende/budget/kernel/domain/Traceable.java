package br.com.rezende.budget.kernel.domain;

public interface Traceable {

    void setCorrelationId(CorrelationId correlationId);
    CorrelationId correlationId();

}
