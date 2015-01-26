package agent;
import markov.GaussianParameters;
import markov.Harvesting; 
import bwapi.Game;
import bwapi.Unit;


public class SCV extends Agent {
	 
		
		public SCV(Unit unit)
		{
			super.unit = unit;
			markovChainState = new Harvesting<Agent>();
			//markovChainState = new Harvesting<SCV>();
		}
		
		public void update(GaussianParameters gaussianParameters, Game game){
			
			markovChainState.update(this, gaussianParameters, game); 
			
		}
}
