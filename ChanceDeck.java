import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChanceDeck extends Card
{
    ChanceCard[] cards = new ChanceCard[4]; //idk the size might change
    //IDK HOW TO ADD THE CHANCE CARDS TO THE THIS THO (it's not letting me idk why)
    
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public ChanceCard pick(int num) {
        //I'm guessing we pick a certain chanceCard?
        cards[num].doAction();
        return cards[num];
    }
}
