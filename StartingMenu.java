import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
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
        
        this.p1 = JOptionPane.showInputDialog("Player 1: Enter a name (leave blank if n/a)");
        if(p1 != null) {
            t.showButtons(p1);
        }
        
        this.p2 = JOptionPane.showInputDialog("Player 2: Enter a name (leave blank if n/a)");
        if(p2 != null) {
            t.showButtons(p2);
        }
        
        this.p3 = JOptionPane.showInputDialog("Player 3: Enter a name (leave blank if n/a)");
        if(p3 != null) {
            t.showButtons(p3);
        }
        
        this.p4 = JOptionPane.showInputDialog("Player 4: Enter a name (leave blank if n/a)");
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
