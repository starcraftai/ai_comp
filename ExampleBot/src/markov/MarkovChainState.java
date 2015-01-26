package markov;
import agent.Agent;
import bwapi.Game; 


public abstract class MarkovChainState<T extends Agent> {
		
		protected double probability;
		
		@SuppressWarnings("unchecked")
		public void update(T agent,GaussianParameters gaussianParameters, Game game){
			probability = calculateProbability(gaussianParameters);
			agent.markovChainState = (MarkovChainState<Agent>) getNextState(agent,probability);
			
			performAction(agent,game);
			
			
		}
	
		protected abstract MarkovChainState<T> getNextState(T agent, double probabilityTransition);
		
		protected abstract double calculateProbability(GaussianParameters gaussianParameters);
		 

		protected abstract void performAction(T agent, Game game);
}
