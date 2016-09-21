import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    private String text = "Game Over";
    
    private int stringWidth = 0;    
    java.awt.Graphics g;
    
    public GameOver() {
        
        setImage(new GreenfootImage(300, 100));
        GreenfootImage image = getImage();
        java.awt.Font font = image.getFont();
        image.setFont(font.deriveFont(30.0F));  // use larger font
               
        g = image.getAwtImage().createGraphics();   
        stringWidth = g.getFontMetrics(image.getFont()).stringWidth(text);
        
        updateImage();
    }
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateImage();
    }
    
    private void updateImage() {
        GreenfootImage image = getImage();
        image.clear();
        image.fill();
        image.setColor(java.awt.Color.WHITE);
        
        image.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
        image.drawString(text, (image.getWidth()/2) - (stringWidth/2), (image.getHeight()/2) + 10);
    }
}