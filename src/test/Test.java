/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Entity;
import environment.World;
import graphics.WorldPanel;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author General
 */
public class Test {
    
    public static void main(String[] args){
         World w = new World();
         WorldPanel wp = new WorldPanel(w);
         int[] loc = {500,500};
         w.addEntity(new Entity(loc,2));
         w.addEntity(new Entity(loc,10));
         w.addEntity(new Entity(loc,5));
         
         Scanner sc = new Scanner(System.in);
         
         JFrame frame = new JFrame();
         frame.setSize(500,500);
         frame.setVisible(true);
         frame.add(wp);
         
         System.out.println(w);
         while(true){
             String s = sc.nextLine();
             String[] split = s.split(",");
             int[] nLoc = new int[2];
             nLoc[0] = Integer.parseInt(split[0]);
             nLoc[1] = Integer.parseInt(split[1]);
             wp.setViewport(nLoc);
             
         }
    }
    
}
