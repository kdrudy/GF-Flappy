import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{
    int height;
    
    public Pipe() {
        this(300);
    }
    
    public Pipe(int h) {
        height = h;
        
        setImage(new GreenfootImage(50, height));
        
        drawPipe();
    }
    
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        drawPipe();
    }    
    
    private void drawPipe() {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(java.awt.Color.GREEN);
        
        image.fill();
    }
}
