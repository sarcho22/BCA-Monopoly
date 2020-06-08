
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
            ((StartingMenu)getWorld()).addObject(c, 20, 350);
        }
        if(!dog) {
            Dog c = new Dog(playerName);
            ((StartingMenu)getWorld()).addObject(c, 220, 350);
        }
        if(!thimble) {
            Thimble c = new Thimble(playerName);
            ((StartingMenu)getWorld()).addObject(c, 420, 350);
        }
        if(!hat) {
            Hat c = new Hat(playerName);
            ((StartingMenu)getWorld()).addObject(c, 720, 350);
        }
        if(!boat) {
            Boat c = new Boat(playerName);
            ((StartingMenu)getWorld()).addObject(c, 850, 350);
        }
    }    
    
    public void updateTaken(String playerName, String token) {
        taken.add(playerName);
        wotTaken.add(token);
        
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
