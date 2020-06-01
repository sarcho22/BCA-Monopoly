import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public String token;
    public int currentSpace;
    public String name;
    public boolean inJail;
    public int[] playerProperties; //ints will be their indeces on the board
    public int[] getOutOfJailCards; //1 = card 0 = no card
    public int[] mortagedProperties;
    public int money = 1500;
    
    public Player(String t, int space, String name){
        currentSpace = space;
        token = t;
        this.name = name;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void goToJail() 
    {
        inJail = true;
        //put them physically into the jail
    }
    
    public void addMoney(int amount){
        
    }
    
    public void subMoney(int amount){
        
    }
    
    public void moveOneSpace(){
    }
    
    public int getCurrentSpace(){
        return currentSpace;
    }
}
