/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv08;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author jethro
 */
public class Cv08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        JsonObject jdata;
        jdata = null;
        try {
            URL addr = new URL("http://iris.bmhd.cz/api/data.json");
            BufferedReader instream = new BufferedReader(new InputStreamReader(addr.openStream()));
            jdata = Json.parse(instream).asObject();
            System.out.println(jdata.get("UpdateInterval").asInt());
        } catch (Exception e){
            
            System.err.println("Chyba!"+e.getLocalizedMessage());
        }
            Data data = new Data(jdata);
            System.out.println(data);

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



