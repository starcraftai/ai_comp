package markov;
import agent.Agent;
import agent.BuildOrder;
import bwapi.Game;
import bwapi.Unit;

public class Harvesting<T extends Agent> extends MarkovChainState<T> {

	
	public Harvesting()
	{
		 
	}
	
	 
	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters, WorldParameters worldParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters);
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent, double probabilityTransition,GaussianParameters gaussianParameters) {
		if (probabilityTransition > agent.currentProbability)
		{
			agent.currentProbability = probabilityTransition;
			gaussianParameters.x += 10; 
			return new Building<T>();
		}
 
		return this;
	}

	@Override
	protected void performAction(T agent, Game game,BuildOrder buildOrder, WorldParameters worldParameters) {
		 
		 Unit closestMineral = null;
		 Unit agentUnit = agent.unit;
		 
		 if (!agentUnit.isIdle()) return;
		 
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
