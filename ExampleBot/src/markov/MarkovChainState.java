package markov;
import util.Tuple;
import agent.Agent;
import agent.BuildOrder;
import bwapi.Game; 
import bwapi.UnitType;


public abstract class MarkovChainState<T extends Agent> {
		 
		
		@SuppressWarnings("unchecked")
		public void update(T agent, WorldParameters worldParameters,  Game game,BuildOrder buildOrder){
			Tuple<UnitType,GaussianParameters> param = buildOrder.peek();
			GaussianParameters p = null;
			if (param == null)
				p = new GaussianParameters();
			else 
				p = param.t2;
			
			double probability = calculateProbability( p , worldParameters);
			
			agent.markovChainState = (MarkovChainState<Agent>) getNextState(agent,probability,p);
			 
			agent.markovChainState.performAction(agent,game,buildOrder, worldParameters);
		}
	
		protected abstract MarkovChainState<T> getNextState(T agent, double probabilityTransition, GaussianParameters gaussianParameter);
		
		protected abstract double calculateProbability(GaussianParameters gaussianParameters, WorldParameters worldParameters);
		 

		protected abstract void performAction(T agent, Game game,BuildOrder buildOrder, WorldParameters worldParameters);
}
