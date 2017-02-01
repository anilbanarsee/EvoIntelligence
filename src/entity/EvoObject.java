/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author General
 */
public class EvoObject {
    protected int[] location;
    
    public EvoObject(int[] loc){
        location = new int[2];
        location[0] = loc[0];
        location[1] = loc[1];
    }
    public int[] getLoc(){
        return location;
    }
    public boolean tick(){
        return true;
    }
}
