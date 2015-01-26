package markov;

import bwapi.Unit;

public class Harvesting<T> extends MarkovChainState<T> {

	@Override
	protected MarkovChainState<T> update(T t,
			double probabilityTransition) {
		 return null;
		 
	}

	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters);
	}

	
	 

}
