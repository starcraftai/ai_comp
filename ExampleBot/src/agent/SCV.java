package agent;
import markov.GaussianParameters;
import markov.Harvesting; 
import markov.WorldParameters;
import bwapi.Game;
import bwapi.Unit;


public class SCV extends Agent {
	 
		
		public SCV(Unit unit)
		{
			super(unit);
			 
			markovChainState = new Harvesting<Agent>(); 
		}
		
		@Override
		public void update(WorldParameters worldParameters, Game game,BuildOrder buildOrder){
			
			markovChainState.update(this, gaussianParameters, worldParameters, game, buildOrder); 
			
		}
}
