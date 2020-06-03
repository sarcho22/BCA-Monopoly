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
        // Add your action code here.
        if(!car) {
            Car c = new Car(playerName);
            ((StartingMenu)getWorld()).addObject(c, 330, 350);
        }
        if(!dog) {
            Dog c = new Dog(playerName);
            ((StartingMenu)getWorld()).addObject(c, 360, 350);
        }
        if(!thimble) {
            Thimble c = new Thimble(playerName);
            ((StartingMenu)getWorld()).addObject(c, 390, 350);
        }
        if(!hat) {
            Hat c = new Hat(playerName);
            ((StartingMenu)getWorld()).addObject(c, 420, 350);
        }
        if(!boat) {
            Boat c = new Boat(playerName);
            ((StartingMenu)getWorld()).addObject(c, 450, 350);
        }
    }    
    
    public void updateTaken(String playerName, String token) {
        taken.add(playerName);
        wotTaken.add(token);
    }
}
