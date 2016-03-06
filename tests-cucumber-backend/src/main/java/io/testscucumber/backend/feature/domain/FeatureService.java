package io.testscucumber.backend.feature.domain;

public interface FeatureService {

    void calculateStatusFromScenarii(Feature feature);

    void updateStatusFromScenarii(String featureId);

    void deleteByTestRunId(String testRunId);

    void deleteById(String featureId);

    Feature tryToMergeWithExistingFeature(Feature newFeature);

    void updateScenariiWithFeatureTags(Feature feature);

}
