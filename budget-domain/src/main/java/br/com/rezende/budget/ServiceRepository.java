package br.com.rezende.budget;

import java.util.Optional;

public interface ServiceRepository {
    Service save(Service service);
    Optional<Service> retrieveServiceWithName(ServiceName serviceName);
}
