package agent;
import bwapi.Unit;
import markov.MarkovChainState;
 
 
public abstract class Agent  {
	public MarkovChainState<Agent> markovChainState;
	public double currentProbability;
	public Unit unit;
	 
}
