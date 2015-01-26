package markov;
import agent.Agent;
import bwapi.Game;
import bwapi.Unit;

public class Harvesting<T extends Agent> extends MarkovChainState<T> {

	
	public Harvesting()
	{
		probability = 0.8; // High number. An scv should always harvest
	}
	
	 
	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters);
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent,
			double probabilityTransition) {
		if (probabilityTransition > probability)
			return new Building<T>();
 
		return this;
	}

	@Override
	protected void performAction(T agent, Game game) {
		 
		 Unit closestMineral = null;
		 Unit agentUnit = agent.unit;
         //find the closest mineral
         for (Unit neutralUnit : game.neutral().getUnits()) 
             if (neutralUnit.getType().isMineralField()) 
                 if (closestMineral == null || agentUnit.getDistance(neutralUnit) < agentUnit.getDistance(closestMineral)) 
                     closestMineral = neutralUnit;

         //if a mineral patch was found, send the drone to gather it
         if (closestMineral != null) 
        	 agentUnit.gather(closestMineral, false);
	}

	
	 

}
