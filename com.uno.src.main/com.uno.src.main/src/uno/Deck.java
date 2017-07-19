/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author cynin
 */
public class Deck {
    
    
    private double x;
    private double y;
    
    private BufferedImage deck; 
    
    public Deck(double x, double y, Uno uno){
        this.x = x;
        this.y = y;
        
        SpriteSheet ss = new SpriteSheet(uno.getSpriteSheet());
        
        deck = ss.grabImage(1, 5, 90, 126);
        
    }
    
    
    public void tick(){
        
        
    }
    
    public void render(Graphics g){
        
        
        g.drawImage(deck, (int)x, (int)y, null);
        
        
        
    }
            
}
