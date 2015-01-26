package agent;
import command_centre_states.CSIdle;
import markov.GaussianParameters;
import markov.Harvesting; 
import markov.WorldParameters;
import barrack_states.BarracksIdle;
import bwapi.Game;
import bwapi.Unit;


public class CommandCentre extends Agent {
	 
		
		public CommandCentre(Unit unit)
		{
			super(unit);
			markovChainState = new CSIdle<Agent>(); 
		}
		
		public void update(WorldParameters worldParameters, Game game,BuildOrder buildOrder){
			
			markovChainState.update(this, worldParameters, game, buildOrder); 
			
		}
}
