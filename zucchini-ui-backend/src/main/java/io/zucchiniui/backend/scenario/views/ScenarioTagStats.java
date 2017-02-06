package io.zucchiniui.backend.scenario.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.zucchiniui.backend.shared.domain.CompositeStatus;

public class ScenarioTagStats {

    private final String tag;

    private final ScenarioStats stats;

    @JsonCreator
    public ScenarioTagStats(@JsonProperty("tag") final String tag, @JsonProperty("stats") final ScenarioStats stats) {
        this.tag = tag;
        this.stats = stats;
    }

    public String getTag() {
        return tag;
    }

    public ScenarioStats getStats() {
        return stats;
    }

    public CompositeStatus getStatus() {
        return stats.computeCompositeStatus();
    }

}
