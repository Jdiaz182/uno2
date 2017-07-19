package uno;

 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author joelcook1 & JDiaz182
 */


public class Uno extends Canvas implements Runnable{
      
  
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 630;
    public static final int HEIGHT = WIDTH /12 * 9;
    public static final int SCALE = 2;
    public static final String TITLE = "Uno";
    private boolean running = false;
    private Thread thread;
    
    
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage spritesheet = null;
    private BufferedImage BackGround = null;
    
    public int PlayDeckX = 1;
    public int PlayDeckY = 5;
   
    
    
   
    
    
    private Deck d;
    private PlayDeck p;
    private DrawController dc;
    
    public void init(){
        
        BufferImgLoader loader = new BufferImgLoader();
        
        try{
            
            spritesheet = loader.loadImage("res/SpriteSheet.png");
            
             BackGround = loader.loadImage("res/background1.png");
           
        }catch(IOException e){
        
            e.printStackTrace();
    }
        
        
         d = new Deck(500, 350,this);
         p = new PlayDeck(700, 350,this);
       
         dc = new DrawController(this);
         
              
        
        
    }
    
   
    
    
    private synchronized void start(){
        if(running){
            return;
        }
         running = true;
         thread = new Thread(this);
         thread.start();
    }
    
    private synchronized void stop(){
        if(!running)
            return;
        
        running = false;
        try{
        thread.join();
        System.exit(1);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
    
    public void run(){
        
        init();
        
        long lasttime = System.nanoTime();
        final double amountofticks = 60.0;
        double ns = 1000000000 / amountofticks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        int i = 1;
         

        while(running){
            long now = System.nanoTime();
            delta += (now - lasttime) / ns;
            lasttime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if((System.currentTimeMillis() - timer) > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
            updates = 0;
            frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        d.tick();
        p.tick();
        dc.tick();
        
    }
    
    private void render(){
        
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
         
        Graphics g = bs.getDrawGraphics();
        ////////////
         
        g.drawImage(image, 0, 0, getWidth(),getHeight(), this);
        
        g.drawImage(BackGround,0,0,null);
       
       
        
        d.render(g);
        p.render(g);
        dc.render(g);
        
        
        
        
        
        /////////////
        g.dispose();
        bs.show();
    }
    
    
    public static void main(String args[]){
        
        Uno game = new Uno();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        JFrame frame = new JFrame(Uno.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        game.start();
        
        
        
    }
    
    
    public BufferedImage getSpriteSheet(){
        return spritesheet;
        
    }
    
    
    
}