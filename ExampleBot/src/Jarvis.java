import java.util.Map;
import java.util.Stack;

import util.Tuple;
import markov.GaussianParameters;
import markov.WorldParameters;
import agent.BuildOrder;
import agent.BuildingType;
import agent.SCV;
import bwapi.*;
import bwta.BWTA;

public class Jarvis extends DefaultBWListener {

    private Mirror mirror = new Mirror();
    private Game game;
    private Player self;
    
    private AgentManager<SCV> agentManager; 
    
    public void run() {
        mirror.getModule().setEventListener(this);
        mirror.startGame();
    }

    @Override
    public void onUnitCreate(Unit unit) {
        //System.out.println("New unit " + unit.getType());
    	
    	if (unit.getType() != UnitType.Terran_SCV) return;
    	
    	SCV scv = new SCV(unit);
    	agentManager.add(scv);
    }
    
    
    @Override
    public void onUnitDestroy(Unit unit){

    }
    
    @Override
    public void onStart() 
    {
        game = mirror.getGame();
        self = game.self();
        
       BuildOrder buildOrder = new BuildOrder(); 
        
        GaussianParameters supplyDepotGaussian = new GaussianParameters();
        supplyDepotGaussian.mean = 1.88;
        supplyDepotGaussian.standardDeviation = 2.8;
        buildOrder.add(new Tuple<UnitType,GaussianParameters>(UnitType.Terran_Supply_Depot, supplyDepotGaussian));
        
        GaussianParameters barrackGaussian = new GaussianParameters();
         
        buildOrder.add(new Tuple<UnitType,GaussianParameters>(UnitType.Terran_Barracks, barrackGaussian));
        
        agentManager = new AgentManager<SCV>(game, self, buildOrder);
        //Use BWTA to analyze map
        //This may take a few minutes if the map is processed first time!
        System.out.println("Analyzing map...");
        BWTA.readMap();
        BWTA.analyze();
        System.out.println("Map data ready");

    }

    @Override
    public void onFrame() 
    {
    	WorldParameters worldParameters = new WorldParameters();
    	
    	worldParameters.buildingScvs = agentManager.AgentBuilding();
    	worldParameters.supplyUsed = self.supplyUsed();
    	worldParameters.supplyTotal = self.supplyTotal();
    			
    	 
    			
    	agentManager.update(worldParameters);
    	
    	for (Unit myUnit : self.getUnits()) {
    		//if there's enough minerals, train an SCV
	        if (myUnit.getType() == UnitType.Terran_Command_Center && self.minerals() >= 50) 
	        {
	        	if (!myUnit.isTraining())
	        		myUnit.train(UnitType.Terran_SCV);
	        }
        }
    	
        game.setTextSize(10);
        game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace());
    }
 
    
    public static void main(String[] args) {
        new Jarvis().run();
    }
}