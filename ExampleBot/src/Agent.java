import markov.MarkovChainState;

public abstract class Agent<T> {
	public MarkovChainState<SCV> markovChainState;
	public double currentProbability;
}
