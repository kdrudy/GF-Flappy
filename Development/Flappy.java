import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappy extends Actor
{
    FlappyWorld flappyWorld;
    
    private double fallingSpeed = 1.0;
    
    private final double FLAP = 16.0;
    
    GreenfootImage flapImage, fallImage;
    
    boolean flapped = false;
    boolean alive = true;
    
    public Flappy() {
        fallImage = getImage();
        fallImage.scale(fallImage.getWidth()/10, fallImage.getHeight()/10);
        setImage(fallImage);
        
        flapImage = new GreenfootImage("frame-2.png");
        flapImage.scale(flapImage.getWidth()/10, flapImage.getHeight()/10);
    }
    
    /**
     * Act - do whatever the Flappy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(alive) {
            processKeys();
        }
        applyGravity();
        
        normalizeFallingSpeed();
        handleImage();
        
        setLocation(getX(), getY()+(int)fallingSpeed);
        
        checkCollision();
    }    
    
    private void checkCollision() {
        java.util.List<Pipe> intersecting = getIntersectingObjects(Pipe.class);
        if(intersecting.size() > 0 && alive) {
            alive = false;
            fallImage.mirrorVertically();
        }
        
        if(getY() >= flappyWorld.getHeight()-10) {
            alive = false;
            flappyWorld.addObject(new GameOver(), 300, 300);
            Greenfoot.stop();
        }
    }
    
    private void normalizeFallingSpeed() {
        if(fallingSpeed < -20) {
            fallingSpeed = -20;
        }
        
        if(fallingSpeed > 20) {
            fallingSpeed = 20;
        }
    }
    
    private void handleImage() {
        if(fallingSpeed > 0) {
            setImage(fallImage);
        } else {
            setImage(flapImage);
        }
        
    }
    
    private void applyGravity() {
        fallingSpeed += flappyWorld.getGravity();
    }
    
    private void processKeys() {
        if(Greenfoot.isKeyDown("up") && !flapped) {
            fallingSpeed -= FLAP;
            flapped = true;
        }
        
        if(!Greenfoot.isKeyDown("up") && flapped) {
            flapped = false;
        }
    }
    
    public void addedToWorld(World world) {
        flappyWorld = (FlappyWorld) world;
    }
    
    public boolean isAlive() {
        return alive;
    }
}
