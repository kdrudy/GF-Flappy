import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    
    private int value = 0;
    private String text = "Score: ";
    
    private int stringLength;
    
    java.awt.Color color = java.awt.Color.WHITE;
    
    FlappyWorld flappyWorld;
    
    public Score() {
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        java.awt.Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font

        updateImage();
    }
    
        public void addedToWorld(World world) {
        flappyWorld = (FlappyWorld) world;
    }
    
    protected void updateImage() {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(color);
        image.drawString(text + value, 1, 18);
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        value = flappyWorld.getScore();
        updateImage();
    }    
}
