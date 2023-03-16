package br.com.rezende.budget;

import br.com.rezende.budget.db.ProductRepositoryJpaHelper;

import java.util.Optional;

public class ProductRepositoryJpa implements ProductRepository {
    private final ProductRepositoryJpaHelper productRepositoryJpaHelper;

    public ProductRepositoryJpa(ProductRepositoryJpaHelper productRepositoryJpaHelper) {
        this.productRepositoryJpaHelper = productRepositoryJpaHelper;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> retrieveProductWithName(ProductName productName) {
        return Optional.empty();
    }
}
