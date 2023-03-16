package br.com.rezende.budget;

import br.com.rezende.kernel.exceptions.OptimisticLockRepositoryException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductRepositoryInMem implements ProductRepository {
    private final List<Product> products;

    public ProductRepositoryInMem() {
        this.products = new ArrayList<>();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> retrieveProductWithName(ProductName productName) {
        return Optional.empty();
    }

    private void checkOptimisticLock(final Product product2Save) {
        Product existingProduct = products.stream().filter(s -> s.getProductId().equals(product2Save.getProductId())).findFirst().orElse(null);

        if(Objects.isNull(existingProduct)) return;

        if(product2Save.isStaleWith(existingProduct)) {
            throw new OptimisticLockRepositoryException("Stale data found updating product class with id " + product2Save.getProductId().value());
        }
        products.remove(product2Save);
    }
}
