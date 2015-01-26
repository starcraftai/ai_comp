package agent; 
import markov.Harvesting; 
import markov.WorldParameters;
import bwapi.Game;
import bwapi.Unit;


public class SCV extends Agent {
	 
		
		
		public SCV(Unit unit)
		{
			super(unit);
			 
			markovChainState = new Harvesting<Agent>(); 
			currentProbability = 0.7;
		}
		
		@Override
		public void update(WorldParameters worldParameters, Game game,BuildOrder buildOrder){
			
			markovChainState.update(this,worldParameters, game, buildOrder); 
			
		}
}
