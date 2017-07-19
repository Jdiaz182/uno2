
package uno;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author cynin
 */
public class PlayDeck {
    
    
    private double x ;
    private double y;
    
    private BufferedImage deck; 
    
    public PlayDeck(double x, double y, Uno uno){
        
        this.x = x;
        this.y = y;
        
        SpriteSheet ss = new SpriteSheet(uno.getSpriteSheet());
        
        deck = ss.grabImage(uno.PlayDeckX, uno.PlayDeckY, 90, 126);
        
    }
    
    
    public void tick(){
        
        
    }
    
    public void render(Graphics g){
        
        
        g.drawImage(deck, (int)x, (int)y, null);
        
        
        
    }
            
}
