package br.com.rezende.kernel.domain;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public abstract class DomainEventPayload {

    /**
     * When the event was created in UIC
     */
    private final Instant occurredOn;

    /**
     * Randomly generated UID for created events
     */
    private final String eventUid;

    /**
     * TenandId for the domain event
     */
    private final String tenantId;

    public DomainEventPayload(String tenantId) {
        this.occurredOn = Instant.now();
        this.eventUid = UUID.randomUUID().toString();
        this.tenantId = tenantId;
    }

    public DomainEventPayload(Instant occurredOn, String eventUid, String tenantId) {
        this.occurredOn = occurredOn;
        this.eventUid = eventUid;
        this.tenantId = tenantId;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public String getEventUid() {
        return eventUid;
    }

    public String getTenantId() {
        return tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainEventPayload that = (DomainEventPayload) o;
        return Objects.equals(eventUid, that.eventUid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventUid);
    }
}
