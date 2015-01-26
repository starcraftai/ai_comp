package markov;
import agent.Agent;
import agent.BuildOrder;
import bwapi.Game; 


public abstract class MarkovChainState<T extends Agent> {
		
		protected double probability;
		
		@SuppressWarnings("unchecked")
		public void update(T agent,WorldParameters worldParameters,  Game game,BuildOrder buildOrder){
			probability = calculateProbability(buildOrder.peek().y, worldParameters);
			
			agent.markovChainState = (MarkovChainState<Agent>) getNextState(agent,probability);
			agent.currentProbability = probability;
	
			performAction(agent,game,buildOrder);
		}
	
		protected abstract MarkovChainState<T> getNextState(T agent, double probabilityTransition);
		
		protected abstract double calculateProbability(GaussianParameters gaussianParameters,WorldParameters worldParameters);
		 

		protected abstract void performAction(T agent, Game game,BuildOrder buildOrder);
}
