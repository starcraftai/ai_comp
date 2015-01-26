package agent;

import java.util.Stack;

import bwapi.UnitType;
import markov.GaussianParameters;
import util.Tuple;

public class BuildOrder {
	

    private Stack<Tuple<UnitType,GaussianParameters>> buildOrder;
    
    public BuildOrder()
    {
    	buildOrder = new Stack<Tuple<UnitType,GaussianParameters>>();
    }
    
    public void add(Tuple<UnitType,GaussianParameters> item)
    {
    	buildOrder.add(item);
    }
    
    public Tuple<UnitType,GaussianParameters> dequeue(){
    	return buildOrder.pop();
    }
    
    public Tuple<UnitType,GaussianParameters> peek()
    {
    	return buildOrder.peek();
    }
}
