package agent;
import markov.GaussianParameters;
import markov.Harvesting; 
import barrack_states.IdleBarracks;
import bwapi.Game;
import bwapi.Unit;


public class Barracks extends Agent {
	 
		
		public Barracks(Unit unit)
		{
			super.unit = unit;
			markovChainState = new IdleBarracks<Agent>();
			//markovChainState = new Harvesting<SCV>();
		}
		
		public void update(GaussianParameters gaussianParameters, Game game){
			
			markovChainState.update(this, gaussianParameters, game); 
			
		}
}
