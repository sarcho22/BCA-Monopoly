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
    public Dice dice = new Dice();
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
        startGame();
        //filling the board with the correct spaces
        //boardSpaces[0] = (Space) Go();
        //boardSpaces[10] = (Space) Jail();
        //boardSpaces[20] = (Space) Free();
        //boardSpaces[30] = (Space) GoToJail();
        for (int i = 0; i < 40; i++){
            
        }
        play();
    }
    
    public void startGame(){
        //starts game asking for how many players, their names and tokens
        //creates players with this information
    }
    
    public void play(){
        //make a while loop that keeps track if people won or not
        //make a var that goes through the players cyclically
        //create a button "roll" which calls dice.roll()
        //save the amount and move the player
        //a conditional statement that checks if:
            //any type of property that has an owner, you pay rent
            //else if it has no owner
            //property then asks if player wants to buy (allows if enough $)
            //utility/railroad same
            //chance/chest then draw a new card
            //taxes or go lose/gain money
            //if player out of money, asks to mortgage something
            //if player landed on a color that they own completely ask to 
                //build house or hotel (depending on what is appropriate)
            //if go to jail send to jail (there is a method in player)
        //we wont due player-player trading for now
        //if even, update counter, ask to re-roll 
            //(if even three times then send to jail 
            //immediately after the third roll without moving)
            //ask if they want to use get out of jail if they have it
            //if they have ask for $50
            //3 next moves let them try to "roll-out" of it (have to roll even)
            //if they fail, force 50 even if they go bankrupt
            //if they got out of jail, move them to "just visiting"
        //switch player number and go to the top
    }
}
