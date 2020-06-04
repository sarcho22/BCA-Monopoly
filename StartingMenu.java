import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartingMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartingMenu extends World
{

    /**
     * Constructor for objects of class StartingMenu.
     * 
     */
    public String p1;
    public String p2;
    public String p3;
    public String p4;
    
    public StartingMenu()
    {
        super(1100, 700, 1);
        TokenButton t = new TokenButton();
        
        // To remind myself: the reason why we're having this error is because
        // We're in the constructor of the StartingMenu rn, so startingmenu
        // hasn't been created, and cuz of that, getWorld() isn't working.
        // we probably need to move this code out of the constructor owoowowowoo
        // omnomnomnom eat the oms
        // and to solve that problem, we can probs just put all of this interaction
        // stuff in the play button, so that once u click it, all of the below
        // shows up. All i did just now was change the Text field thingies to ask
        this.p1 = Greenfoot.ask("Player 1: Enter a name (leave blank if n/a)");
        if(p1 != null) {
            t.showButtons(p1);
        }
        
        this.p2 = Greenfoot.ask("Player 2: Enter a name (leave blank if n/a)");
        if(p2 != null) {
            t.showButtons(p2);
        }
        
        this.p3 = Greenfoot.ask("Player 3: Enter a name (leave blank if n/a)");
        if(p3 != null) {
            t.showButtons(p3);
        }
        
        this.p4 = Greenfoot.ask("Player 4: Enter a name (leave blank if n/a)");
        if(p4 != null) {
            t.showButtons(p4);
        }
        
        play();
    }
    
    public void play() {
        PlayButton p = new PlayButton(p1, p2, p3, p4);
        addObject(p, 550, 350);
    }
}
