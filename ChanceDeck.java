import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChanceDeck extends Card
{
    public ChanceCard[] cards = new ChanceCard[16]; 
    
    /**
     * Act - do whatever the Chance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ChanceDeck() {
        cards[5] = new ChanceCard("\nGo to detention (no, you do\nnot get to redo this \nschool year, so no \ncollecting $200!)", "jail", 0);
        cards[1] = new ChanceCard("\nGo back three spaces (you \nforgot your calculator).", "3", 0);
        cards[2] = new ChanceCard("\nMr. Hathaway wants to meet \nwith you. Go to his \nclassroom, see if you can \ncollect $200 on the way.", "hathaway", 0);
        cards[3] = new ChanceCard("\nAdvance to Dr. Penev’s \nroom, if possible, collect \n$200 on the way.", "penev", 0);
        cards[4] = new ChanceCard("\nAdvance to the CS room 138.", "138", 0);
        cards[0] = new ChanceCard("\nYou got an A on your math test. \nYour parents give you $150.", "add", 150);
        cards[6] = new ChanceCard("\nYou got to skip a grade! \nAdvance to the next start \nof the school year and \ncollect $200.", "go", 0);
        cards[7] = new ChanceCard("\nClassroom repairs. Pay the \nPPO $25 for each house and \n$100 for each hotel \nyou own.", "repairs", 0);
        cards[8] = new ChanceCard("\nYou were elected class \npresident, so time to give \nback to those who \nelected you. Pay $50 \nto each player.", "election", 0);
        cards[9] = new ChanceCard("\nGrandma is over, she \nsneaks you $50.", "add", 50);
        cards[10] = new ChanceCard("\nAdvance to the nearest \ncafeteria. If it is OWNED throw \nthe dice and pay the owner \n10 times the amount thrown \n(otherwise you can buy it \nyourself).", "caf", 0);
        cards[11] = new ChanceCard("\nMrs. Mendelsohn saw you \nslouching in the hallway. \nPay $15.", "sub", 15);
        cards[12] = new ChanceCard("\nGet out of detention for \nfree card.", "free", 0);
        cards[13] = new ChanceCard("\nTake a trip to the “T” \nhallway, if a new school year \nstarts, collect $200.", "T", 0);
        cards[14] = new ChanceCard("\nAdvance to the nearest \nhallway. If it is OWNED, pay \nthe owner 2 times the \nordinary rent (otherwise \nyou can buy it yourself).", "hall", 0);
        cards[15] = new ChanceCard("\nAdvance to the nearest \nhallway. If it is OWNED, pay \nthe owner 2 times the \nordinary rent (otherwise \nyou can buy it yourself).", "hall", 0);
        
    } 
    
    public void addCards() {
        for (int i = 0; i <= 15; i++) {
            ((Board)getWorld()).addObject(cards[i], 1000000, 1000000);
        }
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
        for (int i = 0; i < cards.length; i++){
            int j = (int) (Math.random() * (cards.length - i) + i);
            ChanceCard temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    
    public void debugging() {
        for(int i = 0; i < cards.length; i++) {
            PropertyInfo p = new PropertyInfo();
            p.setImage(new GreenfootImage("chanceCard.jpg"));
            GreenfootImage img = new GreenfootImage(p.getImage());
            img.scale((int)(img.getWidth() / 3.3), (int)(img.getHeight() / 2.89));
            p.setImage(img);
            p.listInfo("Your Chance Card says:\n" + cards[i].message);
            ((Board)getWorld()).addObject(p, 350, 290);
            ((Board)getWorld()).waiting(150);
        }
        
    }
}
