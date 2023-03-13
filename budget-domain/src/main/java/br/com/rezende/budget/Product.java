package br.com.rezende.budget;

import br.com.rezende.kernel.domain.MultiTenantEntity;
import br.com.rezende.kernel.domain.TenantId;

import java.util.Objects;

public class Product extends MultiTenantEntity {
    private ProductId productId;
    private ProductName productName;

    public Product(ProductId productId, ProductName productName, TenantId tenantId, long version) {
        super(tenantId, version);
        this.productId = productId;
        this.productName = productName;
    }

    public ProductName getProductName() {
        return productName;
    }

    public ProductId getProductId() {
        return productId;
    }

    @Override
    public String aggregateId() {
        return this.productId.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product company = (Product) o;
        return Objects.equals(productId, company.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
