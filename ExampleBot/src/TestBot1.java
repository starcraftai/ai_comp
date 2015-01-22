import bwapi.*;
import bwta.BWTA;

public class TestBot1 extends DefaultBWListener {

    private Mirror mirror = new Mirror();
    private Game game;
    private Player self;
    
    private SCVManager scvManager;

    public void run() {
        mirror.getModule().setEventListener(this);
        mirror.startGame();
    }

    @Override
    public void onUnitCreate(Unit unit) {
        System.out.println("New unit " + unit.getType());
    }

    @Override
    public void onStart() 
    {
        game = mirror.getGame();
        self = game.self();
        
        scvManager = new SCVManager(self, game);

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
    	scvManager.update();
    	
        //if there's enough minerals, train an SCV
        //if (myUnit.getType() == UnitType.Terran_Command_Center && self.minerals() >= 50) 
        //{
            //myUnit.train(UnitType.Terran_SCV);
        //}
    	
        game.setTextSize(10);
        game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace());
    }

    public static void main(String[] args) {
        new TestBot1().run();
    }
}