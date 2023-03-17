package br.com.rezende.budget.kernel.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public abstract class MultiTenantEntity extends Entity {

    @NotNull(message = "lblTenantIdNotNull")
    @Valid
    private final TenantId tenantId;
    private boolean active;

    public MultiTenantEntity(TenantId tenantId, long version, boolean active) {
        super(version);
        this.tenantId = tenantId;
        this.active = active;
        this.validateProperty("tenantId");
    }

    public TenantId getTenantId() {
        return tenantId;
    }

    public boolean isActive() {
        return active;
    }
}
