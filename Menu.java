import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean once = false;
    public String listOfProperties = "";
    public Menu() {
        GreenfootImage i = new GreenfootImage("blank_property.png");
        i.scale((int)(i.getWidth() * 1.5), (int)(i.getHeight() * 2));
        i.setFont(i.getFont().deriveFont(15f));
        i.drawString("Dice: ", i.getWidth()/2-175, 60);
        i.drawString("Mortgage Property!", i.getWidth()/2-175, 130);
        i.drawString("Sell Houses!", i.getWidth()/2-175, 200);
        i.drawString("Current Property:", i.getWidth()/2, 270);
        i.drawString("List of Player Properties: \n", i.getWidth()/2-175, 270);
        i.drawString("Leaderboard: \n", i.getWidth()/2-175, 540);
        setImage(i);
        
    }
    
    public void callPlay() 
    {
        ((Board)getWorld()).play();
        once = true;
    }   
    
    public void getPlayerProperties() {
        listOfProperties = "";
        for(int i = 0; i < ((Board)getWorld()).turn.playerProperties.size(); i++) {
            if(((Board)getWorld()).turn.mortgagedProperties.indexOf(((Board)getWorld()).turn.playerProperties.get(i)) == -1) {
                listOfProperties += ((Board)getWorld()).turn.playerProperties.get(i) + ": " + ((Board)getWorld()).boardSpaces[((Board)getWorld()).turn.playerProperties.get(i)].name + "\n";
            }
        }
    }
}
