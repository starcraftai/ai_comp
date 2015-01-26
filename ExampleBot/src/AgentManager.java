import java.util.ArrayList;

import bwapi.Unit;


public class AgentManager {
	ArrayList<Agent> agents;
	
	public void update() {
		for (Agent agent : agents) {
			// use Agent class to decide on next actions
		}
	}
	
	public void destroyUnit(Unit unit){
		for (int i = 0; i < agents.size(); i++) {
			if(agents.get(i).id == unit.getID()){
				agents.remove(i);
				break;
			}
		}
	}
}
