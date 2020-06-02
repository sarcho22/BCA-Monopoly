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
    public Player turn; //sorry I added this to keep track of whose turn it is
    public int lastRoll;
    //we can use this list to redisplay the board and keep track of 
    //where pieces are moving
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        super(1100, 700, 1); 
        startGame();
        //filling the board with the correct spaces
        //boardSpaces[0] = (Space) Go();
        //boardSpaces[10] = (Space) Jail();
        //boardSpaces[20] = (Space) Free();
        //boardSpaces[30] = (Space) GoToJail();
        int x = 605;
        int y = 640;
        
        Property a = new Property("", 0, 0, 0, 0);
        addObject(a, x, y);
        
        int interval = 56;
        
        for(int i = 1; i < 10; i++) {
            x -= interval;
            if(i == 1) {
                x -= 4;
            }
            a = new Property("", i, 0, 0, 0);
            addObject(a, x, y);
            
        }
        
        x -= interval+4;
        a = new Property("", 10, 0, 0, 0);
        addObject(a, x, y);
        
        for(int i = 11; i < 20; i++) {
            y -= interval;
            if(i == 11) {
                y -= 4;
            }
            a = new Property("", i, 0, 0, 0);
            a.setRotation(90);
            addObject(a, x, y);
            
        }
        
        y -= interval+4;
        a = new Property("", 20, 0, 0, 0);
        addObject(a, x, y);
        
        for(int i = 21; i < 30; i++) {
            if(i == 21) {
                x += 4;
            }
            x += interval;
            a = new Property("", i, 0, 0, 0);
            a.setRotation(180);
            addObject(a, x, y);
            
        }
        
        x += interval+4;
        a = new Property("", 30, 0, 0, 0);
        addObject(a, x, y);
        
        for(int i = 31; i < 40; i++) {
            if(i == 31) {
                y += 3;
            }
            y += interval;
            a = new Property("", i, 0, 0, 0);
            a.setRotation(270);
            addObject(a, x, y);
            
        }
        
    }
    
    public void startGame(){
        //starts game asking for how many players, their names and tokens
        //creates players with this information
        
        // ^^^ i think we can do the above in the StartingMenu world
        // for the tokens, later as a step 2 goal, i wanna make it so that instead of just
        // clicking the token they want, we can press arrow buttons on left and right
        // to scroll to the next token cuz i think that would be cool :3
    }
    
    public void play() {
        //while more than one player remains (bankrupted people are removed) 
        //continue playing
        while(players.length > 1){
            //cycles through the players, allowing them to take turns one by one
            for (int player = 0; player < players.length; player++) {
                turn = turn; //the player whose turn it is
                //the if makes sure that there are still enough people not 
                //bankrupt to play (because the amount of players can
                //change within the for loop)
                if (players.length == 1) {
                    break;
                }
                //next we set up some variables to keep track of 
                //the player rolling odds/evens
                int evens = 0;
                boolean odd = false;
                //while they haven't rolled three evens the player can take their turn
                while (!odd && evens < 3) {
                    //this button will allow a player to roll the dice
                    //it will be in the side bar
                    RollButton rb = new RollButton();
                    addObject(rb, 900, 900); // random coordinates at the moment
                    showText("Roll!", 900, 900);
                    //this is probably done a little wrong, I want it 
                    //to continuously check for the player
                    //clicking on it until they finally do
                    if(Greenfoot.mousePressed(rb)) {
                        lastRoll = dice.roll(); 
                    }
                    removeObject(rb); // I remove the button, 
                    //but it would probably be easier to gray it out
                    
                    //checks if the player rolled enough
                    //evens to get in jail
                    //if yes, sends them to jail and breaks from the 
                    //while-loop that is their turn
                    if (lastRoll % 2 == 0) {
                        evens++;
                    }
                    else {
                        odd = true;
                    }
                    if (evens == 3){
                        turn.goToJail();
                        break;
                    }
                    
                    //moves player forward one space at a time
                    //checks if you pass go and gives you 200
                    for (int space = 0; space < lastRoll; space++) {
                        turn.moveOneSpace();
                        if (turn.getCurrentSpace() == 0) {
                            turn.addMoney(((Go)boardSpaces[0]).getBonus());
                        }
                    }
                    
                    // define some variables relating to which space they landed on
                    Space curSpace = boardSpaces[turn.getCurrentSpace()];
                    String spaceType = curSpace.getType();
                    //depending on space type, they can make their turn
                    if (spaceType.equals("property")){
                        if (((Property) curSpace).getOwner().equals(null)){
                            // the property has no owner
                            //it asks if player wants to buy (allows if enough $)
                        }
                        else{
                            //otherwise the property collects rent
                            ((Property) curSpace).collectRent(turn);
                        }
                        //if the player owns the property they are on
                        //MOST OF THIS CAN BE CODED IN PLAYER
                        //for example, if we made a method that 
                        //would check for monopolies
                        if (((Property) curSpace).getOwner().equals(turn)){
                            // checks property color
                            String color = ((Property)curSpace).COLORS[turn.getCurrentSpace()];
                            int fullSet; //the number of properties of the color required for a monopoly
                            if (color.equals("brown") || color.equals("dark_blue")) {
                                fullSet = 2;
                            }
                            else {
                                fullSet = 3;
                            }
                            //finds how many properties of the same color the player owns
                            int count = 0;
                            for (int i : turn.playerProperties) {
                                Property p = ((Property)boardSpaces[i]);
                                if (p.color.equals(color)) {
                                    count++;
                                }
                            }
                            //if they have a monopoly and the correct conditions
                            //need to ask if enough money here (maybe)
                            if (count == fullSet) {
                                if (((Property)curSpace).numHouses < 4) {
                                    //offer to buildHouse
                                }
                                else if (!((Property)curSpace).hotel) {
                                    //offer to buildHotel
                                }
                            }
                        }
                    }
                    else if (spaceType.equals("utility")) {
                        if (((Utility) curSpace).getOwner().equals(null)){
                            //asks if player wants to buy (allows if enough $)
                        }
                        else {
                            //we want to check if the owner of the property owns both utilities
                            int numUtils = 0;
                            int[] propList = ((Utility) curSpace).getOwner().playerProperties;
                            for (int i = 0; i < propList.length; i++){
                                if (boardSpaces[propList[i]].getType().equals("utility")){
                                    numUtils++;
                                }
                            }
                            //we set the variables in the Player owner
                            //to indicate the amount of utilities owned
                            //then we pay the rent
                            if (numUtils == 1){
                                ((Utility) curSpace).setBoth(false);
                            }
                            else{
                                ((Utility) curSpace).setBoth(true);
                            }
                            ((Utility) curSpace).collectRent(turn, lastRoll);
                        }
                    }
                    else if (spaceType.equals("railroad")){
                        if (((Railroad) curSpace).getOwner().equals(null)) {
                            //asks if player wants to buy (allows if enough $)
                        }
                        else {
                            //we need to know how many railroads
                            //the Player owner of this space has
                            int numRoads = 0;
                            int[] propList = ((Railroad) curSpace).getOwner().playerProperties;
                            for (int i = 0; i < propList.length; i++){
                                if (boardSpaces[propList[i]].getType().equals("railroad")){
                                    numRoads++;
                                }
                            }
                            ((Railroad) curSpace).collectRent(turn, numRoads);
                        }
                    }
                    else if (spaceType.equals("chance")) {
                        chanceDeck.draw();
                    }
                    else if (spaceType.equals("chest")) {
                        chestDeck.draw();
                    }
                    else if (spaceType.equals("tax")) {
                        ((Taxes) curSpace).collectTax(turn);
                        //later make condition for if they don't have any money left
                        //that they need to mortgage
                    }
                    else if (spaceType.equals("gotojail")){ 
                        turn.goToJail();
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