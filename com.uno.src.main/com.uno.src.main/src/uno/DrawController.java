/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cynin
 */
public class DrawController {
    

    public int pt=0;
    private LinkedList<Draw> dc = new LinkedList<Draw>();
    
    Draw TempCard;
    
    Uno Uno;
    
    public DrawController(Uno Uno){
        this.Uno = Uno;
        
        
     
        
    }



    
    
    
    public void tick(){
       
        for(int i = 0; i < dc.size();i++){
            
            TempCard = dc.get(i);
            
            TempCard.tick();
            
        }
    }
    
    public void render(Graphics g){
        
        
     
        for(int i = 0; i < dc.size();i++){
            TempCard = dc.get(i);
            
            TempCard.render(g);
            
        }
        
    }
    
    public void addCard(Draw block){
        
        
        dc.add(block);
    }
    
    public void removeCard(Draw block){
        dc.remove(block);
    
}
    
}

