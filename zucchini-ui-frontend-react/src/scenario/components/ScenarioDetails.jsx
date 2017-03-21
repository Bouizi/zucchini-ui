import React from 'react';

import Step from './Step';
import ActionStep from './ActionStep';
import SimpleText from '../../ui/components/SimpleText';


export default class ScenarioDetails extends React.PureComponent {

  render() {
    const { scenario } = this.props;

    const steps = scenario.steps.map((step, index) => {
      return (
        <Step key={index} step={step} />
      );
    });

    let backgroundSteps = [];
    if (scenario.background && scenario.background.steps) {
      backgroundSteps = scenario.background.steps.map((step, index) => {
        return (
          <Step key={index} step={step} special />
        );
      });
    }

    const beforeActions = scenario.beforeActions.map((action, index) => {
      return (
        <ActionStep key={index} index={index} name="Pré-action" action={action} />
      );
    })

    const afterActions = scenario.afterActions.map((action, index) => {
      return (
        <ActionStep key={index} index={index} name="Post-action" action={action} />
      );
    })

    return (
      <div>
        {scenario.comment && <SimpleText className="text-muted" text={scenario.comment} />}
        {beforeActions}
        {backgroundSteps}
        {steps}
        {afterActions}
      </div>
    );
  }

}

ScenarioDetails.propTypes = {
  scenario: React.PropTypes.object,
};
