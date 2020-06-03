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
    
    public PlayButton(String p1, String p2, String p3, String p4) {
        if(p1 != null) {
            players.add(p1);
        }
        
        if(p2 != null) {
            players.add(p2);
        }
        
        if(p3 != null) {
            players.add(p3);
        }
        
        if(p4 != null) {
            players.add(p4);
        }
        
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
                Board play = new Board(/*players*/);
                // Greenfoot.stop(); owo
                Greenfoot.setWorld(play);
            }
            
        }
    }    
}
