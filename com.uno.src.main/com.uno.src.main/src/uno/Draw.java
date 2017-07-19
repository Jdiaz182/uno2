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


public class Draw {
    
    private double x;
    private double y;
    
    BufferedImage image;
     
 
    
    
   
    
    
    
    public Draw(double x, double y, Uno uno){
        
        this.x = x;
        this.y = y;
        
        SpriteSheet ss = new SpriteSheet(uno.getSpriteSheet());
        
       image = ss.grabImage(1,6,90,126);
        
        
    }
    
    
    
    public void tick(){
            int turn; 
       turn = Turns.turn % 4;
        if(turn==1){
        y +=10;
        }
        if(turn==2){
        y +=10;
        }
        if(turn==3){
        x +=10;
        } 
        if(turn==4){
        x +=10;
        }
        
     
        
   
       
    }
    
   
    
   public void render(Graphics g){
       
       g.drawImage(image, (int)x, (int)y, null);
       
   } 
    
}
    

