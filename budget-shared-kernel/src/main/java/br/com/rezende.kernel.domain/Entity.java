package br.com.rezende.kernel.domain;

import br.com.rezende.kernel.fwk.ModelValidator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Entity extends ModelValidator implements ConcurrencyAware {
    @NotNull
    @Valid
    protected final List<@NotNull Event<? extends DomainEventPayload>> events;
    private Long version;

    public Entity(Long version) {
        this.events = new ArrayList<>();
        this.version = version;
        this.validateProperty("events");
    }

    @Override
    public Long getVersion() {
        return version;
    }

    protected void publishEvent(Event<? extends DomainEventPayload> event) {
        event.setAggregateType(aggregateType());
        event.setAggregateId(aggregateId());
        event.setEventStreamVersion(Objects.isNull(version)?0:version + events.size());
        this.events.add(event);
    }

    protected void publishEvent(DomainEventPayload event) {
        publishEvent(new Event<>(event));
    }

    public boolean hasEvents(){
        return !events.isEmpty();
    }

    public String aggregateType() {
        return this.getClass().getSimpleName();
    }

    public abstract  String aggregateId();

    /**
     * Retrieve the events
     * @return
     */
    public List<Event<? extends DomainEventPayload>> getDomainEvents() {
        return Collections.unmodifiableList(events);
    }

    protected void setVersion(long version) {
        this.version = version;
        this.validateProperty("version");
    }

    @Override
    public boolean isStaleWith(ConcurrencyAware existingEntity) {
        return Objects.nonNull(existingEntity) && this.getVersion() < existingEntity.getVersion();
    }
}
