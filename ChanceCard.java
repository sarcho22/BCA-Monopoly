import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChanceCard extends Card
{
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String message;
    public String action;
    public int amount;
    public GreenfootImage savedBG = null;
    
    public ChanceCard (String message, String action, int amount) {
        this.message = message;
        this.action = action;
        this.amount = amount;
    } 
    /*
    public void clearChance() {
        // field
        // draw the string
        savedBG = new GreenfootImage(getBackground());
        getBackground().drawString("hi", getWidth() / 2, getHeight() / 2);
        // remove the string
        setBackground(savedBG);
    }
    */
    public void doAction() {
        
        switch(action) {
            case "add":
                ((Board)getWorld()).turn.addMoney(amount);
                break;
            case "sub":
                ((Board)getWorld()).turn.subMoney(amount);
                break;
            case "free":
                if (!((Board)getWorld()).turn.getOutOfJailCards[0]){
                    ((Board)getWorld()).turn.getOutOfJailCards[0] = true;
                }
                else if (!((Board)getWorld()).turn.getOutOfJailCards[1]){
                    ((Board)getWorld()).turn.getOutOfJailCards[1] = true;
                }
                //add a get out of jail card to the player
                break;
            case "jail":
                ((Board)getWorld()).goToJail();
                break;
            case "election":
                for (int a = 0; a < ((Board)getWorld()).players.size(); a++){
                    ((Board)getWorld()).turn.subMoney(50);
                    ((Board)getWorld()).players.get(a).addMoney(50);
                }
                //pay $50 to each player
                break;
            case "go":
                ((Board)getWorld()).turn.moveToSpace(0, true);
                break;
            case "3":
                ((Board)getWorld()).turn.moveToSpace(((Board)getWorld()).turn.getCurrentSpace() - 3, false);
                //go back 3 spaces
                break;
            case "hathaway":
                ((Board)getWorld()).turn.moveToSpace(11, true);
                if (((Property)((Board)getWorld()).boardSpaces[11]).getOwner() == null && ((Board)getWorld()).turn.getMoney() >= ((Property)((Board)getWorld()).boardSpaces[11]).price){
                            // the property has no owner
                            // it asks if player wants to buy (allows if enough $)
                            ((Board)getWorld()).waiting(150);
                            String response = Greenfoot.ask("Would you like to buy " + ((Property)((Board)getWorld()).boardSpaces[11]).name + " for $" + ((Property)((Board)getWorld()).boardSpaces[11]).price + " (y/n)?");
                            if(response.equals("y")) {
                                ((Property)((Board)getWorld()).boardSpaces[11]).setOwner(((Board)getWorld()).turn);
                                ((Board)getWorld()).turn.subMoney(((Property)((Board)getWorld()).boardSpaces[11]).price);
                                ((Board)getWorld()).turn.playerProperties.add(((Property)((Board)getWorld()).boardSpaces[11]).spaceNumber);
                            }
                            else if(response.equals("n")) {
                                ((Board)getWorld()).showText("but why ;((((", 330, 430);
                            }
                        }
                        else if (((Property)((Board)getWorld()).boardSpaces[11]).getOwner() != null) {
                            //otherwise the property collects rent
                            ((Property)((Board)getWorld()).boardSpaces[11]).collectRent(((Board)getWorld()).turn);
                        }
                        
                        if (((Property)((Board)getWorld()).boardSpaces[11]).getOwner() != null && ((Property)((Board)getWorld()).boardSpaces[11]).getOwner().equals(((Board)getWorld()).turn)){
                            // checks property color
                            String color = ((Property)((Board)getWorld()).boardSpaces[11]).COLORS[((Board)getWorld()).turn.getCurrentSpace()];
                            
                            if (((Board)getWorld()).turn.hasAMonopoly(color)) {
                                if (((Property)((Board)getWorld()).boardSpaces[11]).numHouses < 4) {
                                    //offer to buildHouse
                                    String s = Greenfoot.ask("Do you want a house? (y/n)");
                                    if(s.equals("y")) {
                                        House h = (House)((Property)((Board)getWorld()).boardSpaces[11]).buildHouse();
                                        ((Board)getWorld()).addObject(h, ((Property)((Board)getWorld()).boardSpaces[11]).x, ((Property)((Board)getWorld()).boardSpaces[11]).y);
                                    }
                                }
                                else if (((Property)((Board)getWorld()).boardSpaces[11]).numHouses == 4) {
                                    //offer to buildHotel
                                    String s = Greenfoot.ask("Do you want to build a hotel? (y/n)");
                                    if(s.equals("y")) {
                                        Hotel h = (Hotel)((Property)((Board)getWorld()).boardSpaces[11]).buildHouse();
                                        ((Board)getWorld()).addObject(h, ((Property)((Board)getWorld()).boardSpaces[11]).x, ((Property)((Board)getWorld()).boardSpaces[11]).y);
                                    }
                                }
                            }
                        }
                //go to mr. hathaway 
                break;
            case "penev":
                ((Board)getWorld()).turn.moveToSpace(21, true);
                if (((Property)((Board)getWorld()).boardSpaces[21]).getOwner() == null && ((Board)getWorld()).turn.getMoney() >= ((Property)((Board)getWorld()).boardSpaces[21]).price){
                            // the property has no owner
                            // it asks if player wants to buy (allows if enough $)
                            ((Board)getWorld()).waiting(150);
                            String response = Greenfoot.ask("Would you like to buy " + ((Property)((Board)getWorld()).boardSpaces[21]).name + " for $" + ((Property)((Board)getWorld()).boardSpaces[21]).price + " (y/n)?");
                            if(response.equals("y")) {
                                ((Property)((Board)getWorld()).boardSpaces[21]).setOwner(((Board)getWorld()).turn);
                                ((Board)getWorld()).turn.subMoney(((Property)((Board)getWorld()).boardSpaces[21]).price);
                                ((Board)getWorld()).turn.playerProperties.add(((Property)((Board)getWorld()).boardSpaces[21]).spaceNumber);
                            }
                            else if(response.equals("n")) {
                                ((Board)getWorld()).showText("but why ;((((", 330, 430);
                            }
                        }
                        else if (((Property)((Board)getWorld()).boardSpaces[21]).getOwner() != null) {
                            //otherwise the property collects rent
                            ((Property)((Board)getWorld()).boardSpaces[21]).collectRent(((Board)getWorld()).turn);
                        }
                        
                        if (((Property)((Board)getWorld()).boardSpaces[21]).getOwner() != null && ((Property)((Board)getWorld()).boardSpaces[21]).getOwner().equals(((Board)getWorld()).turn)){
                            // checks property color
                            String color = ((Property)((Board)getWorld()).boardSpaces[21]).COLORS[((Board)getWorld()).turn.getCurrentSpace()];
                            
                            if (((Board)getWorld()).turn.hasAMonopoly(color)) {
                                if (((Property)((Board)getWorld()).boardSpaces[21]).numHouses < 4) {
                                    //offer to buildHouse
                                    String s = Greenfoot.ask("Do you want a house? (y/n)");
                                    if(s.equals("y")) {
                                        House h = (House)((Property)((Board)getWorld()).boardSpaces[21]).buildHouse();
                                        ((Board)getWorld()).addObject(h, ((Property)((Board)getWorld()).boardSpaces[21]).x, ((Property)((Board)getWorld()).boardSpaces[21]).y);
                                    }
                                }
                                else if (((Property)((Board)getWorld()).boardSpaces[21]).numHouses == 4) {
                                    //offer to buildHotel
                                    String s = Greenfoot.ask("Do you want to build a hotel? (y/n)");
                                    if(s.equals("y")) {
                                        Hotel h = (Hotel)((Property)((Board)getWorld()).boardSpaces[21]).buildHouse();
                                        ((Board)getWorld()).addObject(h, ((Property)((Board)getWorld()).boardSpaces[21]).x, ((Property)((Board)getWorld()).boardSpaces[21]).y);
                                    }
                                }
                            }
                        }
                //go to dr. penev
                break;
            case "T":
                ((Board)getWorld()).turn.moveToSpace(5, true);
                //go to T hallway
                if (((Railroad)((Board)getWorld()).boardSpaces[5]).getOwner() == null && ((Board)getWorld()).turn.getMoney() >= ((Railroad)((Board)getWorld()).boardSpaces[5]).price){
                            // the property has no owner
                            // it asks if player wants to buy (allows if enough $)
                            ((Board)getWorld()).waiting(150);
                            String response = Greenfoot.ask("Would you like to buy " + ((Railroad)((Board)getWorld()).boardSpaces[5]).name + " for $" + ((Railroad)((Board)getWorld()).boardSpaces[5]).price + " (y/n)?");
                            if(response.equals("y")) {
                                ((Railroad)((Board)getWorld()).boardSpaces[5]).owner = (((Board)getWorld()).turn);
                                ((Board)getWorld()).turn.subMoney(((Railroad)((Board)getWorld()).boardSpaces[5]).price);
                                ((Board)getWorld()).turn.playerProperties.add(((Railroad)((Board)getWorld()).boardSpaces[5]).spaceNumber);
                            }
                            else if(response.equals("n")) {
                                ((Board)getWorld()).showText("but why ;((((", 330, 430);
                            }
                        }
                        else if (((Property)((Board)getWorld()).boardSpaces[5]).getOwner() != null) {
                            int numRoads = 0;
                            ArrayList<Integer> propList = ((Railroad)((Board)getWorld()).boardSpaces[5]).getOwner().playerProperties;
                            for (int i = 0; i < propList.size(); i++){
                                if (((Board)getWorld()).boardSpaces[propList.get(i)].getType().equals("railroad")){
                                    numRoads++;
                                }
                            }
                            ((Railroad)((Board)getWorld()).boardSpaces[5]).collectRent(((Board)getWorld()).turn, numRoads);
                        }
                        
                        
                break;
            case "repairs":
                int houses = 0;
                int hotels = 0;
                for (int a = 0; a < ((Board)getWorld()).turn.playerProperties.size(); a++){
                    int propNum = ((Board)getWorld()).turn.playerProperties.get(a);
                    if (((Board)getWorld()).boardSpaces[propNum].getType().equals("property")){
                        int houseNum = ((Property)((Board)getWorld()).boardSpaces[propNum]).numHouses;
                        if (houseNum == 5){
                            hotels++;
                        }
                        if (houseNum > 0){
                            houses += houseNum;
                        }
                    }
                }
                ((Board)getWorld()).turn.subMoney(25 * houses + 100 * hotels);
                break;
            case "138":
                ((Board)getWorld()).turn.moveToSpace(39, true);
                // go to CS room
                break;
            case "hall":
                while(!(((Board)getWorld()).boardSpaces[((Board)getWorld()).turn.currentSpace].getType().equals("railroad"))) {
                    ((Board)getWorld()).turn.moveOneSpace();
                }
                // go to nearest hall
                break;
            case "caf":
                while(!(((Board)getWorld()).boardSpaces[((Board)getWorld()).turn.currentSpace].getType().equals("utility"))) {
                    ((Board)getWorld()).turn.moveOneSpace();
                }
                // go to nearest caf
                break;
            default:
                break;
        }
        
    }
}
