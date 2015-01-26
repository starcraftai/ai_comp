package markov;

import bwapi.Game;
import agent.Agent;

public class Building<T extends Agent> extends MarkovChainState<T> {

	 
	
	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters, WorldParameters worldParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters) / (worldParameters.buildingScvs + 1);
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent, double probabilityTransition) {
		
		if (agent.unit.isConstructing()) return this;
		 
		if (probabilityTransition > agent.currentProbability) return this;
		
		return new Harvesting<T>();
		 
	}

	@Override
	protected void performAction(T agent, Game game) {
		
	}
	
	/**
	 * looks for an open space, xSize * ySize, to construct a building at least one tile away from other buildings
	 * 
	 * @param xSize horizontal tiles
	 * @param ySize vertical tiles
	 */
	private void searchForOpenSpace(int xSize, int ySize) {
		
	}
}
