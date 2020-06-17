import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
/**
* Write a description of class Board here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Board extends World {
    //hahahahahahaha
    public Space[] boardSpaces = new Space[40];
    public String[] TYPE = {"go", "property", "chest", "property", "tax", "railroad", "property", "chance", "property", "property", "jail", "property", "utility", "property", "property", "railroad", "property", "chest", "property", "property", "free", "property", "chance", "property", "property", "railroad", "property", "property", "utility", "property", "gotojail", "property", "property", "chest", "property", "railroad", "chance", "property", "tax", "property"};
    public String[] NAME = {"", "Fitness", "BCA\nChest", "Gym", "ID check", "T hallway", "Visual Lab", "Chance", "Ms. Min", "Culinary", "Detention", "Mr.\nHathaway", "Lower Caf", "Ms. Kaba", "Mr. Torres", "Math\nhallway", "Mr. Miller", "BCA\nChest", "Ms.\nPagano", "Mrs. Kim", "Commons", "Dr. Penev", "Chance", "Dr.\nHeitzman", "Dr.\nAbramson", "Language\nhallway", "Mandarin", "Spanish", "Upper Caf", "French", "Go to \n Detention", "Biology", "Chemistry", "BCA\nChest", "Physics", "Chem\nhallway", "Chance", "Maker \n space", "ID Check", "Comp Sci\n(room 138)"};
    public int[] PRICE = {0, 60, 0, 60, 0, 0, 100, 0, 100, 120, 0, 140, 0, 140, 160, 0, 180, 0, 180, 200, 0, 220, 0, 220, 240, 0, 260, 260, 0, 280, 0, 300, 300, 0, 320, 0, 0, 350, 0, 400};
    public int[] RENT = {0, 2, 0, 4, 0, 0, 6, 0, 6, 8, 0, 10, 0, 10, 12, 0, 14, 0, 14, 16, 0, 18, 0, 18, 20, 0, 22, 22, 0, 24, 0, 26, 26, 0, 28, 0, 0, 35, 0, 50};
    public Dice dice = new Dice();
    public ChanceDeck chanceDeck;
    public ChestDeck chestDeck;
    public ArrayList<Player> players;
    public Player turn; //added this to keep track of whose turn it is
    public int roll1;
    public int roll2;
    public int lastRoll;
    public int player;
    public boolean rolled = false;
    public boolean turnOver = true;
    public Menu menu;
    public MortgageButton mortgageButton = new MortgageButton();
    public UnmortgageButton unmortgageButton = new UnmortgageButton();
    public ListPropertiesButton listPropButton = new ListPropertiesButton();
    public Jail jail;
    public SellHouseButton sellHouse;
    public PropertyInfo propInfo;
    public int round;
   
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board(ArrayList<String> p, ArrayList<String> w)
    {   
        super(1100, 700, 1); 
        startGame(p, w);
        
        int count = 0;
        
        int x = 605;
        int y = 640;
        
        jail = new Jail();
        addObject(jail, 330, 350);
        
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
                a = new Property(NAME[i], i, PRICE[i], RENT[i], x, y);
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
                a = new Property(NAME[i], i, PRICE[i], RENT[i], x, y);
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
                a = new Property(NAME[i], i, PRICE[i], RENT[i], x, y);
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
                a = new Property(NAME[i], i, PRICE[i], RENT[i], x, y);
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
        
        menu = new Menu();
        addObject(menu, 864, 350);
        addObject(mortgageButton, 880, 155);
        addObject(unmortgageButton, 892 + mortgageButton.getImage().getWidth(), 155);
        sellHouse = new SellHouseButton();
        addObject(sellHouse, 882, 229);
        addObject(listPropButton, 740, 350);
        menu.callPlay();
    }
    
    public void startGame(ArrayList<String> playerNames, ArrayList<String> tokens){
        //making the players ArrayList
        this.players = new ArrayList<Player>();
        
        for(int i = 0; i < playerNames.size(); i++) {
            Player p = new Player(tokens.get(i), 0, playerNames.get(i));
            this.players.add(p);
        }
    }
    
    public void play() {
        int x = 558;
        int y = 630;
        int count = 0;
        // put player tokens on the board
        for(int i = 0; i < players.size(); i++) { 
            if(count == 2) {
                x = 558;
                y = 654;
            }
            addObject(players.get(i), x += 30, y);
            players.get(i).initialX = x;
            players.get(i).initialY = y;
            count++;
        }
        // shuffle the card decks
        chanceDeck = new ChanceDeck();
        addObject(chanceDeck, 10000, 10000);
        chanceDeck.addCards();
        chanceDeck.shuffle();
        chestDeck = new ChestDeck();
        addObject(chestDeck, 10000, 10000);
        chestDeck.addCards();
        chestDeck.shuffle();
        // Note: no player-player trading for now
    }
    
    public void act() {
        // while more than one player remains (bankrupted people are removed) 
        // continue playing
        if(players.size() > 1) {
            // cycles through the players, allowing them to take turns one by one
            switch(player) {
                case 0:
                    runTurn(0);
                    //chestDeck.debugging();
                    break;
                case 1:
                    runTurn(1);
                    break;
                case 2:
                    if (player < players.size()) {
                        runTurn(2);
                    }
                    break;
                case 3:
                    if (player < players.size()) {
                        runTurn(3);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    public void askToUnmortgage() {
        String listOfProperties = "";
        for(int i = 0; i < turn.mortgagedProperties.size(); i++) {
            listOfProperties += turn.mortgagedProperties.get(i) + ": " + boardSpaces[Integer.parseInt(turn.mortgagedProperties.get(i))].name + "\n";
        }
        String s = Greenfoot.ask("How dare u try to unmortgage a property >:( \nEnter the number of the property you would like to unmortgage. \n\nList of mortgaged properties: \n" + listOfProperties + "\nEnter 'exit' to cancel ;)");
        if(s.equals("exit")) {
            return;
        }
        int mortgaging = Integer.parseInt(s);
        
        if(boardSpaces[mortgaging].getType().equals("property")) {
            if(((Property)boardSpaces[mortgaging]).owner.equals(turn)) {
                ((Property)boardSpaces[mortgaging]).unmortgage();
            }
            else {
                showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
                askToUnmortgage();
            }
        }
        else if(boardSpaces[mortgaging].getType().equals("utility")) {
            if(((Utility)boardSpaces[mortgaging]).owner.equals(turn)) {
                ((Utility)boardSpaces[mortgaging]).unmortgage();
            }
            else {
                showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
                askToUnmortgage();
            }
        }
        else if(boardSpaces[mortgaging].getType().equals("railroad")) {
            if(((Railroad)boardSpaces[mortgaging]).owner.equals(turn)) {
                ((Railroad)boardSpaces[mortgaging]).unmortgage();
            }
            else {
                showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
                askToUnmortgage();
            }
        }
    }
    
    public void askToMortgage() {
        String listOfProperties = "";
        for(int i = 0; i < turn.playerProperties.size(); i++) {
            if(turn.mortgagedProperties.indexOf(turn.playerProperties.get(i)) == -1) {
                listOfProperties += turn.playerProperties.get(i) + ": " + boardSpaces[turn.playerProperties.get(i)].name + "\n";
            }
        }
        String s = Greenfoot.ask("You need to mortgage a property. This means you will receive reimbursement woohoo but you won't be able to collect rent until you unmortgage this. \nEnter the number of the property you would like to mortgage. \n\nList of properties you own: \n" + listOfProperties + "\nType 'exit' to cancel :)))");
        if(s.equals("exit")) {
            return;
        }
        int mortgaging = Integer.parseInt(s);
        
        if(boardSpaces[mortgaging].getType().equals("property")) {
            if(((Property)boardSpaces[mortgaging]).owner.equals(turn)) {
                ((Property)boardSpaces[mortgaging]).mortgage();
            }
            else {
                showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
                askToMortgage();
            }
        }
        else if(boardSpaces[mortgaging].getType().equals("utility")) {
            if(((Utility)boardSpaces[mortgaging]).owner.equals(turn)) {
                ((Utility)boardSpaces[mortgaging]).mortgage();
            }
            else {
                showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
                askToMortgage();
            }
        }
        else if(boardSpaces[mortgaging].getType().equals("railroad")) {
            if(((Railroad)boardSpaces[mortgaging]).owner.equals(turn)) {
                ((Railroad)boardSpaces[mortgaging]).mortgage();
            }
            else {
                showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
                askToMortgage();
            }
        }
    }
    
    public void listProperties(){
        String listOfProperties = "";
        for(int i = 0; i < turn.playerProperties.size(); i++) {
            if(turn.mortgagedProperties.indexOf(boardSpaces[turn.playerProperties.get(i)].name) == -1) {
                listOfProperties += turn.playerProperties.get(i) + ": " + boardSpaces[turn.playerProperties.get(i)].name + "\n";
            }
            /*else{
                listOfProperties += turn.mortgagedProperties.indexOf(boardSpaces[turn.playerProperties.get(i)].name) + ": " + boardSpaces[Integer.parseInt(turn.mortgagedProperties.get(i))].name + " (mortgaged)\n";
            }*/
        }
        /*for(int i = 0; i < turn.mortgagedProperties.size(); i++) {
            listOfProperties += turn.mortgagedProperties.get(i) + ": " + boardSpaces[Integer.parseInt(turn.mortgagedProperties.get(i))].name + " (mortgaged)\n";
        }*/
        String s = Greenfoot.ask("Here is a list of all of your properties: \n" + listOfProperties + ".\nPress enter to exit.");
    }
    
    public void askToRemHouse() {
        String listOfProperties = "";
        for(int i = 0; i < turn.playerProperties.size(); i++) {
            if(turn.mortgagedProperties.indexOf(turn.playerProperties.get(i)) == -1 && ((Property)boardSpaces[turn.playerProperties.get(i)]).numHouses > 0) {
                listOfProperties += turn.playerProperties.get(i) + ": " + boardSpaces[turn.playerProperties.get(i)].name + "\n";
            }
        }
        String s = Greenfoot.ask("You need to remove a house from a property. This means you will receive reimbursement woohoo but you will lose a house. \nEnter the number of the property you would like to remove houses from. \n\nList of properties with houses you own: \n" + listOfProperties + ".\nIf you don't want to do this, write exit");
        if(s.equals("exit")) {
            return;
        }
        int propNum = Integer.parseInt(s);
        
        if(boardSpaces[propNum].getType().equals("property")) {
            if(((Property)boardSpaces[propNum]).owner.equals(turn) && ((Property)boardSpaces[propNum]).numHouses > 0) {
                ((Property)boardSpaces[propNum]).remHouse();
            }
            else {
                showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
                askToRemHouse();
            }
        }
        else {
            showText("That's not a valid option ;((( pls don't break the code ;((((", 650, 700);
            askToRemHouse();
        }
    }
    
    public void goBankruptRIP() {
        if(turn.playerProperties.size() > 0) {
            // prompts to mortgage properties until the debt is paid off
            while(turn.playerProperties.size() > 0 && turn.getMoney() <= 0) {
                askToMortgage();
            }
        }
        else {
            players.remove(turn);
            turn.clearPlayer();
            if (players.size() == 1) {
                Greenfoot.stop();
            }
        }
    }
    
    public void runTurn(int p) {
        for (int i = 0; i < players.size(); i++) {
            showText(" ", 850, 600 + i * 20);
            showText((i + 1) + ". " + players.get(i).name + " has $" + players.get(i).getMoney(), 850, 590 + i * 20);
        }
        
        if (turnOver) {
            round++;
            turnOver = false;
            turn = players.get(p); //the player whose turn it is
            // the if makes sure that there are still enough people not 
            // bankrupt to play
            if (players.size() == 1) {
                Win win = new Win(players.get(0).name, round);
                // Greenfoot.stop(); owo
                Greenfoot.setWorld(win);
            }
            // bankrupcy algorithm 
            if (turn.getMoney() <= 0){
                goBankruptRIP();
            }
            //if the player is currently in jail
            if (turn.inJail){
                gettingOutOfJail();
            }
            else{
                //next we set up some variables to keep track of 
                //the player rolling doubles/nondoubles
                int doubles = 0;
                boolean notDoubles = false;
                
                // while they haven't rolled three doubles the player can take their turn
                while (!notDoubles && doubles < 3) {
                    if(doubles > 0) {
                        showText("Double!!!!", 330, 430);
                    }
                    waiting(120);
                    showText("", 330, 430);
                    
                    roll1 = dice.roll();
                    roll2 = dice.roll();
                    
                    lastRoll = roll1 + roll2;
                    showText(turn.name + " rolled " + roll1 + " and " + roll2, 850, 83);
                   
                    //checks if the player rolled enough
                    //evens to get in jail
                    //if yes, sends them to jail
                    if (roll1 == roll2) {
                        doubles++;
                    }
                    else {
                        notDoubles = true;
                    }
                    if (doubles == 3){
                        break;
                    }
                    //moves player forward one space at a time
                    //checks if you pass go and gives you 200
                    for (int m = 0; m < lastRoll; m++) {
                        turn.moveOneSpace();
                        waiting(20);
                        if (turn.getCurrentSpace() == 0) {
                            turn.addMoney(((Go)boardSpaces[0]).getBonus());
                        }
                    }
                    // define some variables relating to which space they landed on
                    Space curSpace = boardSpaces[turn.getCurrentSpace()];
                    String spaceType = curSpace.getType();
                    propInfo = new PropertyInfo();
                    
                    if (curSpace.getType().equals("property")){
                        propInfo.setImage(new GreenfootImage(((Property)curSpace).color + "_property.png"));
                        GreenfootImage i = new GreenfootImage(propInfo.getImage());
                        i.scale((int)(propInfo.getImage().getWidth() / 1.5), (int)(propInfo.getImage().getHeight() / 1.5));
                        propInfo.setImage(i);
                        propInfo.listPropInfo((Space)curSpace);
                        propInfo.listOwner(((Property)curSpace).ownedBy);
                    }
                    else if (curSpace.getType().equals("utility")){
                        propInfo.listOwner(((Utility)curSpace).ownedBy);
                        propInfo.listUtilInfo(curSpace);
                    }
                    else if (curSpace.getType().equals("railroad")){
                        propInfo.listOwner(((Railroad)curSpace).ownedBy);
                        propInfo.listRailInfo(curSpace);
                    }
                    else if (curSpace.getType().equals("chance")){
                        curSpace.setInfo("Your Chance Card says:\n" + chanceDeck.cards[0].message);
                        propInfo.setImage(new GreenfootImage("chanceCard.jpg"));
                        GreenfootImage i = new GreenfootImage(propInfo.getImage());
                        i.scale((int)(i.getWidth() / 3.3), (int)(i.getHeight() / 2.89));
                        propInfo.setImage(i);
                        propInfo.listInfo(curSpace.info);
                    }
                    else if (curSpace.getType().equals("chest")){
                        curSpace.setInfo("Your Chest Card says:\n" + chestDeck.cards[0].message);
                        propInfo.setImage(new GreenfootImage("chestCard.jpg"));
                        GreenfootImage i = new GreenfootImage(propInfo.getImage());
                        i.scale((int)(i.getWidth() / 3.3), (int)(i.getHeight() / 2.89));
                        propInfo.setImage(i);
                        propInfo.listInfo(curSpace.info);
                    }
                    else {
                        propInfo.listInfo(curSpace.info);
                    }
                    
                    addObject(propInfo, 950, 430);
                    waiting(200);
                    //depending on space type, they can make their turn
                    if (spaceType.equals("property")){
                        if (((Property) curSpace).getOwner() == null && turn.getMoney() >= ((Property)curSpace).price){
                            // the property has no owner
                            // it asks if player wants to buy (allows if enough $)
                            waiting(150);
                            String response = Greenfoot.ask("Would you like to buy " + ((Property) curSpace).name + " for $" + ((Property) curSpace).price + " (y/n)?");
                            if(response.equals("y")) {
                                ((Property) curSpace).setOwner(turn);
                                turn.subMoney(((Property)curSpace).price);
                                turn.playerProperties.add(((Property)curSpace).spaceNumber);
                            }
                            else if(response.equals("n")) {
                                showText("but why ;((((", 330, 430);
                            }
                        }
                        else if (((Property)curSpace).getOwner() != null) {
                            //otherwise the property collects rent
                            ((Property) curSpace).collectRent(turn);
                        }
                        
                        if (((Property) curSpace).getOwner() != null && ((Property) curSpace).getOwner().equals(turn)){
                            // checks property color
                            String color = ((Property)curSpace).COLORS[turn.getCurrentSpace()];
                            
                            if (turn.hasAMonopoly(color)) {
                                if (((Property)curSpace).numHouses < 4) {
                                    //offer to buildHouse
                                    String s = Greenfoot.ask("Do you want a house? (y/n)");
                                    if(s.equals("y")) {
                                        House h = (House)((Property) curSpace).buildHouse();
                                        addObject(h, ((Property)curSpace).x, ((Property)curSpace).y);
                                    }
                                }
                                else if (((Property)curSpace).numHouses == 4) {
                                    //offer to buildHotel
                                    String s = Greenfoot.ask("Do you want to build a hotel? (y/n)");
                                    if(s.equals("y")) {
                                        Hotel h = (Hotel)((Property) curSpace).buildHouse();
                                        addObject(h, ((Property)curSpace).x, ((Property)curSpace).y);
                                    }
                                }
                            }
                        }
                    }
                    else if (spaceType.equals("utility")) {
                        if (((Utility)curSpace).getOwner() == null && turn.getMoney() >= ((Utility)curSpace).price){
                            //asks if player wants to buy (allows if enough $)
                            waiting(150);
                            String response = Greenfoot.ask("Would you like to buy " + ((Utility)curSpace).name + " for $" + ((Utility) curSpace).price + " (y/n)?");
                            if(response.equals("y")) {
                                ((Utility) curSpace).owner = turn;
                                turn.subMoney(((Utility)curSpace).price);
                                turn.playerProperties.add(((Utility)curSpace).spaceNumber);
                            }
                            else if(response.equals("n")) {
                                showText("but why ;((((", 330, 430);
                            }
                        }
                        else if (((Utility)curSpace).getOwner() != null) {
                            //we want to check if the owner of the property owns both utilities
                            int numUtils = 0;
                            ArrayList<Integer> propList = ((Utility) curSpace).getOwner().playerProperties;
                            for (int i = 0; i < propList.size(); i++){
                                if (boardSpaces[propList.get(i)].getType().equals("utility")){
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
                        if (((Railroad) curSpace).getOwner() == null && turn.getMoney() >= ((Railroad)curSpace).price) {
                            //asks if player wants to buy (allows if enough $)
                            waiting(150);
                            String response = Greenfoot.ask("Would you like to buy " + ((Railroad)curSpace).name + " for $" + ((Railroad) curSpace).price + " (y/n)?");
                            if(response.equals("y")) {
                                ((Railroad) curSpace).owner = turn;
                                turn.subMoney(((Railroad)curSpace).price);
                                turn.playerProperties.add(((Railroad)curSpace).spaceNumber);
                            }
                            else if(response.equals("n")) {
                                showText("but why ;((((", 330, 430);
                            }
                        }
                        else if (((Railroad) curSpace).getOwner() != null) {
                            //we need to know how many railroads
                            //the Player owner of this space has
                            int numRoads = 0;
                            ArrayList<Integer> propList = ((Railroad) curSpace).getOwner().playerProperties;
                            for (int i = 0; i < propList.size(); i++){
                                if (boardSpaces[propList.get(i)].getType().equals("railroad")){
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
                        //if they don't have any money left
                        //that they need to mortgage
                        if (turn.getMoney() <= 100){
                            askToMortgage();
                        }
                        ((Taxes) curSpace).collectTax(turn);
                    }
                    else if (spaceType.equals("gotojail")){ 
                        goToJail();
                    }
                    //else if (spaceType.equals("free")){
                        //((Free)curSpace).collectMoney();
                    //}
                }
                if (doubles == 3){
                    goToJail();
                }
                
            }
            EndButton e = new EndButton();
            GreenfootImage img = new GreenfootImage("next_button.png");
            img.scale((int)(img.getWidth()/2.5), (int)(img.getHeight()/2.5));
            e.setImage(img);
            addObject(e, 344, 266);
        }
    }
    
    public void goToJail() {
        //physically and virtually in jail
        turn.inJail = true;
        turn.setLocation(jail.getX(), jail.getY()); 
        turn.currentSpace = 10;
        //ask if they want to get out
        gettingOutOfJail();
    }
    
    public void getOutOfJail() 
    {
        turn.inJail = false;
        turn.setLocation(43, 640);
    }
    
    public void gettingOutOfJail() {
        String s = Greenfoot.ask("1: roll for a double; 2: use a getOutOfJailCard; 3: pay the bail (1/2/3)");
        if(turn.turnsInJail == 3) {
            turn.subMoney(50);
            getOutOfJail();
        }
        if (s.equals("2") && turn.getOutOfJailCards[0]){
            // ya wanna get out of jail?
            turn.getOutOfJailCards[0] = false;
            getOutOfJail();
        }
        else if (s.equals("2") && turn.getOutOfJailCards[1]) {
            turn.getOutOfJailCards[1] = false;
            getOutOfJail();
        }
        else if (s.equals("3") && turn.getMoney() >= 50){
            turn.subMoney(50);
            getOutOfJail();
        }
        else {
            //allow them to roll, trying to get a double
            //this will happen for the next two moves, unless they choose to leave
            //then they will be forced to pay 50
            roll1 = dice.roll();
            roll2 = dice.roll();
            showText("You rolled " + roll1 + " and " + roll2, 850, 83);
           
            if (roll1 == roll2) {
                getOutOfJail();
                turn.turnsInJail = 0;
            }
            else{
                turn.turnsInJail++;
            }
        }
    }
    
    public void waiting(int time) {
        Greenfoot.delay(time);
        repaint();
    }
}