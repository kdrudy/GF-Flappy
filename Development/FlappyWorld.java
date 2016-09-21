import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{

    private final double GRAVITY = 0.5;
    
    Flappy flappy;
    
    Pipe topPipe, bottomPipe;
    
    int score = 0;
    boolean scored = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        flappy = new Flappy();
        addObject(flappy, 300, 300);
        
        addObject(new Score(), 100, 50);
        
        setPaintOrder(GameOver.class, Flappy.class, Score.class);
        
        checkPipes();
    }
    
    public double getGravity() {
        return GRAVITY;
    }
    
    public void act() {
        super.act();
        
        topPipe.setLocation(topPipe.getX() - 3, topPipe.getY());
        bottomPipe.setLocation(bottomPipe.getX() - 3, bottomPipe.getY());
        
        checkPipes();
        checkScore();
    }
    
    private void checkScore() {
        if(flappy.isAlive() && !scored && topPipe.getX() < 300) {
            score++;
            scored = true;
        }
    }
    
    private void checkPipes() {
        if(topPipe == null || topPipe.getX() <= 0) {
            removeObject(topPipe);
            removeObject(bottomPipe);
            
            int centerY = (int) (Math.random()*200) + 200;
            int openingHeight = (int) (Math.random()*200) + 150;
            
            int topPHeight = centerY - (openingHeight/2);
            topPipe = new Pipe(topPHeight);
            addObject(topPipe, 600, topPHeight/2);
            
            int bottomPHeight = getHeight() - (centerY + (openingHeight/2));
            bottomPipe = new Pipe(bottomPHeight);
            addObject(bottomPipe, 600, getHeight() - (bottomPHeight/2));
            
            scored = false;
        }
    }
    
    public int getScore() {
        return score;
    }
}
