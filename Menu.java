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
        i.drawString("Roll!", i.getWidth()/2-120, 100);
        i.drawString("Buy Property!", i.getWidth()/2-120, 160);
        i.drawString("Mortgage Property!", i.getWidth()/2-120, 220);
        i.drawString("Get out of Jail (isn't that illegal hmMmMmM)!", i.getWidth()/2-120, 280);
        i.drawString("Buy Houses!", i.getWidth()/2-120, 340);
        i.drawString("Sell Houses!", i.getWidth()/2-120, 400);
        i.drawString("Pass Turn!", i.getWidth()/2-120, 460);
        setImage(i);
        
    }
    public void callPlay() 
    {
        // Add your action code here.
        
            ((Board)getWorld()).showText("hello", 500, 400);
            ((Board)getWorld()).play();
            once = true;
        
    }    
}
