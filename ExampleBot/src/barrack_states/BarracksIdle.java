package barrack_states;
import markov.Building;
import markov.DensityProbabilityCalculator;
import markov.GaussianParameters;
import markov.MarkovChainState;
import markov.WorldParameters;
import agent.Agent;
import agent.BuildOrder;
import bwapi.Game;
import bwapi.Unit;

public class BarracksIdle<T extends Agent> extends MarkovChainState<T> {

	
	public BarracksIdle()
	{
	 
	}
	
	 
	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters, WorldParameters worldParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters);
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent, double probabilityTransition,GaussianParameters gaussianParameters) {
		if (probabilityTransition > agent.currentProbability)
			return new BaracksBuilding<T>();
 
		return this;
	}

	@Override
	protected void performAction(T agent, Game game,BuildOrder buildOrder, WorldParameters worldParameters) {
		 
	}
}
