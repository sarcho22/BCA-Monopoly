import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
                //go to mr. hathaway 
                break;
            case "penev":
                ((Board)getWorld()).turn.moveToSpace(21, true);
                //go to dr. penev
                break;
            case "T":
                ((Board)getWorld()).turn.moveToSpace(5, true);
                //go to T hallway
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
