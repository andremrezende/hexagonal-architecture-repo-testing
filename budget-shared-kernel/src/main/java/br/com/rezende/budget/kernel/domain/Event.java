package br.com.rezende.budget.kernel.domain;


import java.util.*;

public final class Event<T extends DomainEventPayload> implements SecurityAware, Versionable, Traceable, Routable {

    private static final String USERNAME = "__username";
    private static final String PROFILES = "__profile";
    private static final String CORRELATION_ID = "__correlation_id";
    private static final String ROUTING_KEY = "__routing_key";
    private static final String VERSION = "__version";
    private static final String AGGREGATE_TYPE = "__aggregate_type";
    private static final String AGGREGATE_ID = "__aggregate_id";
    private static final String EVENT_STREAM_VERSION = "__event_stream_version";
    private static final String SECURITY_TOKEN = "__security_token";
    private static final String PROCESS_MANAGER_ID = "__process_manager_id";
    private Map<String, Object> header;
    private T payload;


    public Event(T payload) {
        this(payload, payload.getClass().getName());
    }

    public Event(T payload, String eventType) {
        this(new HashMap<>(), payload, eventType);
    }

    public Event(Map<String, Object> header, T payload, String eventType) {
        this(header, payload, RoutingKey.from(eventType));
    }

    private Event(Map<String, Object> header, T payload, RoutingKey routingKey) {
        this.header = header;
        this.payload = payload;
        this.header.put(ROUTING_KEY, routingKey.toString());
    }

    @Override
    public void setUserInfo(DomainUser domainUser) {
        header.put(USERNAME, domainUser.getUsername());
        header.put(PROFILES, domainUser.getProfilesAsCommaSeparatedString());
    }

    @Override
    public DomainUser extractUserInfo() {
        if(!header.containsKey(USERNAME)) {
            return DomainUser.unknownUser();
        }
        return new DomainUser((String)header.get(USERNAME), commaSeparatedToList((String)header.get(PROFILES)));
    }

    @Override
    public void setSecurityToken(String securityToken) {
        if (Objects.isNull(securityToken)) {
            return;
        }
        this.header.put(SECURITY_TOKEN, securityToken);

    }

    @Override
    public String getSecurityToken() {
        if(header.containsKey(SECURITY_TOKEN)) {
            return (String)header.get(SECURITY_TOKEN);
        }
        return "";
    }

    public Event() {
        super();
    }

    private List<String> commaSeparatedToList(String commaSeparated) {
        return Arrays.asList(commaSeparated.split("\\s*,\\s*"));
    }

    @Override
    public void setVersion(ApplicationVersion applicationVersion) {
        this.header.put(VERSION, applicationVersion.getVersion());
    }

    @Override
    public ApplicationVersion getVersion() {
        return ApplicationVersion.of((String)header.get(VERSION));
    }

    @Override
    public void setCorrelationId(CorrelationId correlationId) {
        header.put(CORRELATION_ID, correlationId.value());
    }

    @Override
    public CorrelationId correlationId() {
        return CorrelationId.of((String)header.get(CORRELATION_ID));
    }


    @Override
    public RoutingKey getRoutingKey() {
        return RoutingKey.from((String)header.get(ROUTING_KEY));
    }

    public T getPayload() {
        return this.payload;
    }

    public Class<? extends DomainEventPayload> getPayloadClass() {
        return this.payload.getClass();
    }

    public String getId() {
        return getPayload().getTenantId() + ":" + getPayload().getEventUid();
    }

    public void setAggregateType(String aggregateType) {
        header.put(AGGREGATE_TYPE, aggregateType);
    }

    public String getAggregateType() {
        return (String)header.get(AGGREGATE_TYPE);
    }

    public void setAggregateId(String aggregateId) {
        header.put(AGGREGATE_ID, aggregateId);
    }

    public String getAggregateId() {
        return (String)header.get(AGGREGATE_ID);
    }

    public void setEventStreamVersion(long version) {
        header.put(EVENT_STREAM_VERSION, version);
    }

    public long getEventStreamVersion() {
        return (Long)header.get(EVENT_STREAM_VERSION);
    }

    public void setProcessManagerId(String processManagerId) {
        header.put(PROCESS_MANAGER_ID, processManagerId);
    }

    public String getProcessManagerId() {
        return (String)header.get(PROCESS_MANAGER_ID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event that = (Event) o;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}
