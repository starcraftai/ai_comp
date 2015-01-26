import java.util.ArrayList;

import agent.Agent;
import bwapi.Game;
import bwapi.Player;
import bwapi.Unit;
import bwapi.UnitType;


public class AgentManager {
	ArrayList<Agent> agents;
	
	private Game game;
	private Player player; 
	
	public AgentManager(Game game, Player player){
		this.game = game;
		this.player = player;
	}
	
	public void update() {
		for (Agent agent : agents) {
			// use Agent class to decide on next actions
		}
	}
	
	public void destroyUnit(Unit unit){
		// override .equals to allow for removal with unit input?
		agents.remove(unit);
		
		//otherwise iterate through and remove unit with matching id?
		/*for (int i = 0; i < agents.size(); i++) {
		if(agents.get(i).id == unit.getID()){
			agents.remove(i);
			break;
		}
		}*/
	}
	
	public void createUnit(Unit unit){
		// can't use switch/case, grumble grumble..
		if(unit.getType() == UnitType.Terran_Command_Center){
			
		}else if(unit.getType() == UnitType.Terran_SCV){
			
		} else if(unit.getType() == UnitType.Terran_Barracks){
			
		}
	}
}
