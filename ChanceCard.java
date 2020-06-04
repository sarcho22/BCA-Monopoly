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
    
    public ChanceCard (String message, String action, int amount) {
        this.message = message;
        this.action = action;
        this.amount = amount;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction() {
        switch(action) {
            case "add":
                //add money
                break;
            case "sub":
                break;
            case "free":
                //add a get out of jail card to the player
                break;
            case "jail":
                break;
            case "election":
                //pay $50 to each player
                break;
            case "go":
                break;
            case "3":
                //go back 3 spaces
                break;
            case "hathaway":
                //go to mr. hathaway 
                break;
            case "penev":
                //go to dr. penev
                break;
            case "T":
                //go to T hallway
                break;
            case "repairs":
                //pay $25 for each house and $100 per hotel (for your own)
                break;
            case "138":
                // go to CS room
                break;
            case "hall":
                // go to nearest hall
                break;
            case "caf":
                // go to nearest caf
                break;
            default:
                break;
        }
        // write the description of the card to the menu
    }
}
