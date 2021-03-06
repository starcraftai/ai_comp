package markov;

import agent.Agent;
import agent.BuildOrder;
import bwapi.Game;
import bwapi.Position;
import bwapi.TilePosition;
import bwapi.Unit;
import bwapi.UnitType;

public class Building<T extends Agent> extends MarkovChainState<T> {
	private static final int MAX_SEARCH_RADIUS = 40;
	
	@Override
	protected double calculateProbability(GaussianParameters gaussianParameters, WorldParameters worldParameters) {
		return DensityProbabilityCalculator.CalculateProbability(gaussianParameters) / (worldParameters.buildingScvs + 1);
	}

	@Override
	protected MarkovChainState<T> getNextState(T agent, double probabilityTransition,GaussianParameters gaussianParameters) {
		
		if (agent.unit.isConstructing() || agent.unit.isIdle() || agent.unit.isMoving()) return this;
		
		if (agent.isBuilding) return this;
		
		if (probabilityTransition >= agent.currentProbability) return this;
		
		return new Harvesting<T>();
		 
	}

	@Override
	protected void performAction(T agent, Game game, BuildOrder buildOrder, WorldParameters worldParameters)  {
		 
		
		if (agent.unit.isConstructing() || agent.unit.isMoving()) return;
		
		//select suitable building from list and run TilePosition to find suitable build location
		if (buildOrder.isEmpty()) return;
		
		if (worldParameters.minerals < 100) return;
		
		UnitType unitType =  buildOrder.dequeue().t1;
		TilePosition tilePosition = searchForOpenSpace(game,unitType, agent.unit);
		 
		game.printf("Building " + unitType.toString() + " - at: (" + Integer.toString(tilePosition.getX()) + "," + Integer.toString(tilePosition.getY())+")" );
		agent.unit.build(tilePosition, unitType);
		
		agent.isBuilding = true;
				
	}
	
	private TilePosition searchForOpenSpace(Game game, UnitType building, Unit builder) {
		// find location of command centre
		Unit commandCentre = null;
		for (Unit unit : game.getAllUnits()) {
			if(unit.getType() == UnitType.Terran_Command_Center){
				commandCentre = unit;
				break;
			}
		}
		// we've probably lost at this point
		if(commandCentre == null){
			game.printf("Cannot find Command Centre");
			return null;
		}

		// ugly loop to search outwards from start location
		boolean found = false;
		TilePosition buildPos = null;
		TilePosition initialPos = commandCentre.getInitialTilePosition();
		 for (int r = 1; r < MAX_SEARCH_RADIUS && !found; r++) {
			int y = initialPos.getY() - r;
			for (int x = initialPos.getX() - r; x <= initialPos.getX() + r && !found; x++) {
				found =  game.canBuildHere(builder, new TilePosition(x, y), building);
				if(found) buildPos = new TilePosition(x, y); 
			}
			
			y = initialPos.getY() + r;
			for (int x = initialPos.getX() - r; x <= initialPos.getX() + r && !found; x++) {
				found =  game.canBuildHere(builder, new TilePosition(x, y), building);
				if(found) buildPos = new TilePosition(x, y);
			}
			
			int x = initialPos.getX() - r;
			for (y = initialPos.getY() - r + 1; y < initialPos.getY() + r && !found; y++) {
				found =  game.canBuildHere(builder, new TilePosition(x, y), building);
				if(found) buildPos = new TilePosition(x, y);
			}
			
			x = initialPos.getX() + r;
			for (y = initialPos.getY() - r + 1; y < initialPos.getY() + r && !found; y++) {
				found =  game.canBuildHere(builder, new TilePosition(x, y), building);
				if(found) buildPos = new TilePosition(x, y);
			}
			
		}
		if(buildPos == null) game.printf("Cannot find suitabe build position");
		return buildPos;
	}
}
	

