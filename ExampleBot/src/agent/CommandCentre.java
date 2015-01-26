package agent;
import command_centre_states.CSIdle;

import markov.GaussianParameters;
import markov.Harvesting; 
import barrack_states.BarracksIdle;
import bwapi.Game;
import bwapi.Unit;


public class CommandCentre extends Agent {
	 
		
		public CommandCentre(Unit unit)
		{
			super.unit = unit;
			markovChainState = new CSIdle<Agent>();
			//markovChainState = new Harvesting<SCV>();
		}
		
		public void update(GaussianParameters gaussianParameters, Game game){
			
			markovChainState.update(this, gaussianParameters, game); 
			
		}
}
