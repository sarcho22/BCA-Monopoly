
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class TokenButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TokenButton extends Actor
{
    // true = taken already :)))
    public boolean car;
    public boolean dog;
    public boolean thimble;
    public boolean boat;
    public boolean hat;
    public ArrayList<String> taken = new ArrayList<>();
    public ArrayList<String> wotTaken = new ArrayList<>();
    
    /**
     * Act - do whatever the TokenButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void showButtons(String playerName) 
    {
        ((StartingMenu)getWorld()).addObject(new BCA(), 236+32, 140);
        ((StartingMenu)getWorld()).addObject(new Monopoly(), 607+32, 140);
        
        if(!thimble) {
            Thimble c = new Thimble(playerName);
            ((StartingMenu)getWorld()).addObject(c, 241, 368);
            
            TokenBackground bg = new TokenBackground();
            GreenfootImage img = new GreenfootImage("TokenBackground.png");
            img.scale(c.getImage().getWidth() + 30, c.getImage().getHeight() + 30);
            bg.setImage(img);
            ((StartingMenu)getWorld()).addObject(bg, 241, 368);
        }
        if(!dog) {
            Dog c = new Dog(playerName);
            ((StartingMenu)getWorld()).addObject(c, 513, 352);
            
            TokenBackground bg = new TokenBackground();
            GreenfootImage img = new GreenfootImage("TokenBackground.png");
            img.scale(c.getImage().getWidth() + 30, c.getImage().getHeight() + 30);
            bg.setImage(img);
            ((StartingMenu)getWorld()).addObject(bg, 513, 352);
        }
        if(!hat) {
            Hat c = new Hat(playerName);
            ((StartingMenu)getWorld()).addObject(c, 822, 356);
            
            TokenBackground bg = new TokenBackground();
            GreenfootImage img = new GreenfootImage("TokenBackground.png");
            img.scale(c.getImage().getWidth() + 30, c.getImage().getHeight() + 30);
            bg.setImage(img);
            ((StartingMenu)getWorld()).addObject(bg, 822, 356);
        }
        if(!car) {
            Car c = new Car(playerName);
            ((StartingMenu)getWorld()).addObject(c, 359, 607);
            
            TokenBackground bg = new TokenBackground();
            GreenfootImage img = new GreenfootImage("TokenBackground.png");
            img.scale(c.getImage().getWidth() + 30, c.getImage().getHeight() + 30);
            bg.setImage(img);
            ((StartingMenu)getWorld()).addObject(bg, 359, 607);
        }
        if(!boat) {
            Boat c = new Boat(playerName);
            ((StartingMenu)getWorld()).addObject(c, 659, 619);
            
            TokenBackground bg = new TokenBackground();
            GreenfootImage img = new GreenfootImage("TokenBackground.png");
            img.scale(c.getImage().getWidth() + 30, c.getImage().getHeight() + 30);
            bg.setImage(img);
            ((StartingMenu)getWorld()).addObject(bg, 659, 619);
        }
    }    
    
    public void updateTaken(String playerName, String token) {
        taken.add(playerName);
        wotTaken.add(token);
        
        ((StartingMenu)getWorld()).removeObjects(((StartingMenu)getWorld()).getObjects(TokenBackground.class));
        ((StartingMenu)getWorld()).removeObjects(((StartingMenu)getWorld()).getObjects(Dog.class));
        ((StartingMenu)getWorld()).removeObjects(((StartingMenu)getWorld()).getObjects(Boat.class));
        ((StartingMenu)getWorld()).removeObjects(((StartingMenu)getWorld()).getObjects(Car.class));
        ((StartingMenu)getWorld()).removeObjects(((StartingMenu)getWorld()).getObjects(Hat.class));
        ((StartingMenu)getWorld()).removeObjects(((StartingMenu)getWorld()).getObjects(Thimble.class));
        
        switch(((StartingMenu)getWorld()).bCount) {
            case 0:
                ((StartingMenu)getWorld()).bCount++;
                ((StartingMenu)getWorld()).b2(((StartingMenu)getWorld()).t);
                break;
            case 1:
                ((StartingMenu)getWorld()).bCount++;
                ((StartingMenu)getWorld()).b3(((StartingMenu)getWorld()).t);
                break;
            case 2:
                ((StartingMenu)getWorld()).bCount++;
                ((StartingMenu)getWorld()).b4(((StartingMenu)getWorld()).t);
                break;
            case 3:
                ((StartingMenu)getWorld()).play();
                break;
            default:
                break;
        }
    }
}
