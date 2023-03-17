package br.com.rezende.budget.util;

import br.com.rezende.budget.budget.Product;
import br.com.rezende.budget.budget.ProductName;
import br.com.rezende.budget.budget.ProductPrice;
import br.com.rezende.kernel.domain.TenantId;

import java.util.Date;

public class ProductExamples {
    private static Product.ProductBuilder randomProduct() {
        return Product.builder()
                .withActive(true)
                .withProductName(ProductName.with("ProductName"))
                .withProductPrice(ProductPrice.with(new Date(), 10.02d, 5.01d))
                .withTenantId(TenantId.of("local"));
    }
    public static Product randomNewProduct() {
        return randomProduct().build();
    }

}
