import bwapi.*;

//Implements the SCV Markov Chain
public class SCVManager {
	
	private Game game;
	private Player self;
	
	public enum State {
		HARVEST, BUILD
	} 
	
	State state;
	
	public SCVManager(Player self, Game game)
	{
		this.self = self;
		this.game = game;
		
		state = State.HARVEST;
	}
	
	public void update()
	{
		transitionCheck();
		
		//Ideally would have a state class so we can just call state.execute
		// however the number of states is very low
		if(state == State.HARVEST)
			harvest();
		else if(state == State.BUILD)
			build();
	}
	
	private void transitionCheck()
	{
		//probability stuff here
	}

	private void harvest()
	{
        for (Unit myUnit : self.getUnits()) 
        {
            //if it's a drone and it's idle, send it to the closest mineral patch
            if (myUnit.getType().isWorker() && myUnit.isIdle()) 
            {
                Unit closestMineral = null;

                //find the closest mineral
                for (Unit neutralUnit : game.neutral().getUnits()) 
                    if (neutralUnit.getType().isMineralField()) 
                        if (closestMineral == null || myUnit.getDistance(neutralUnit) < myUnit.getDistance(closestMineral)) 
                            closestMineral = neutralUnit;

                //if a mineral patch was found, send the drone to gather it
                if (closestMineral != null) 
                    myUnit.gather(closestMineral, false);
            }
        }
	}
	
	private void build()
	{
		
	}
	
	private void printInfo()
	{
		StringBuilder units = new StringBuilder("My units:\n");
		
		for (Unit myUnit : self.getUnits()) 
            units.append(myUnit.getType()).append(" ").append(myUnit.getTilePosition()).append("\n");
		
		game.drawTextScreen(10, 25, units.toString());
	}

}
