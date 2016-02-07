package io.testscucumber.backend.reportconverter.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;

public class ReportFeature extends CucumberElement {

    private String id;

    @JsonProperty("uri")
    private String filename;

    private List<ReportFeatureElement> elements = new ArrayList<>();

    private String description;

    private List<Tag> tags = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public List<ReportFeatureElement> getElements() {
        return elements;
    }

    public void setElements(final List<ReportFeatureElement> elements) {
        this.elements = elements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(final List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    protected MoreObjects.ToStringHelper createToStringHelper() {
        return super.createToStringHelper()
            .add("id", id)
            .add("filename", filename)
            .add("size of elements", elements.size());
    }

}
