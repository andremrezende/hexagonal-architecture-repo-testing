package br.com.rezende.budget.budget;

import br.com.rezende.budget.budget.db.ServiceRepositoryJpaHelper;

import java.util.Optional;

public class ServiceRepositoryJpa implements ServiceRepository {
    private final ServiceRepositoryJpaHelper serviceRepositoryJpaHelper;

    public ServiceRepositoryJpa(ServiceRepositoryJpaHelper serviceRepositoryJpaHelper) {
        this.serviceRepositoryJpaHelper = serviceRepositoryJpaHelper;
    }

    @Override
    public Service save(Service service) {
        return null;
    }

    @Override
    public Optional<Service> retrieveServiceWithName(ServiceName serviceName) {
        return Optional.empty();
    }
}
