package br.com.rezende.budget.budget;

import br.com.rezende.budget.kernel.exceptions.OptimisticLockRepositoryException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ServiceRepositoryInMem implements ServiceRepository {
    private final List<Service> services;

    public ServiceRepositoryInMem() {
        this.services = new ArrayList<>();
    }

    @Override
    public Service save(Service service) {
        return null;
    }

    @Override
    public Optional<Service> retrieveServiceWithName(ServiceName serviceName) {
        return Optional.empty();
    }

    private void checkOptimisticLock(final Service service2Save) {
        Service existingService = services.stream().filter(s -> s.getServiceId().equals(service2Save.getServiceId())).findFirst().orElse(null);

        if(Objects.isNull(existingService)) return;

        if(service2Save.isStaleWith(existingService)) {
            throw new OptimisticLockRepositoryException("Stale data found updating service class with id " + service2Save.getServiceId().value());
        }
        services.remove(service2Save);
    }
}
