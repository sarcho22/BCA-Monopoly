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
    public TokenButton t = new TokenButton();
    
    
    public int count = 0;
    public int bCount = 0;
    public int animation = 1;
    public int slowCount = 0;
    public StartingMenu()
    {
        super(1100, 700, 1);
        setPaintOrder(TokenButton.class, PlayButton.class, OurMascot.class);
        
        // to solve that problem, we can probs just put all of this interaction
        // stuff in the play button, so that once u click it, all of the below
        // shows up. All i did just now was change the Text field thingies to ask
        GreenfootImage img = new GreenfootImage("Frame 1.png");
        img.scale(1100, 700);
        setBackground(img);
        
        OurMascot m = new OurMascot();
        addObject(m, 0, 0);
        if(Greenfoot.mouseMoved(null))
        {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                m.setLocation(mouse.getX(),mouse.getY());
        }
        repaint();
            
    }
    
    public void act() {
        if(count < 1) {
            
            addObject(t, 0, 0);
            b1(t);
            count++;
        }
        
        slowCount++;
        if(slowCount >= 13) {
            GreenfootImage img = new GreenfootImage("Frame " + (animation++) + ".png");
            img.scale(1100, 700);
            setBackground(img);
            slowCount = 0;
            if(animation > 16) {
                animation = 1;
            }
        }
        
    }
    
    public void play() {
        PlayButton p = new PlayButton(t.taken, t.wotTaken);
        addObject(p, 578, 368);
    }
    
    public void b1(TokenButton t) {
        this.p1 = Greenfoot.ask("Player 1: Enter a name (leave blank if n/a)");
        if(!p1.equals("")) {
            t.showButtons(p1);
        }
        else{
            play();
        }
    }
    
    public void b2(TokenButton t) {
        this.p2 = Greenfoot.ask("Player 2: Enter a name (leave blank if n/a)");
        if(!p2.equals("")) {
            t.showButtons(p2);
        } 
        else{
            play();
        }
    }
    
    public void b3(TokenButton t) {
        this.p3 = Greenfoot.ask("Player 3: Enter a name (leave blank if n/a)");
        if(!p3.equals("")) {
            t.showButtons(p3);
        } 
        else{
            play();
        }
    }
    
    public void b4(TokenButton t) {
        this.p4 = Greenfoot.ask("Player 4: Enter a name (leave blank if n/a)");
        if(!p4.equals("")) {
            t.showButtons(p4);
        } 
        else{
            play();
        }
        
    }
}
