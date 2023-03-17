package br.com.rezende.budget;

import br.com.rezende.budget.budget.Product;
import br.com.rezende.budget.budget.ProductRepository;
import org.junit.jupiter.api.Test;

import static br.com.rezende.budget.util.ProductExamples.randomNewProduct;
import static org.junit.jupiter.api.Assertions.*;

public class PoductRepositoryTest {
    private ProductRepository productRepository;

    @Test
    public void shouldCreateProduct() {
        //GIVEN
        Product expected = randomNewProduct();

        //WHEN
        Product current = productRepository.save(expected);

        //THEN
        assertAll("Create Product",
                () -> assertEquals(0L, current.getVersion()),
                () -> assertEquals(expected.getProductName(), current.getProductName()),
                () -> assertNotNull(current.getProductId())
        );
    }
}
