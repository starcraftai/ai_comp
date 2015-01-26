import markov.GaussianParameters;
import markov.Harvesting;
import markov.MarkovChainState;
import bwapi.Unit;


public class SCV {
		public Unit scv;
		
		public MarkovChainState<SCV> markovChainState;
		
		public double currentProbability;
		
		public SCV()
		{
			markovChainState = new Harvesting<SCV>();
		}
		
		public void update(GaussianParameters gaussianParameters){
			
			markovChainState =	markovChainState.GetNextState(this, gaussianParameters);
			
		}/**/
}
