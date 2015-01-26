package markov;
import bwapi.Unit;


public abstract class MarkovChainState<T> {
		
		protected double probability;
		
		public MarkovChainState<T> GetNextState(T unit,GaussianParameters gaussianParameters){
			probability = calculateProbability(gaussianParameters);
			
			return update(unit);
		}
	
		protected abstract MarkovChainState<T> update(T unit, double probabilityTransition);
		
		protected abstract double calculateProbability(GaussianParameters gaussianParameters);
		 
	
}
