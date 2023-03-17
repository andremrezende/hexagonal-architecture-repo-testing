package br.com.rezende.budget.budget.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema="budget_context", name = "product",
        indexes = {
                @Index(name = "name", columnList = "name"),
                @Index(name = "unity", columnList = "unity")
        })
public class ProductEntity {
    @Id
    private String id;

    private String name;

    private String unity;

    private boolean active;

    @Version
    private Long version;
}
