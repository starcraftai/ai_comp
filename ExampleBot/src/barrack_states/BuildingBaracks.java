package barrack_states;
import markov.Building;
import markov.DensityProbabilityCalculator;
import markov.GaussianParameters;
import markov.MarkovChainState;
import markov.WorldParameters;
import agent.Agent;
import bwapi.Game;
import bwapi.Unit;

public class BuildingBaracks<T extends Agent> extends MarkovChainState<T> {
	boolean startedTrainingUnit = false;
	
	public BuildingBaracks()
	{
		probability = 0.8; // High number. An scv should always harvest
	}
	
	 
	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters, WorldParameters worldParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters);
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent, double probabilityTransition) {
		if (probabilityTransition > probability)
			return new IdleBarracks<T>();
 
		return this;
	}

	@Override
	protected void performAction(T agent, Game game) {
		// building not ready to build a troop 
		if(!agent.unit.isCompleted() || agent.unit.isTraining()) return;
		
		if(!agent.unit.isTraining() && startedTrainingUnit = true){
			// hard trigger next state
		}
		 
	}
}
