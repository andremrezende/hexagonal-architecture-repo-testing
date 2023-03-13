package br.com.rezende.kernel.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoutingKey {

    private final List<String> segments;

    private RoutingKey() {
        this.segments = new ArrayList<>();
    }

    private RoutingKey(List<String> segments) {
        this.segments = segments;
    }

    public static RoutingKey getKey() {
        return new RoutingKey();
    }

    public static RoutingKey from(String periodSeparatedKey) {
        return new RoutingKey(Arrays.asList(periodSeparatedKey.split("\\s*,\\s*")));
    }

    public RoutingKey addSegment(String segment) {
        segments.add(segment);
        return this;
    }

    public boolean matchesWith(RoutingKey otherHandlingKey) {
        return otherHandlingKey.toString().startsWith(this.toString());
    }

    @Override
    public String toString() {
        return String.join(".", segments).toLowerCase();
    }
}
