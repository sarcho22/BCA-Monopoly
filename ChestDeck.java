import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChestDeck extends Card
{
    public ChestCard[] cards = new ChestCard[4]; // idk the size might change
    // IDK HOW TO ADD THE CHANCE CARDS TO THE THIS THO (it's not letting me idk why)
    
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ChestDeck() {
        // make the deck of chance cards
        // cards[0] = new ChestCard("", "");
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void draw() {
        //I'm guessing we pick a certain chanceCard?
        //let's say we have 4 dif. chance cards
        cards[0].doAction();
        ChestCard temp = cards[0];
        for (int i = 0; i < cards.length - 1; i++) {
            cards[i] = cards[i+1];
        }
        cards[cards.length - 1] = temp;
    }
    
    public void shuffle() {
        // shuffle the cards
    }
}
