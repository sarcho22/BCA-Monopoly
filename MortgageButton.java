import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MortgageButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MortgageButton extends Actor
{
    /**
     * Act - do whatever the MortgageButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MortgageButton() {
        GreenfootImage i = new GreenfootImage(getImage());
        i.scale((int)(i.getWidth() / 7), (int)(i.getHeight() / 7));
        setImage(i);
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            ((Board)getWorld()).askToMortgage();
        }
    }    
}
