package io.zucchiniui.backend.feature.domainimpl;

import io.zucchiniui.backend.feature.domain.Feature;
import io.zucchiniui.backend.feature.domain.FeatureRepository;
import io.zucchiniui.backend.feature.domain.FeatureStatus;
import io.zucchiniui.backend.scenario.domain.Scenario;
import io.zucchiniui.backend.scenario.domain.ScenarioRepository;
import io.zucchiniui.backend.scenario.views.ScenarioStats;
import io.zucchiniui.backend.scenario.views.ScenarioViewAccess;
import io.zucchiniui.backend.support.ddd.PreparedQuery;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FeatureServiceImplTest {

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private FeatureRepository featureRepository;

    @Mock
    private ScenarioRepository scenarioRepository;

    @Mock
    private ScenarioViewAccess scenarioViewAccess;

    @InjectMocks
    private FeatureServiceImpl featureService;

    @Test
    public void should_calculate_status_from_scenarii() throws Exception {
        // given
        final Feature feature = mock(Feature.class);

        final ScenarioStats stats = mock(ScenarioStats.class);
        given(scenarioViewAccess.getStats(any())).willReturn(stats);

        final FeatureStatus featureStatus = FeatureStatus.FAILED;
        given(stats.computeFeatureStatus()).willReturn(featureStatus);

        // when
        // FIXME Test
        // featureService.calculateStatusFromScenarii(feature);

        // then
        verify(scenarioViewAccess).getStats(any());
        verify(stats).computeFeatureStatus();

        verify(feature).setStatus(featureStatus);
    }

    @Test
    public void should_update_status_from_scenarii() throws Exception {
        // given
        final String featureId = "featureId";

        final Feature feature = mock(Feature.class);
        given(featureRepository.getById(featureId)).willReturn(feature);

        final ScenarioStats stats = mock(ScenarioStats.class);
        given(scenarioViewAccess.getStats(any())).willReturn(stats);

        final FeatureStatus featureStatus = FeatureStatus.FAILED;
        given(stats.computeFeatureStatus()).willReturn(featureStatus);

        // when
        featureService.updateStatusFromScenarii(featureId);

        // then
        verify(featureRepository).getById(featureId);
        verify(scenarioViewAccess).getStats(any());
        verify(stats).computeFeatureStatus();
        verify(featureRepository).save(feature);

        verify(feature).setStatus(featureStatus);
    }

    @Test
    public void should_delete_feature_by_test_run_id() throws Exception {
        // given
        final String testRunId = "testRunId";

        final PreparedQuery<Feature> featureQuery = mock(PreparedQuery.class, "featureQuery");
        given(featureRepository.query(any())).willReturn(featureQuery);

        final PreparedQuery<Scenario> scenarioQuery = mock(PreparedQuery.class, "scenarioQuery");
        given(scenarioRepository.query(any())).willReturn(scenarioQuery);

        // when
        featureService.deleteByTestRunId(testRunId);

        // then
        // FIXME Add tests
        // verify(featureQuery).delete();
        // verify(scenarioQuery).delete();
    }

    @Test
    public void should_delete_feature_by_id() throws Exception {
        // given
        final String featureId = "featureId";

        final Feature feature = mock(Feature.class);
        given(featureRepository.getById(featureId)).willReturn(feature);

        final PreparedQuery<Scenario> scenarioQuery = mock(PreparedQuery.class, "scenarioQuery");
        given(scenarioRepository.query(any())).willReturn(scenarioQuery);

        // when
        featureService.deleteById(featureId);

        // then
        // FIXME Add tests
        // verify(scenarioQuery).delete();
        verify(featureRepository).delete(feature);
    }

}
