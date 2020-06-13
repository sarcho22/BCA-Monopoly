import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Space extends Actor
{
    public String name;
    public int spaceNumber;
    public String type;
    public String[] COLORS = {"corner", "brown", "blank", "brown", "blank", "blank", "light_blue", "blank", "light_blue", "light_blue", "corner", "purple", "blank", "purple", "purple", "blank", "orange", "blank", "orange", "orange", "corner", "red", "blank", "red", "red", "blank", "yellow", "yellow", "blank", "yellow", "corner", "green", "green", "blank", "green", "blank", "blank", "dark_blue", "blank", "dark_blue"};
    
    public Space(String name, int spaceNumber, String type){
        this.name = name;
        this.spaceNumber = spaceNumber;
        this.type = type;
        
        GreenfootImage image = new GreenfootImage(COLORS[spaceNumber] + "_property.png");
        image.setFont(image.getFont().deriveFont(56f));
        image.drawString(name, 10, image.getHeight()/2);
        image.scale(image.getWidth()/5, image.getHeight()/5); // 278 / 5 = 55
        setImage(image);
    }
    
    public String getType(){
        return type;
    }
}
