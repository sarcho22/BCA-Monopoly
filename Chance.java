import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chance extends Space
{
    
    public ChanceDeck deck = new ChanceDeck();
    
    public Chance(String name, int spaceNumber, int[] players){
        super(name, spaceNumber, players, "chance");
    }
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (isOccupied()) {
            drawChanceCard();
        }
    }
   
    
    public void drawChanceCard() {
        //let's say we have 4 dif. chance cards
        int ranDraw = (int)(Math.random() * 4);
        ChanceCard card = deck.pick(ranDraw);
    }
}
