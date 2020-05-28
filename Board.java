import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    public Space[] boardSpaces = new Space[40];
    //Can we make ArrayLists here?
    //we can use this list to redisplay the board and keep track of 
    //where pieces are moving
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //filling the board with the correct spaces
        for (int i = 0; i < 40; i++){
            
        }
    }
}
