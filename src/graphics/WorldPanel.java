/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import entity.EvoObject;
import environment.World;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author General
 */
public class WorldPanel extends JPanel implements Runnable{
    
    int[] vSize;
    int[] vLoc;
    int movePower = 2;
    public final int WIDTH = 500;
    public final int HEIGHT = 500;
    private MoveController mc;
    ArrayList<EvoObject> eObjects;
    World w;
    
    public WorldPanel(World w){
        eObjects = new ArrayList<EvoObject>();
        this.w = w;
        vSize = new int[2];
        vSize[0] = WIDTH;
        vSize[1] = HEIGHT;
        vLoc = new int[2];
        vLoc[0] = 0;
        vLoc[1] = 0;
    } 
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        for(EvoObject eObj : eObjects){
            int[] sLoc = new int[2];
            sLoc[0] = eObj.getLoc()[0]-vLoc[0];
            sLoc[1] = eObj.getLoc()[1]-vLoc[1];
            Ellipse2D.Double circle = new Ellipse2D.Double(sLoc[0], sLoc[1], 50, 50);
            g2d.fill(circle);
          //  System.out.println(Arrays.toString(sLoc)+" : "+eObj);
        }
       
    }
    public void setMoveController(MoveController mc){
        this.mc = mc;
    }
    @Override
    public void run(){
        int fps = 30;
        
        while(true){
            try {
                sleep(1000/fps);
            } catch (InterruptedException ex) {
                Logger.getLogger(WorldPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            int[] vec = mc.getVector();
            vec[0] = vec[0]*this.movePower;
            vec[1] = vec[1]*this.movePower;
            moveViewport(vec);
        }
    }
    public void moveViewport(int[] vec){
        int[] loc = vLoc;
        loc[0] += vec[0];
        loc[1] += vec[1];
        setViewport(loc);
    }
    public void setViewport(int[] loc){
        
        vLoc = loc;
        int[] p1 = loc;
        int[] p2 = new int[2];
        p2[0] = p1[0]+vSize[0];
        p2[1] = p1[1]+vSize[1];
        
        eObjects = w.getObjects(p1, p2);
        
        
        repaint();
      
        
    }
    
    
}

