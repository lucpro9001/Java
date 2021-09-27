/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duong_tang_luc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Admin
 */
public class KeThuaFrame extends Frame {
    
    TextField a, b, kq;
    Label lbA, lbB, lbKQ;
    Button cong;
    
    public KeThuaFrame() {
        // Frame setting
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        setBounds(0, 0, 400, 200);
        setVisible(true);
       
        
        // init components
        lbA = new Label("A: ");
        lbB = new Label("B: ");
        lbKQ = new Label("KQ: ");
        cong = new Button("+");
        a = new TextField();
        b = new TextField();
        kq = new TextField();
        a.setSize(100, 200);
        
        kq.setEditable(false);
        
        // add components
        add(lbA);
        add(a);
        add(lbB);
        add(b);
        add(lbKQ);
        add(kq);  
        add(cong);
        
        
        cong.addActionListener(new addListener());
        addWindowListener(new winListener());
    }
    
    class addListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String aText = a.getText();
            String bText = b.getText();
            
            if(aText.isEmpty() || bText.isEmpty()) return;
            
            double s = Double.parseDouble(aText) + Double.parseDouble(bText);
            
            kq.setText(String.valueOf(s));
        }
        
    }
    
    class winListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowClosing(WindowEvent arg0) {
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowIconified(WindowEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowDeiconified(WindowEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowActivated(WindowEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowDeactivated(WindowEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
