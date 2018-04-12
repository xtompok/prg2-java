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
        window.add(dpanel);
        ControlPanel cpanel = new ControlPanel(dpanel);
        window.add(cpanel);
        window.pack();
        window.setVisible(true);
    }    
}

class DrawPanel extends JPanel {
    public int count = 10; 
    
    public DrawPanel(){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.red);
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
        g2d.dispose();
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
