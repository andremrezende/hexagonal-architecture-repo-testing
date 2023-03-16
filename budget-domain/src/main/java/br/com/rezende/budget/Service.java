package br.com.rezende.budget;

import br.com.rezende.kernel.domain.MultiTenantEntity;
import br.com.rezende.kernel.domain.TenantId;

import java.util.Objects;

public class Service extends MultiTenantEntity {
    private ServiceId serviceId;
    private ServiceName serviceName;
    private ProductPrice productPrice;

    public Service(ServiceId serviceId, ServiceName serviceName, ProductPrice productPrice, TenantId tenantId, long version, boolean active) {
        super(tenantId, version, active);
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.productPrice = productPrice;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
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
