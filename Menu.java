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
    public Menu() {
        GreenfootImage i = new GreenfootImage("blank_property.png");
        i.scale((int)(i.getWidth() * 1.5), (int)(i.getHeight() * 2));
        i.setFont(i.getFont().deriveFont(15f));
        i.drawString("Dice: ", i.getWidth()/2-175, 100);
        i.drawString("Mortgage Property!", i.getWidth()/2-175, 160);
        i.drawString("Sell Houses!", i.getWidth()/2-175, 220);
        i.drawString("List of Player Properties:", i.getWidth()/2-175, 280);
        i.drawString("Current Property:", i.getWidth()/2-175, 340);
        i.drawString("Chance/Chest cards:", i.getWidth()/2-175, 400);
        setImage(i);
        
    }
    public void callPlay() 
    {
        ((Board)getWorld()).play();
        once = true;
    }    
}
