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
    //playerProperties is not a list of properties
    //because it can include railroads and utilities
    //so, we just store the indeces of everything the player
    //currently owns (indeces of the space on the board)
    public int[] playerProperties;
    //there can be a max of 2 get out of jail cards
    //so the list has length 2
    //the values it stores: 1 = card 0 = no card
    public int[] getOutOfJailCards = new int[2];
    public int[] mortagedProperties;
    public int money = 1500;
    
    public Player(String t, int space, String name){
        currentSpace = space;
        token = t;
        this.name = name;
    }
    
    public void goToJail() 
    {
        inJail = true;
        moveToSpace(10); 
        // figure out how to put them in 
        //physically into the jail
    }
    
    public void addMoney(int amount){
        money += amount;
    }
    
    public void subMoney(int amount){
        money -= amount;
    }
    
    public void moveOneSpace(){
        //yeah we still gotta code the actual hopping
        currentSpace += 1;
    }
    
    public void moveToSpace(int spaceNumber) {
        currentSpace = spaceNumber;
    }
    
    public int getCurrentSpace(){
        return currentSpace;
    }
    
    public int getMoney(){
        return money;
    }
}
