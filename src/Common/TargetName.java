/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.io.Serializable;

/**
 *
 * @author amank
 */
public class TargetName implements  Serializable{

    String targetname="";
    
    public TargetName(String name ) {
        
        targetname = name;
        
    }

    public String getTargetname() {
        return targetname;
    }
    
    
    
    
    
    
}
