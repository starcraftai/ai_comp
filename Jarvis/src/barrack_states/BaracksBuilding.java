package barrack_states; 
import markov.DensityProbabilityCalculator;
import markov.GaussianParameters;
import markov.MarkovChainState;
import markov.WorldParameters;
import agent.Agent;
import agent.BuildOrder;
import bwapi.Game; 
import bwapi.UnitType;

public class BaracksBuilding<T extends Agent> extends MarkovChainState<T> {
	boolean startedTrainingUnit = false;
	boolean finishedTrainingUnit = false;
	public BaracksBuilding()
	{
		 
	}
	
	 
	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters, WorldParameters worldParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters);
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent, double probabilityTransition,GaussianParameters gaussianParameters) {
		if (finishedTrainingUnit) //hard trigger
			return new BarracksIdle<T>();
 
		return this;
	}

	@Override
	protected void performAction(T agent, Game game,BuildOrder buildOrder, WorldParameters worldParameters) {
		// building not ready or is already training a troop
		if(!agent.unit.isCompleted() || agent.unit.isTraining()) return;
		
		// building has completed training
		if(!agent.unit.isTraining() && startedTrainingUnit == true){
			// hard trigger next state
			finishedTrainingUnit = true;
			return;
		}
		
		agent.unit.train(UnitType.Terran_Marine);
		startedTrainingUnit = true;
	}
}
