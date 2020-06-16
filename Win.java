import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends World
{
    
    public String winnerName;
    public int round;
    
    /**
     * Constructor for objects of class Win.
     * 
     */
    public Win(String winnerName, int round)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.winnerName = winnerName;
        this.round = round;
        drawStuff();
        
    }
    
    public void drawStuff() {
        showText(winnerName + " won! after " + round + " rounds LOLOLOLOL", getWidth() / 2, getHeight() / 2);
    }
}
