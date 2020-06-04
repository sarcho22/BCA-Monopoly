import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    public ArrayList<String> players = new ArrayList<>();
    public ArrayList<String> tokens = new ArrayList<>();
    
    public PlayButton(ArrayList<String> p, ArrayList<String> t) {
        this.players = p;
        this.tokens = t;
        
    }
    
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)) {
            if(players.size() <= 0) {
                ((StartingMenu)getWorld()).showText("dats sad (´。＿。｀)", 550, 350);
            }
            else if(players.size() < 2) {
                ((StartingMenu)getWorld()).showText("don't you think it's a little sad to play by yourself???", 550, 200);
            }
            else {
                Board play = new Board(players, tokens);
                // Greenfoot.stop(); owo
                Greenfoot.setWorld(play);
            }
            
        }
    }    
}
