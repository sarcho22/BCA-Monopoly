import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PropertyInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PropertyInfo extends Actor
{
    /**
     * Act - do whatever the PropertyInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PropertyInfo() {
        GreenfootImage i = new GreenfootImage(getImage());
        i.scale((int)(i.getWidth() / 1.5), (int)(i.getHeight() / 1.5));
        setImage(i);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void listInfo(String info) {
        // field
        // draw the string
        GreenfootImage i = getImage();
        i.setFont(i.getFont().deriveFont(12f));
        i.drawString(info, 20, 20);
    }
    
    public void listOwner(String owner) {
        GreenfootImage i = getImage();
        i.setFont(i.getFont().deriveFont(12f));
        i.drawString("OWNED BY: " + owner, 40, 200);
    }
}
