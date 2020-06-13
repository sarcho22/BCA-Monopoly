import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChestCard extends Card
{
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String message;
    public String action;
    public int amount;
    
    public ChestCard (String message, String action, int amount) {
        this.message = message;
        this.action = action;
        this.amount = amount;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction() {
        GreenfootImage i = ((Board)getWorld()).menu.getImage();
        i.setFont(i.getFont().deriveFont(27f));
        i.drawString("Your ChestCard says:\n" + message, i.getWidth()/2-150, i.getHeight()/2+150);
        
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
            case "b-day":
                //collect $10 from each player
                break;
            case "go":
                break;
            case "repairs":
                //pay $40 for each house and $115 per hotel (for all buildings)
                break;
            default:
                break;
        }
        // write the description of the card to the menu
    }
}
