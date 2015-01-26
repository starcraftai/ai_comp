package markov;

import bwapi.Game;
import agent.Agent;

public class Building<T extends Agent> extends MarkovChainState<T> {

	 

	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent,
			double probabilityTransition) {
		// TODO Auto-generated method stub
		return null;
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
