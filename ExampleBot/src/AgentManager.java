import java.util.ArrayList;
import java.util.Stack;

import util.Tuple;
import markov.GaussianParameters;
import markov.WorldParameters;
import agent.Agent;
import agent.BuildOrder;
import agent.BuildingType;
import bwapi.Game;
import bwapi.Player;
import bwapi.Unit;
import bwapi.UnitType;


public class AgentManager<T extends Agent> {
	ArrayList<T> agents;
	
	private Game game;
	private Player player;  
    private BuildOrder buildOrder;
    
	public AgentManager(Game game, Player player, BuildOrder buildOrder){
		this.game = game;
		this.player = player;
		this.buildOrder = buildOrder;
	}
	
	public void add(T agent)
	{
		agents.add(agent);
	}
	
	public void update(WorldParameters worldParameters) {
		
		for (T agent : agents) {
			agent.update(worldParameters, game);
		}
	}
	
	public void destroyUnit(T agent){ 
		agents.remove(agent);
	}
	
	public int AgentBuilding()
	{
		int counter = 0;
		
		for(Agent agent : agents)
		{
			if (agent.unit.getType() == UnitType.Terran_SCV && agent.unit.isConstructing())
			{ 
				counter++;
			}
		}
		
		return counter;
	}
	
	public void createUnit(Unit unit){
		// can't use switch/case, grumble grumble..
		if(unit.getType() == UnitType.Terran_Command_Center){
			
		}else if(unit.getType() == UnitType.Terran_SCV){
			
		} else if(unit.getType() == UnitType.Terran_Barracks){
			
		}
	}
}
