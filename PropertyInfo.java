import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PropertyInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PropertyInfo extends Actor
{
    /**
     * Act - do whatever the PropertyInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PropertyInfo() {
        GreenfootImage i = new GreenfootImage(getImage());
        i.scale((int)(i.getWidth() / 1.5), (int)(i.getHeight() / 1.5));
        setImage(i);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void listInfo(String info) {
        GreenfootImage i = getImage();
        i.setFont(i.getFont().deriveFont(12f));
        i.drawString(info, 20, 20);
    }
    
    public void listPropInfo(Space s) {
        // field
        // draw the string
        String name = ((Property)s).name;
        if (name.equals("Comp Sci\n(room 138)")) {
            name = "Comp Sci";
        }
        if (name.indexOf("\n") != -1) {
            name = name.substring(0, name.indexOf("\n")) + " " + name.substring(name.indexOf("\n") + 1);
        }
        
        GreenfootImage i = getImage();
        int centerX = 10;
        if (s.type.equals("property")) {
            i.setFont(new Font("OptimusPrinceps", false, false, 16));
            Property p = ((Property)s);
            if (p.name.length() <= 3) {
                name = "\t\t\t" + name + "\t\t\t";
            }
            else if (p.name.length() < 7) {
                name = "\t\t" + name + "\t\t";
            }
            else if (p.name.length() < 12) {
                name = "\t" + name + "\t";
            }
            i.drawString(name.toUpperCase(), 35, 29);
            i.setFont(new Font("OptimusPrinceps", false, false, 14));
            i.drawString("PRICE $" + p.price + "\n", 10, 58);
            i.setFont(new Font("OptimusPrinceps", false, false, 12));
            i.drawString("RENT $" + p.rent, 65, 86);
            i.drawString("With 1 house: \t\t$" + p.houseRents[0], centerX, 105);
            i.drawString("With 2 houses: \t\t$" + p.houseRents[1], centerX, 120);
            i.drawString("With 3 houses: \t\t$" + p.houseRents[2], centerX, 135);
            i.drawString("With 4 houses: \t\t$" + p.houseRents[3], centerX, 150);
            i.drawString("With hotel: \t\t$" + 50 * ((p.spaceNumber/10) + 1), centerX, 165);
            i.setFont(new Font("OptimusPrinceps", false, false, 10));
            i.drawString("Mortgage Price: $" + p.mortgagePrice, centerX, 180);
        }
        
        
    }
    
    public void listUtilInfo(Space s) {
        String name = s.name;
        if (name.indexOf("\n") != -1) {
            name = name.substring(0, name.indexOf("\n")) + " " + name.substring(name.indexOf("\n") + 1);
        }
        GreenfootImage i = getImage();
        i.setFont(new Font("OptimusPrinceps", false, false, 16));
        i.drawString(name.toUpperCase(), 38, 29);
        i.setFont(new Font("OptimusPrinceps", false, false, 12));
        i.drawString("If one utility is owned,\n rent is 4 times amount\n shown on dice", 33, 59);
        i.drawString("If both utilites are owned,\n rent is 10 times amount\n shown on dice", 33, 115);
        i.setFont(new Font("OptimusPrinceps", false, false, 10));
        i.drawString("Mortgage Price: $" + ((Utility)s).mortgagePrice, 33, 175);
    }
    
    public void listRailInfo(Space s) {
        String name = s.name;
        if (name.indexOf("\n") != -1) {
            name = name.substring(0, name.indexOf("\n")) +  " " + name.substring(name.indexOf("\n") + 1);
        }
        GreenfootImage i = getImage();
        i.setFont(new Font("OptimusPrinceps", false, false, 16));
        i.drawString(name.toUpperCase(), 38, 29);
        i.setFont(new Font("OptimusPrinceps", false, false, 14));
        i.drawString("Price: $" + ((Railroad)s).price, 38, 50);;
        i.setFont(new Font("OptimusPrinceps", false, false, 12));
        i.drawString("Rent: \t\t\t\t\t$25", 10, 70);
        i.drawString("If 2 H's are owned: \t$" + 50, 10, 95);
        i.drawString("If 3: \t\t\t\t$" + 100, 10, 120);
        i.drawString("If 4: \t\t\t\t$" + 200, 10, 145);
        i.setFont(new Font("OptimusPrinceps", false, false, 10));
        i.drawString("Mortgage Price: $" + ((Railroad)s).mortgagePrice, 10, 173);
    }
    
    public void listOwner(String owner) {
        GreenfootImage i = getImage();
        i.setFont(i.getFont().deriveFont(12f));
        i.drawString("OWNED BY: " + owner, 40, 200);
    }
}
