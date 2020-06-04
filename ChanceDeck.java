import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChanceDeck extends Card
{
    public ChanceCard[] cards = new ChanceCard[16]; // idk the size might change
    // IDK HOW TO ADD THE CHANCE CARDS TO THE THIS THO (it's not letting me idk why)
    
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ChanceDeck() {
        // make the deck of chance cards NEED ACTIONS HERE
        cards[0] = new ChanceCard("Go to detention (no, you do not get to redo this school year, so no collecting $200!)", "jail", 0);
        cards[1] = new ChanceCard("Go back three spaces (you forgot your calculator).", "3", 0);
        cards[2] = new ChanceCard("Mr. Hathaway wants to meet with you. Go to his classroom, see if you can collect $200 on the way there.", "hathaway", 0);
        cards[3] = new ChanceCard("Advance to Dr. Penev’s room, if possible, collect $200 on the way.", "penev", 0);
        cards[4] = new ChanceCard("Advance to the CS room 138.", "138", 0);
        cards[5] = new ChanceCard("You got an A on your math test. Your parents give you $150.", "add", 150);
        cards[6] = new ChanceCard("You got to skip a grade! Advance to the next start of the school year and collect $200.", "go", 0);
        cards[7] = new ChanceCard("Classroom repairs. Pay the PPO $25 for each house and $100 for each hotel you own.", "repairs", 0);
        cards[8] = new ChanceCard("You were elected class president, so time to give back to those who elected you. Pay $50 to each player.", "election", 0);
        cards[9] = new ChanceCard("Grandma is over, she sneaks you $50.", "add", 50);
        cards[10] = new ChanceCard("Advance to the nearest cafeteria. If it is OWNED throw the dice and pay the owner 10 times the amount thrown (otherwise you can buy it yourself).", "caf", 0);
        cards[11] = new ChanceCard("Mrs. Mendelsohn saw you slouching in the hallway. Pay $15.", "sub", 15);
        cards[12] = new ChanceCard("Get out of detention for free card.", "free", 0);
        cards[13] = new ChanceCard("Take a trip to the “T” hallway, if a new school year starts, collect $200.", "T", 0);
        cards[14] = new ChanceCard("Advance to the nearest hallway. If it is OWNED, play the owner 2 times the ordinary rent (otherwise you can buy it yourself).", "hall", 0);
        cards[15] = new ChanceCard("Advance to the nearest hallway. If it is OWNED, play the owner 2 times the ordinary rent (otherwise you can buy it yourself).", "hall", 0);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void draw() {
        //I'm guessing we pick a certain chanceCard?
        //let's say we have 4 dif. chance cards
        cards[0].doAction();
        ChanceCard temp = cards[0];
        for (int i = 0; i < cards.length - 1; i++) {
            cards[i] = cards[i+1];
        }
        cards[cards.length - 1] = temp;
    }
    
    public void shuffle() {
        // shuffle the cards
    }
}
