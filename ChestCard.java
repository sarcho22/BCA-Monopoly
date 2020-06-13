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
                ((Board)getWorld()).turn.addMoney(amount);
                break;
            case "sub":
                ((Board)getWorld()).turn.subMoney(amount);
                break;
            case "free":
                ((Board)getWorld()).turn.moveToSpace(20);
                //add a get out of jail card to the player
                break;
            case "jail":
                // put in to jail ((Board)getWorld()).turn.moveToSpace(Jail);
                break;
            case "b-day":
                //collect $10 from each player
                for (int a = 0; a < ((Board)getWorld()).players.length; a++){
                    ((Board)getWorld()).turn.addMoney(10);
                    if ((((Board)getWorld()).players[a]).equals(((Board)getWorld()).turn)){
                        ((Board)getWorld()).players[a].subMoney(10);
                    }
                }
                break;
            case "go":
                ((Board)getWorld()).turn.moveToSpace(0);
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
