package agent;
import markov.GaussianParameters;
import markov.Harvesting; 
import markov.WorldParameters;
import barrack_states.BarracksIdle;
import bwapi.Game;
import bwapi.Unit;


public class Barracks extends Agent {
	 
		
		public Barracks(Unit unit)
		{
			super(unit); 
			markovChainState = new BarracksIdle<Agent>();
			//markovChainState = new Harvesting<SCV>();
		}
		
	 

		@Override
		public void update(WorldParameters worldParameters, Game game, BuildOrder buildOrder) {
			markovChainState.update(this,worldParameters, game, buildOrder); 
			
		}
}
