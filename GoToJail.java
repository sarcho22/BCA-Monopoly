import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoToJail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoToJail extends Corner
{
    public GoToJail(int[] players){
        super("Go to Detention", 30, players, "gotojail");
        //needs to add bonus to those that just landed or crossed it
    }
    /**
     * Act - do whatever the GoToJail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void inJail() 
    {
        // Add your action code here.
        for(int p : players) {
            //code to move player image to the jail spot
            //for each player, call moveToSpace(11);
        
        }
    }    
}
