package br.com.rezende.budget;

import br.com.rezende.kernel.domain.MultiTenantEntity;
import br.com.rezende.kernel.domain.TenantId;

import java.util.Objects;

public class Service extends MultiTenantEntity {
    private ServiceId serviceId;
    private ServiceName serviceName;

    public Service(ServiceId serviceId, ServiceName serviceName, TenantId tenantId, long version) {
        super(tenantId, version);
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    @Override
    public String aggregateId() {
        return this.serviceId.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service company = (Service) o;
        return Objects.equals(serviceId, company.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId);
    }
}
