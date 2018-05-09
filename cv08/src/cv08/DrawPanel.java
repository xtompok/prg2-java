/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author jethro
 */

class DrawPanel extends JPanel 
        implements MouseListener,MouseMotionListener,KeyListener {
    public int count = 10;
    boolean drawing;
    boolean keydrawing;
    int startx;
    int starty;
    int ksx;
    int ksy;
    List<int[]> lines;
    List<Vehicle> vehicles;

    
    
    public DrawPanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.red);
        drawing = false;
        lines = new LinkedList<>();
        vehicles = new LinkedList<>();
        //vehicles = Data.getActualData().vehicles;
        SwingWorker worker = new SwingWorker<Data,Data>(){
        protected Data doInBackground(){
            Data data;
            data = Data.getActualData();
            return data;  
        }
        
        public void done(){
         
            try {
                Data data;
                data = get();
                vehicles = data.vehicles;
            } catch (InterruptedException ex) {
                Logger.getLogger(Cv08.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Cv08.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
        worker.run();
        
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500, 500);
    }
    
    private int getX(double lon){
        return (int)((lon-16.55)*(this.getWidth()/0.06));
    }
    
    private int getY(double lat){
        return (int)(this.getHeight()-(lat-49.16)*(this.getHeight()/0.11));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.yellow);
        for (Vehicle v: vehicles){
            g2d.fillArc(getX(v.lon), getY(v.lat), 10, 10, 0, 360);
        }
        
        g2d.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawing = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered");
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (drawing == false){
            drawing=true;
            startx = e.getX();
            starty = e.getY();
            return;
        }
        //drawing = false;
        int [] line = new int[4];
        line[0] = startx;
        line[1] = starty;
        line[2] = e.getX();
        line[3] = e.getY();
        lines.add(line);
        startx = e.getX();
        starty = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
          System.out.println("Key");
	    switch (e.getKeyCode()){
		    case KeyEvent.VK_SPACE:
		    	if (! keydrawing){
				keydrawing = true;
				ksx = 100;
				ksy = 100;
				return;
			}
			keydrawing = false;
			break;
		    case KeyEvent.VK_UP: 
		    	int [] line = {ksx,ksy,ksx,ksy-10};
			lines.add(line);
			ksy -= 10;
			break;
		    case KeyEvent.VK_DOWN: 
		    	int [] line2 = {ksx,ksy,ksx,ksy+10};
			lines.add(line2);
			ksy += 10;
			break;
		    case KeyEvent.VK_LEFT: 
		    	int [] line3 = {ksx,ksy,ksx-10,ksy};
			lines.add(line3);
			ksx -= 10;
			break;
		    case KeyEvent.VK_RIGHT: 
		    	int [] line4 = {ksx,ksy,ksx+10,ksy};
			lines.add(line4);
			ksy += 10;
			break;
			
		    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    

}