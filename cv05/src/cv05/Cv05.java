/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv05;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author jethro
 */
public class Cv05 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
    
    private static void createAndShowGUI() {
        JFrame window = new JFrame("Testovaci okno");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        //window.setSize(2000,2000);
        DrawPanel dpanel = new DrawPanel();
        dpanel.addMouseListener(dpanel);
        dpanel.addMouseMotionListener(dpanel);
        dpanel.addKeyListener(dpanel);
        dpanel.setFocusable(true);
        window.add(dpanel);
        ControlPanel cpanel = new ControlPanel(dpanel);
        window.add(cpanel);
        window.pack();
        window.setVisible(true);
    }    
}

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
    
    public DrawPanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.red);
        drawing = false;
        lines = new LinkedList<>();
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500, 500);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.yellow);
        Random rand = new Random();
        for (int i=0;i<count;i++){  
            g2d.fillArc(rand.nextInt(500), rand.nextInt(500), 10, 10, 0, 360);
        }
        for (int [] line : lines){
            g2d.drawLine(line[0], line[1], line[2], line[3]);
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
        req
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

class ControlPanel extends JPanel {
        JLabel inText;
        JLabel outText;
        JButton but;
        JTextField inputField;
        DrawPanel dpanel;
        
        public ControlPanel(DrawPanel dpanel){
            this.dpanel = dpanel;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            inText = new JLabel("Zadej počet:");
            this.add(inText);
            
            inputField = new JTextField("10");
            add(inputField);
                   
            but = new JButton("Konej");
            but.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                   dpanel.count = Integer.parseInt(inputField.getText());
                   outText.setText(String.format("Vykresluji %d tecek",dpanel.count));
                   dpanel.repaint();
                }     
            });
            add(but);
            
            outText = new JLabel(String.format("Vykresleno %d tecek",dpanel.count));
            add(outText);
     
        };
    
}
