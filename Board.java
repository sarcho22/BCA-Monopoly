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
    public String[] TYPE = {"go", "property", "chest", "property", "tax", "railroad", "property", "chance", "property", "property", "jail", "property", "utility", "property", "property", "railroad", "property", "chest", "property", "property", "free", "property", "chance", "property", "property", "railroad", "property", "property", "utility", "property", "gotojail", "property", "property", "chest", "property", "railroad", "chance", "property", "tax", "property"};
    public String[] NAME = {"", "Fitness", "BCA Chest", "Gym", "ID check", "T hallway", "Visual Lab", "Chance", "Ms. Min", "Culinary", "Detention", "Mr. Hathaway", "Lower Caf", "Ms. Kaba", "Mr. Torres", "[rail]", "Mr. Miller", "BCA Chest", "Ms. Pagano", "Mrs. Kim", "Commons", "Dr. Penev", "Chance", "Dr. Heitzman", "Dr. Abramson", "[railroad]", "Mandarin", "Spanish", "Upper Caf", "French", "Go to Detention", "Biology", "Chemistry", "BCA Chest", "Physics", "[railroad]", "Chance", "Makerspace", "ID Check", "Comp Sci (room 138)"};
    public int[] PRICE = {0, 60, 0, 60, 0, 0, 100, 0, 100, 120, 0, 140, 0, 140, 160, 0, 180, 0, 180, 200, 0, 220, 0, 220, 240, 0, 260, 260, 0, 280, 0, 300, 300, 0, 320, 0, 0, 350, 0, 400};
    public int[] RENT = {0, 2, 0, 4, 0, 0, 6, 0, 6, 8, 0, 10, 0, 10, 12, 0, 14, 0, 14, 16, 0, 18, 0, 18, 20, 0, 22, 22, 0, 24, 0, 26, 26, 0, 28, 0, 0, 35, 0, 50};
    public Dice dice = new Dice();
    public ChanceDeck chanceDeck = new ChanceDeck();
    public ChestDeck chestDeck = new ChestDeck();
    public Player[] players;
    public Player turn; //added this to keep track of whose turn it is
    public int roll1;
    public int roll2;
    public int lastRoll;
    public boolean playing = false;
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board(ArrayList<String> p, ArrayList<String> w)
    {   
        super(1100, 700, 1); 
        startGame(p, w);
    }
    
    public void act() {
        if(!playing) {
        int count = 0;
        
        int x = 605;
        int y = 640;
        
        Space a = new Go();
        boardSpaces[count++] = a;
        addObject(a, x, y);
        
        int interval = 56;
        
        for(int i = 1; i < 10; i++) {
            x -= interval;
            if(i == 1) {
                x -= 4;
            }
            if(TYPE[i].equals("property")) {
                a = new Property(NAME[i], i, PRICE[i], RENT[i]);
            }
            else if(TYPE[i].equals("chest")) {
                a = new Chest(NAME[i], i);
            }
            else if(TYPE[i].equals("chance")) {
                a = new Chance(NAME[i], i);
            }
            else if(TYPE[i].equals("tax")) {
                a = new Taxes(NAME[i], i);
            }
            else if(TYPE[i].equals("railroad")) {
                a = new Railroad(NAME[i], i);
            }
            else if(TYPE[i].equals("utility")) {
                a = new Utility(NAME[i], i);
            }
            boardSpaces[count++] = a;
            addObject(a, x, y);
        }
        
        x -= interval+4;
        a = new Jail();
        boardSpaces[count++] = a;
        addObject(a, x, y);
        
        for(int i = 11; i < 20; i++) {
            y -= interval;
            if(i == 11) {
                y -= 4;
            }
            if(TYPE[i].equals("property")) {
                a = new Property(NAME[i], i, PRICE[i], RENT[i]);
            }
            else if(TYPE[i].equals("chest")) {
                a = new Chest(NAME[i], i);
            }
            else if(TYPE[i].equals("chance")) {
                a = new Chance(NAME[i], i);
            }
            else if(TYPE[i].equals("tax")) {
                a = new Taxes(NAME[i], i);
            }
            else if(TYPE[i].equals("railroad")) {
                a = new Railroad(NAME[i], i);
            }
            else if(TYPE[i].equals("utility")) {
                a = new Utility(NAME[i], i);
            }
            boardSpaces[count++] = a;
            a.setRotation(90);
            addObject(a, x, y);
            
        }
        
        y -= interval+4;
        a = new Free();
        boardSpaces[count++] = a;
        addObject(a, x, y);
        
        for(int i = 21; i < 30; i++) {
            if(i == 21) {
                x += 4;
            }
            x += interval;
            if(TYPE[i].equals("property")) {
                a = new Property(NAME[i], i, PRICE[i], RENT[i]);
            }
            else if(TYPE[i].equals("chest")) {
                a = new Chest(NAME[i], i);
            }
            else if(TYPE[i].equals("chance")) {
                a = new Chance(NAME[i], i);
            }
            else if(TYPE[i].equals("tax")) {
                a = new Taxes(NAME[i], i);
            }
            else if(TYPE[i].equals("railroad")) {
                a = new Railroad(NAME[i], i);
            }
            else if(TYPE[i].equals("utility")) {
                a = new Utility(NAME[i], i);
            }
            a.setRotation(180);
            boardSpaces[count++] = a;
            addObject(a, x, y);
            
        }
        
        x += interval+4;
        a = new GoToJail();
        boardSpaces[count++] = a;
        addObject(a, x, y);
        
        for(int i = 31; i < 40; i++) {
            if(i == 31) {
                y += 3;
            }
            y += interval;
            if(TYPE[i].equals("property")) {
                a = new Property(NAME[i], i, PRICE[i], RENT[i]);
            }
            else if(TYPE[i].equals("chest")) {
                a = new Chest(NAME[i], i);
            }
            else if(TYPE[i].equals("chance")) {
                a = new Chance(NAME[i], i);
            }
            else if(TYPE[i].equals("tax")) {
                a = new Taxes(NAME[i], i);
            }
            else if(TYPE[i].equals("railroad")) {
                a = new Railroad(NAME[i], i);
            }
            else if(TYPE[i].equals("utility")) {
                a = new Utility(NAME[i], i);
            }
            a.setRotation(270);
            boardSpaces[count++] = a;
            addObject(a, x, y);
            
        }
        //2d array for rent of houses
        Play g = new Play();
        addObject(g,1000, 1000);
        playing = true;
    }
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
        //put player tokens on the board
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
        //shuffle the card decks
        chanceDeck.shuffle();
        chestDeck.shuffle();
        //while more than one player remains (bankrupted people are removed) 
        //continue playing
        while(players.length > 1) {
            //cycles through the players, allowing them to take turns one by one
            for (int player = 0; player < players.length; player++) {
                turn = players[player]; //the player whose turn it is
                //the if makes sure that there are still enough people not 
                //bankrupt to play (because the amount of players can
                //change within the for loop)
                if (players.length == 1) {
                    break;
                }
                //bankrupcy algorithm (might want to make this a method)
                if (turn.getMoney() <= 0){
                    if (turn.playerProperties.length > 0){
                        //prompts to mortgage properties until the debt is paid off
                        //the mortgaging prompt should also be a method, probably
                    }
                    else{
                        Player[] temp = new Player[players.length -1];
                        for (int i = 0; i < player; i++){
                            temp[i] = players[i];
                        }
                        for (int i = player + 1; i < players.length; i++){
                            temp[i - 1] = players[i];
                        }
                        players = temp;
                        turn.clearPlayer();
                        if (players.length == 1) {
                            break;
                        }
                    }
                }
                //if the player is currently in jail
                if (turn.inJail){
                    //use the same get out of jail algorithm as at the bottom of this
                    //regardless if they leave or not, pass their turn on
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
                    addObject(rb, 720, 500); // random coordinates at the moment
                    showText("Roll!", 900, 900);
                    // this is probably done a little wrong, I want it 
                    // to continuously check for the player
                    // clicking on it until they finally do
                    
                    /*while(true) {
                        if(Greenfoot.mousePressed(rb)) {
                            roll1 = dice.roll(); 
                            roll2 = dice.roll();
                            lastRoll = roll1 + roll2;
                            break;
                        }
                    }
                    */
                    //showText("" + roll1 + ", " + roll2, 750, 350);
                    
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
                if (doubles == 3){
                    turn.goToJail();
                    //get out of jail protocol, might want to make this as a method
                    if (turn.getOutOfJailCards[0] == 1 || turn.getOutOfJailCards[1] == 1){
                        //ask if they want to get out of jail
                        //if they got out of jail, remove card, call turn.getOutOfJail()
                        
                    }
                    else if (turn.getMoney() >= 50){
                        //ask if they want to get out of jail
                        //if they got out of jail, sub money, call turn.getOutOfJail()
                    }
                    else{
                        //allow them to roll, trying to get a double
                        //this will happen for the next two moved, unless they choose to leave
                        //then they will be forced to pay 50
                    }
                }
            }
            if (lastRoll == 0) {
                break;
            }
        }
        //we wont due player-player trading for now
    }
}