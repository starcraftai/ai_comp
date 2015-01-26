package markov;

public final class DensityProbabilityCalculator {
	
	
	public static double CalculateProbability(GaussianParameters gaussianParameters)
	{
		double numerator = - Math.pow(gaussianParameters.x - gaussianParameters.mean, 2);
		double denominator = 2*Math.pow(gaussianParameters.standardDeviation, 2);
		double densityDistribution = Math.exp(numerator/denominator);
		
		return gaussianParameters.x < gaussianParameters.mean ? 1 : densityDistribution;
	}
	
}
