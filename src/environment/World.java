/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package environment;

import entity.Entity;
import entity.EvoObject;
import java.util.ArrayList;
import util.MathUtils;

/**
 *
 * @author General
 */
public class World {
    
    private ArrayList<EvoObject> eObjects;
    private int[] worldSize;
    
    public World(){
        eObjects = new ArrayList<>();
        worldSize = new int[2];
        worldSize[0] = 2000;
        worldSize[1] = 2000;
    }
    
    public void addEntity(Entity e){
        eObjects.add(e);
    }
    public ArrayList<EvoObject> getObjects(){
        return eObjects;
    }
    public ArrayList<EvoObject> getObjects(int[] p1, int[] p2){
        ArrayList<EvoObject> eObjs = new ArrayList<>();
        for(EvoObject eObj : eObjects){
            int[] loc = eObj.getLoc();
            if(MathUtils.between(loc[0],p1[0],p2[0])&&MathUtils.between(loc[1],p1[1],p2[1])){
                eObjs.add(eObj);
            }
        }
        return eObjs;
        
    }
    public void tick(){
        for(EvoObject e: eObjects){
            if(!e.tick()){
                eObjects.remove(e);
                return;
            }
        }
    }
    
    public String toString(){
        String s = "This world contains :\n";
        for(int i = 0; i<eObjects.size(); i++){
            if(eObjects.get(i) instanceof Entity){
                Entity ent = (Entity) eObjects.get(i);
                s = s+"Entity_"+i+": Hunger = "+ent.getHunger()+";\n";
            }
        }
        return s;
    }
}
