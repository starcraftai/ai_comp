package markov;
import agent.Agent;
import bwapi.Game; 


public abstract class MarkovChainState<T extends Agent> {
		
		protected double probability;
		
		@SuppressWarnings("unchecked")
		public void update(T agent,GaussianParameters gaussianParameters,WorldParameters worldParameters,  Game game){
			probability = calculateProbability(gaussianParameters, worldParameters);
			
			agent.markovChainState = (MarkovChainState<Agent>) getNextState(agent,probability);
			agent.currentProbability = probability;
	
			performAction(agent,game);
		}
	
		protected abstract MarkovChainState<T> getNextState(T agent, double probabilityTransition);
		
		protected abstract double calculateProbability(GaussianParameters gaussianParameters,WorldParameters worldParameters);
		 

		protected abstract void performAction(T agent, Game game);
}
