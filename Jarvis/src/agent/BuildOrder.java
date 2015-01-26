package agent;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import bwapi.UnitType;
import markov.GaussianParameters;
import util.Tuple;

public class BuildOrder {
	

    private Queue<Tuple<UnitType,GaussianParameters>> buildOrder;
    
    public BuildOrder()
    {
    	buildOrder = new ArrayDeque<Tuple<UnitType,GaussianParameters>>();
    }
    
    public void add(Tuple<UnitType,GaussianParameters> item)
    {
    	buildOrder.add(item);
    }
    
    public Tuple<UnitType,GaussianParameters> dequeue(){
    	return buildOrder.poll();
    }
    
    public Tuple<UnitType,GaussianParameters> peek()
    {
    	return buildOrder.peek();
    }
    
    public boolean isEmpty(){
    	return buildOrder.isEmpty();
    }
}
