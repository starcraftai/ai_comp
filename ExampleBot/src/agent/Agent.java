package agent;
import bwapi.Game;
import bwapi.Unit;
import markov.GaussianParameters;
import markov.MarkovChainState;
import markov.WorldParameters;
 
 
public abstract class Agent  {
	
	public GaussianParameters gaussianParameters;
	public MarkovChainState<Agent> markovChainState;
	public double currentProbability;
	public Unit unit;
	public boolean isBuilding;
	 
	public abstract void update(WorldParameters worldParameters, Game game, BuildOrder buildOrder);
	
	protected Agent(Unit unit){ 
		this.unit = unit;
		currentProbability = 0.0;
	}
}
