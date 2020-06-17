import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
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
    public int turnsInJail = 0;
    //playerProperties is not a list of properties
    //because it can include railroads and utilities
    //so, we just store the indeces of everything the player
    //currently owns (indeces of the space on the board)
    public ArrayList<Integer> playerProperties = new ArrayList<>();
    //there can be a max of 2 get out of jail cards
    //so the list has length 2
    //the values it stores: 1 = card 0 = no card
    public boolean[] getOutOfJailCards = new boolean[2];
    public int money = 1500;
    public int initialX;
    public int initialY;
    public ArrayList<String> mortgagedProperties = new ArrayList<>();
    
    public Player(String t, int space, String name){
        currentSpace = space;
        this.token = t;
        this.name = name;
        setImage(this.token + "_token_smaller.png");
    }
    
    public void addMoney(int amount){
        money += amount;
    }
    
    public void subMoney(int amount){
        money -= amount;
    }
    
    public void moveOneSpace() /*throws InterruptedException*/ {
        //yeah we still gotta code the actual hopping
        if(currentSpace < 9) {
            setLocation(getX() - 56, getY());
        }
        else if(currentSpace == 9) {
            setLocation(getX() - 65, getY());
        }
        else if(currentSpace < 19) {
            setLocation(getX(), getY() - 55);
        }
        else if(currentSpace == 19) {
            setLocation(getX(), getY() - 65);
        }
        else if(currentSpace < 29) {
            setLocation(getX() + 57, getY());
        }
        else if(currentSpace == 29) {
            setLocation(getX() + 65, getY());
        }
        else if(currentSpace < 39) {
            setLocation(getX(), getY() + 55);
        }
        else if(currentSpace == 39) {
            currentSpace = -1;
            setLocation(initialX, initialY);
        }
        currentSpace += 1;
        /*try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        */
    }
    
    public void moveToSpace(int spaceNumber, boolean passGo) /*throws InterruptedException*/ {
        
        int spaces = 0;
        if (currentSpace > spaceNumber){
            spaces = spaceNumber + (40 - currentSpace);
            if(passGo) {
                addMoney(200);
            }
        }
        else{
            spaces = spaceNumber - currentSpace;
        }
        for (int i = 0; i < spaces; i++){
            moveOneSpace();
        }
    }
    
    public int getCurrentSpace(){
        return currentSpace;
    }
    
    public int getMoney(){
        return money;
    }
    
    public boolean hasAMonopoly(String color) {
        int fullSet; //the number of properties of the color required for a monopoly
        if (color.equals("brown") || color.equals("dark_blue")) {
             fullSet = 2;
        }
        else {
             fullSet = 3;
        }
        int counter = 0;
        for (int i : playerProperties) {
            if (((Board)getWorld()).boardSpaces[i].getType().equals("property")){
                Property p = (Property)(((Board)getWorld()).boardSpaces[i]);
                if(p.color.equals(color)) {
                    counter++;
                }
            }
        }
        return (counter==fullSet);
    }
    
    public void clearPlayer(){
        ((Board)getWorld()).removeObject(this);
        removeAllProperties();
        getOutOfJailCards[0] = false;
        getOutOfJailCards[1] = false;
    }
    
    public void removeAllProperties() {
        for(int i = 0; i < playerProperties.size(); i++) {
            if(((Board)getWorld()).boardSpaces[playerProperties.get(i)].getType().equals("property")) {
                ((Property)((Board)getWorld()).boardSpaces[playerProperties.get(i)]).owner = null;
            }
            else if(((Board)getWorld()).boardSpaces[playerProperties.get(i)].getType().equals("utility")) {
                ((Utility)((Board)getWorld()).boardSpaces[playerProperties.get(i)]).owner = null;
            }
            else if(((Board)getWorld()).boardSpaces[playerProperties.get(i)].getType().equals("railroad")) {
                ((Railroad)((Board)getWorld()).boardSpaces[playerProperties.get(i)]).owner = null;
            }
        }
    }
}
