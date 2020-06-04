import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChestDeck extends Card
{
    public ChestCard[] cards = new ChestCard[16]; // idk the size might change
    // IDK HOW TO ADD THE CHANCE CARDS TO THE THIS THO (it's not letting me idk why)
    
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ChestDeck() {
        // make the deck of chance cards
        cards[0] = new ChestCard("Get out of detention for free card.", "free", 0);
        cards[1] = new ChestCard("Go to detention (no, you do not get to redo this school year, so no collecting $200!)", "jail", 0);
        cards[2] = new ChestCard("Your club bake sale went great. Collect $100.", "add", 100);
        cards[3] = new ChestCard("You found $10 on the way to school, just take it.", "add", 10);
        cards[4] = new ChestCard("Pay school fees: $50.", "sub", 50);
        cards[5] = new ChestCard("It is your birthday. Collect $10 from each player.", "b-day", 0);
        cards[6] = new ChestCard("You got to skip a grade! Advance to the next start of the school year and collect $200.", "go", 0);
        cards[7] = new ChestCard("Classroom repairs. Pay the PPO $40 for each house and $115 for each hotel.", "repairs", 0);
        cards[8] = new ChestCard("Chores done! Collect your allowance of $100.", "add", 100);
        cards[9] = new ChestCard("Secret santa has come. Receive $100.", "add", 100);
        cards[10] = new ChestCard("Your school club got approved and you won a bet. Collect $25.", "add", 25);
        cards[11] = new ChestCard("All As this tri, collect $200.", "add", 200);
        cards[12] = new ChestCard("Mrs. Mendelsohn saw you eating in the hallway. Pay $50.", "sub", 50);
        cards[13] = new ChestCard("You forgot your ID. Pay $100.", "sub", 100);
        cards[14] = new ChestCard("Your friend borrowed your ID for the day. They give you $20 in thanks.", "add", 20);
        cards[15] = new ChestCard("Community service hours complete. Collect $50.", "add", 50);
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
