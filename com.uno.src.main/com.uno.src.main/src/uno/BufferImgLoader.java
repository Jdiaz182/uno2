/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cynin
 */

package uno;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class BufferImgLoader {
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String path) throws IOException{
        
        image = ImageIO.read(getClass().getResource(path));
        return image;
        
        
    }
    
}
