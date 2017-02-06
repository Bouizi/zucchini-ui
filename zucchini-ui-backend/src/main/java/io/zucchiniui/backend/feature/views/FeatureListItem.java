package io.zucchiniui.backend.feature.views;

import io.zucchiniui.backend.shared.domain.CompositeStatus;
import io.zucchiniui.backend.scenario.views.ScenarioStats;
import io.zucchiniui.backend.shared.domain.BasicInfo;

public class FeatureListItem {

    private String id;

    private String testRunId;

    private BasicInfo info;

    private String group;

    private CompositeStatus status;

    private ScenarioStats stats;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTestRunId() {
        return testRunId;
    }

    public void setTestRunId(final String testRunId) {
        this.testRunId = testRunId;
    }

    public BasicInfo getInfo() {
        return info;
    }

    public void setInfo(final BasicInfo info) {
        this.info = info;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(final String group) {
        this.group = group;
    }

    public CompositeStatus getStatus() {
        return status;
    }

    public void setStatus(final CompositeStatus status) {
        this.status = status;
    }

    public ScenarioStats getStats() {
        return stats;
    }

    public void setStats(final ScenarioStats stats) {
        this.stats = stats;
    }

}
