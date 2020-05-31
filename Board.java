import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    public Space[] boardSpaces = new Space[40];
    public Dice dice = new Dice();
    public ChanceDeck chanceDeck = new ChanceDeck();
    public BCAChest chestDeck = new BCAChest();
    public Player[] players;
    public int lastRoll;
    //Can we make ArrayLists here?
    //we can use this list to redisplay the board and keep track of 
    //where pieces are moving
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        super(1000, 1000, 1); 
        startGame();
        //filling the board with the correct spaces
        //boardSpaces[0] = (Space) Go();
        //boardSpaces[10] = (Space) Jail();
        //boardSpaces[20] = (Space) Free();
        //boardSpaces[30] = (Space) GoToJail();
        int x = 860;
        int y = 880;
        
        Property a = new Property("", 0, new int[1], 0, 0, 0, "");
        addObject(a, x, y);
        
        int interval = 70;
        
        for(int i = 1; i < 10; i++) {
            x -= interval;
            if(i == 1) {
                x -= 5;
            }
            a = new Property("", i, new int[1], 0, 0, 0, "");
            addObject(a, x, y);
            
        }
        
        x -= 73;
        a = new Property("", 10, new int[1], 0, 0, 0, "");
        addObject(a, x, y);
        
        for(int i = 11; i < 20; i++) {
            y -= interval;
            if(i == 11) {
                y -= 5;
            }
            a = new Property("", i, new int[1], 0, 0, 0, "");
            a.setRotation(90);
            addObject(a, x, y);
            
        }
        
        y -= interval;
        a = new Property("", 20, new int[1], 0, 0, 0, "");
        addObject(a, x, y);
        
        for(int i = 21; i < 30; i++) {
            if(i == 21) {
                x += 5;
            }
            x += interval;
            a = new Property("", i, new int[1], 0, 0, 0, "");
            a.setRotation(180);
            addObject(a, x, y);
            
        }
        
        x += interval;
        a = new Property("", 30, new int[1], 0, 0, 0, "");
        addObject(a, x, y);
        
        for(int i = 31; i < 40; i++) {
            if(i == 31) {
                y += 5;
            }
            y += interval;
            a = new Property("", i, new int[1], 0, 0, 0, "");
            a.setRotation(270);
            addObject(a, x, y);
            
        }
        
    }
    
    public void startGame(){
        //starts game asking for how many players, their names and tokens
        //creates players with this information
    }
    
    public void play(){
        while(players.length > 1){
            for (int player = 0; player < players.length; player++){
                if (players.length == 1)
                    break;
		int evens = 0;
		boolean odd = false;
		while (!odd && evens < 3){
		    RollButton rb = new RollButton();
		    addObject(rb, 900, 900);
		    showText("Roll!", 900, 900);
		    if(Greenfoot.mousePressed(rb)) {
            	    	lastRoll = dice.roll(); 
        	    }
		    removeObject(rb);

		    if (lastRoll % 2 == 0)
			evens++;
		    else
			odd = true;

		    if (evens == 3){
			players[player].goToJail();
			break;
		    }

		    for (int space = 0; space < lastRoll; space++){
			players[player].moveOneSpace();
			if (players[player].getCurrentSpace() == 0)
				players[player].addMoney(((Go)boardSpaces[0]).getBonus());
		    }
		    //What space did they land on?
		    Space curSpace = boardSpaces[players[player].getCurrentSpace()];
		    String spaceType = curSpace.getType();
		    if (spaceType.equals("property")){
				if (((Property) curSpace).getOwner().equals(null)){
					//property then asks if player wants to buy (allows if enough $)
				}
				else{
					((Property) curSpace).collectRent(players[player]);
				}

				if (((Property) curSpace).getOwner().equals(players[player])){
					//check if they own all other things of that color
					//and the houses work out, offer to build house or 
					//hotel
				}
		    }
		    else if (spaceType.equals("utility")){
				if (((Utility) curSpace).getOwner().equals(null)){
					//property then asks if player wants to buy (allows if enough $)
				}
				else{
					((Utility) curSpace).collectRent(players[player], lastRoll);
				}
		    }
		    else if (spaceType.equals("railroad")){
				if (((Railroad) curSpace).getOwner().equals(null)){
					//property then asks if player wants to buy (allows if enough $)
				}
				else{
					((Railroad) curSpace).collectRent(players[player]);
				}
		    }
		    else if (spaceType.equals("chance")){
				chanceDeck.draw();
		    }
		    else if (spaceType.equals("chest")){
				chestDeck.draw();
		    }
		    else if (spaceType.equals("tax")){
			((Taxes) curSpace).collectTax(players[player]);
			//later make condition for if they don't have any money left
			//that they need to mortgage
		    }
		    else if (spaceType.equals("gotojail")){
			players[player].goToJail();
		    }
		}
            }
        }

        //we wont due player-player trading for now
        //jail protocol
            //ask if they want to use get out of jail if they have it
            //if they have ask for $50
            //3 next moves let them try to "roll-out" of it (have to roll even)
            //if they fail, force 50 even if they go bankrupt
            //if they got out of jail, move them to "just visiting"
    }
}