package br.com.rezende.budget.config;


import br.com.rezende.budget.ProductRepository;
import br.com.rezende.budget.ProductRepositoryJpa;
import br.com.rezende.budget.ServiceRepositoryJpa;
import br.com.rezende.budget.db.ProductRepositoryJpaHelper;
import br.com.rezende.budget.db.ServiceRepositoryJpaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
        "br.com.rezende.budget"
})
@EntityScan(basePackages = {
        "br.com.rezende.budget"
})
@EnableJpaRepositories(basePackages = {
        "br.com.rezende.budget"
})
public class PersistenceConfig {

    @Bean
    public ProductRepository productRepository(@Autowired ProductRepositoryJpaHelper productRepositoryJpaHelper) {
        return new ProductRepositoryJpa(productRepositoryJpaHelper);
    }

    @Bean
    public ServiceRepositoryJpa serviceRepository(@Autowired ServiceRepositoryJpaHelper serviceRepositoryJpaHelper) {
        return new ServiceRepositoryJpa(serviceRepositoryJpaHelper);
    }

}