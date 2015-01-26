import bwapi.Unit;
import markov.MarkovChainState;

public abstract class Agent {
	
	protected MarkovChainState<Agent> markovChainState;
	protected double currentProbability;
	protected Unit unit;
}
