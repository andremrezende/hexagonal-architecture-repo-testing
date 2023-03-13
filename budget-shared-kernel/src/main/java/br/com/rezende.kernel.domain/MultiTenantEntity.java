package br.com.rezende.kernel.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public abstract class MultiTenantEntity extends Entity {

    @NotNull(message = "lblTenantIdNotNull")
    @Valid
    private final TenantId tenantId;

    public MultiTenantEntity(TenantId tenantId, long version) {
        super(version);
        this.tenantId = tenantId;
        this.validateProperty("tenantId");
    }

    public TenantId getTenantId() {
        return tenantId;
    }
}
