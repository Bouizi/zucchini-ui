import PropTypes from 'prop-types';
import React from 'react';

import toNiceDate from '../../ui/toNiceDate';
import HistoryFilterContainer from '../../filters/components/HistoryFilterContainer';
import TestRunSelectorTableContainer from './TestRunSelectorTableContainer';


export default class TestRunDiffSelectorPage extends React.Component {

  static propTypes = {
    testRunId: PropTypes.string.isRequired,
    testRun: PropTypes.object,
    onLoad: PropTypes.func.isRequired,
  };

  componentDidMount() {
    this.loadTestRunDiffIfPossible();
  }

  componentDidUpdate(prevProps) {
    this.loadTestRunDiffIfPossible(prevProps);
  }

  loadTestRunDiffIfPossible(prevProps = {}) {
    const { testRunId } = this.props;

    if (testRunId !== prevProps.testRunId) {
      this.props.onLoad({ testRunId });
    }
  }

  render() {
    const { testRun, testRunId } = this.props;

    return (
      <div>
        <h1>Comparaison contre le tir du {toNiceDate(testRun.date)}</h1>

        <hr />

        <h2>Sélectionner un autre tir</h2>
        <HistoryFilterContainer />
        <TestRunSelectorTableContainer currentTestRunId={testRunId} />

      </div>
    );
  }
}
