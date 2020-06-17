import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Free here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Free extends Corner
{
    public int jackpot = 0;
    
    public Free(){
        super("Commons", 20, "free", "Commons (make sure\n to be quiet)");
        //needs to add bonus to those that just landed or crossed it
    }
    
    /**
     * Act - do whatever the Free wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    public void collectMoney() {
        //if (isOccupied()) { <--- use list of players and check individually instead
        //    Player p = ((Board)getWorld()).turn;
        //    p.addMoney(jackpot);
        //}
        //see the thing I'm hesitant about is idk how isOccupied is gonna work
        //thats why this is here and not in act
    }
    
    public void addMoney(int money) {
        jackpot += money;
    }
}
