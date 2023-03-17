package br.com.rezende.budget.budget;

import br.com.rezende.kernel.domain.MultiTenantEntity;
import br.com.rezende.kernel.domain.TenantId;

import java.util.Objects;

public class Product extends MultiTenantEntity {
    private ProductId productId;
    private ProductName productName;
    private ProductPrice productPrice;

    public Product(ProductId productId, ProductName productName, ProductPrice productPrice, TenantId tenantId, long version, boolean active) {
        super(tenantId, version, active);
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public ProductName getProductName() {
        return productName;
    }

    public ProductId getProductId() {
        return productId;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    @Override
    public String aggregateId() {
        return this.productId.value();
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
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

    public static class ProductBuilder {
        private ProductId productId;
        private ProductName productName;
        private ProductPrice productPrice;
        private TenantId tenantId;
        private long version;
        private boolean active;

        public ProductBuilder withProductId(ProductId productId) {
            this.productId = productId;
            return this;
        }

        public ProductBuilder withProductName(ProductName productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder withProductPrice(ProductPrice productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public ProductBuilder withTenantId(TenantId tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public ProductBuilder withVersion(long version) {
            this.version = version;
            return this;
        }
        public ProductBuilder withActive(boolean active) {
            this.active = active;
            return this;
        }

        public Product build() {
            return new Product(this.productId, this.productName, this.productPrice, this.tenantId, this.version, this.active);
        }
    }
}
