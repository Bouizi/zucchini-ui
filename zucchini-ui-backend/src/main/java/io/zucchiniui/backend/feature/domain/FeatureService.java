package io.zucchiniui.backend.feature.domain;

public interface FeatureService {

    void updateStatusFromScenarii(String featureId);

    void deleteByTestRunId(String testRunId);

    void deleteById(String featureId);

    Feature tryToMergeWithExistingFeature(Feature newFeature);

}
