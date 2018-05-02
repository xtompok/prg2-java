/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jethro
 */
public class ControlPanel extends JPanel {
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
