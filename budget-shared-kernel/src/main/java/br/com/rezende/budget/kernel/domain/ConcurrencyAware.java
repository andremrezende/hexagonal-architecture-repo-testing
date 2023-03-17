package br.com.rezende.budget.kernel.domain;

public interface ConcurrencyAware {

    Long getVersion();
    boolean isStaleWith(ConcurrencyAware existingEntity);


}
