package br.com.rezende.budget.budget.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepositoryJpaHelper extends JpaRepository<ServiceEntity, String> {
}
