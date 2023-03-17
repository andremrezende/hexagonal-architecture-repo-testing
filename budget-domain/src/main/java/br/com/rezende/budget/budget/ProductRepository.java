package br.com.rezende.budget.budget;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> retrieveProductWithName(ProductName productName);
}
