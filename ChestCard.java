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
    
    public void doAction() {
        GreenfootImage i = ((Board)getWorld()).menu.getImage();
        i.drawString("", i.getWidth()/2-200, i.getHeight()/2+200);
        i.setFont(i.getFont().deriveFont(12f));
        i.drawString("Your ChestCard says:\n" + message, i.getWidth()/2-200, i.getHeight()/2+200);
        
        switch(action) {
            case "add":
                ((Board)getWorld()).turn.addMoney(amount);
                break;
            case "sub":
                ((Board)getWorld()).turn.subMoney(amount);
                break;
            case "free":
                //add a get out of jail card to the player
                if (!((Board)getWorld()).turn.getOutOfJailCards[0]){
                    ((Board)getWorld()).turn.getOutOfJailCards[0] = true;
                }
                else if (!((Board)getWorld()).turn.getOutOfJailCards[1]){
                    ((Board)getWorld()).turn.getOutOfJailCards[1] = true;
                }
                break;
            case "jail":
                ((Board)getWorld()).goToJail();
                break;
            case "b-day":
                //collect $10 from each player
                for (int a = 0; a < ((Board)getWorld()).players.size(); a++){
                    ((Board)getWorld()).turn.addMoney(10);
                    if ((((Board)getWorld()).players.get(a)).equals(((Board)getWorld()).turn)){
                        ((Board)getWorld()).players.get(a).subMoney(10);
                    }
                }
                break;
            case "go":
                ((Board)getWorld()).turn.moveToSpace(0, true);
                break;
            case "repairs":
                int houses = 0;
                int hotels = 0;
                for (int a = 0; a < ((Board)getWorld()).players.size(); a++){
                    for (int b = 0; b < ((Board)getWorld()).players.get(a).playerProperties.size(); b++){
                        int propNum = ((Board)getWorld()).players.get(a).playerProperties.get(b);
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
                }
                //pay $40 for each house and $115 per hotel (for all buildings)
                ((Board)getWorld()).turn.subMoney(40 * houses + 115 * hotels);
                break;
            default:
                break;
        }
    }
}
