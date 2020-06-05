import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
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
    public ChestDeck chestDeck = new ChestDeck();
    public Player[] players;
    public Player turn; //sorry I added this to keep track of whose turn it is
    public int roll1;
    public int roll2;
    public int lastRoll;
    //we can use this list to redisplay the board and keep track of 
    //where pieces are moving
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board(ArrayList<String> p, ArrayList<String> w)
    {    
        
        super(1100, 700, 1); 
        
        
        startGame(p, w);
        
        int x = 605;
        int y = 640;
        
        Space a = new Go();
        boardSpaces[0] = a;
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
        a = new Jail();
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
        a = new Free();
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
        a = new GoToJail();
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
        //2d array for rent of houses
        //array for house properties (i.e. names) - like Colors
        play();
    }
    
    public void startGame(ArrayList<String> playerNames, ArrayList<String> tokens){
        
        this.players = new Player[playerNames.size()];
        
        for(int i = 0; i < playerNames.size(); i++) {
            Player p = new Player(tokens.get(i), 0, playerNames.get(i));
            this.players[i] = p;
        }
        
        
    }
    
    public void play() {
        int x = 558;
        int y = 630;
        int count = 0;
        for(int i = 0; i < players.length; i++) {
            Player p = this.players[i];
            GreenfootImage image = new GreenfootImage(p.token + "_token_smaller.png");
            p.setImage(image);
            if(count == 2) {
                x = 558;
                y = 654;
            }
            addObject(p, x += 30, y);
            count++;
        }
        //while more than one player remains (bankrupted people are removed) 
        //continue playing
        /*
        chanceDeck.shuffle();
        chestDeck.shuffle();
        
        while(players.length > 1){
            //cycles through the players, allowing them to take turns one by one
            for (int player = 0; player < players.length; player++) {
                turn = players[player]; //the player whose turn it is
                //the if makes sure that there are still enough people not 
                //bankrupt to play (because the amount of players can
                //change within the for loop)
                if (players.length == 1) {
                    break;
                }
                //next we set up some variables to keep track of 
                //the player rolling doubles/nondoubles
                int doubles = 0;
                boolean notDoubles = false;
                // while they haven't rolled three doubles the player can take their turn
                while (!notDoubles && doubles < 3) {
                    // this button will allow a player to roll the dice
                    // it will be in the side bar
                    RollButton rb = new RollButton();
                    addObject(rb, 900, 900); // random coordinates at the moment
                    showText("Roll!", 900, 900);
                    // this is probably done a little wrong, I want it 
                    // to continuously check for the player
                    // clicking on it until they finally do
                    if(Greenfoot.mousePressed(rb)) {
                        roll1 = dice.roll(); 
                        roll2 = dice.roll();
                        lastRoll = roll1 + roll2;
                    }
                    removeObject(rb); // I remove the button, 
                    //but it would probably be easier to gray it out
                    
                    //checks if the player rolled enough
                    //evens to get in jail
                    //if yes, sends them to jail and breaks from the 
                    //while-loop that is their turn
                    if (roll1 == roll2) {
                        doubles++;
                    }
                    else {
                        notDoubles = true;
                    }
                    if (doubles == 3){
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
                        
                        if (((Property) curSpace).getOwner().equals(turn)){
                            // checks property color
                            String color = ((Property)curSpace).COLORS[turn.getCurrentSpace()];
                            
                            if (turn.hasAMonopoly(color)) {
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
                    else if (spaceType.equals("free")){
                        ((Free)curSpace).collectMoney();
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
            */
    }
}