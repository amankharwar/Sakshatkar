/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.io.Serializable;

/**
 *
 * @author asus
 */
public class AudioPacket implements Serializable{
      
    public byte b[] = new byte[10000];
    
    
    public AudioPacket(byte d[]) {
        
        for(int i=0;i<d.length;i++)
        {
            b[i] = d[i ];
        }
        
       
    }
    
    
}
