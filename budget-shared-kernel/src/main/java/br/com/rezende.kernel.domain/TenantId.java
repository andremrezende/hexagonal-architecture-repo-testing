package br.com.rezende.kernel.domain;


import br.com.rezende.kernel.fwk.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public final class TenantId extends ValueObject {

    @NotNull(message = "lblNotNullId")
    private final String id;

    private TenantId(String id) {
        this.id = id;
        this.validate();
    }

    public static TenantId of(String id) {
        if(id == null) {
            return null;
        }
        return new TenantId(id);
    }

    public static TenantId B2C() {
        return TenantId.of("B2C");
    }

    public static TenantId noTenant() {
        return TenantId.of("");
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenantId tenantId = (TenantId) o;
        return Objects.equals(getId(), tenantId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TenantId{" +
                "id='" + id + '\'' +
                '}';
    }
}
