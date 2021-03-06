import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChestDeck extends Card
{
    public ChestCard[] cards = new ChestCard[16]; 
    
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ChestDeck() {
        // make the deck of chance cards
        cards[0] = new ChestCard("\nGet out of detention for \nfree card.", "free", 0);
        cards[1] = new ChestCard("\nGo to detention (no, you \ndo not get to redo this \nschool year, so no collecting \n$200!)", "jail", 0);
        cards[2] = new ChestCard("\nYour club bake sale went \ngreat. Collect $100.", "add", 100);
        cards[3] = new ChestCard("\nYou found $10 on the way \nto school, just take it.", "add", 10);
        cards[4] = new ChestCard("\nPay school fees: $50.", "sub", 50);
        cards[5] = new ChestCard("\nIt is your birthday. Collect \n$10 from each player.", "b-day", 0);
        cards[6] = new ChestCard("\nYou got to skip a grade! \nAdvance to the next start \nof the school year and \ncollect $200.", "go", 0);
        cards[7] = new ChestCard("\nClassroom repairs. Pay the \nPPO $40 for each house \nand $115 for each hotel.", "repairs", 0);
        cards[8] = new ChestCard("\nChores done! Collect your \nallowance of $100.", "add", 100);
        cards[9] = new ChestCard("\nSecret santa has come. \nReceive $100.", "add", 100);
        cards[10] = new ChestCard("\nYour school club got \napproved and you won a bet. \nCollect $25.", "add", 25);
        cards[11] = new ChestCard("\nAll 'A's this tri, collect $200.", "add", 200);
        cards[12] = new ChestCard("\nMrs. Mendelsohn saw you \neating in the hallway. \nPay $50.", "sub", 50);
        cards[13] = new ChestCard("\nYou forgot your ID. Pay $100.", "sub", 100);
        cards[14] = new ChestCard("\nYour friend borrowed your ID\n for the day. They give you \n$20 in thanks.", "add", 20);
        cards[15] = new ChestCard("\nCommunity service hours \ncomplete. Collect $50.", "add", 50);
    }
    
    public void addCards() {
        for (int i = 0; i <= 15; i++) {
            ((Board)getWorld()).addObject(cards[i], 1000000, 1000000);
        }
    }
    
    public void draw() {
        cards[0].doAction();
        ChestCard temp = cards[0];
        for (int i = 0; i < cards.length - 1; i++) {
            cards[i] = cards[i+1];
        }
        cards[cards.length - 1] = temp;
    }
    
    public void shuffle() {
        for (int i = 0; i < cards.length; i++){
            int j = (int) (Math.random() * (cards.length - i) + i);
            ChestCard temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    
    public void debugging() {
        for(int i = 0; i < cards.length; i++) {
            PropertyInfo p = new PropertyInfo();
            p.setImage(new GreenfootImage("chestCard.jpg"));
            GreenfootImage img = new GreenfootImage(p.getImage());
            img.scale((int)(img.getWidth() / 3.3), (int)(img.getHeight() / 2.89));
            p.setImage(img);
            p.listInfo("Your Chest Card says:\n" + cards[i].message);
            ((Board)getWorld()).addObject(p, 350, 290);
            ((Board)getWorld()).waiting(150);
        }
        
    }
}
