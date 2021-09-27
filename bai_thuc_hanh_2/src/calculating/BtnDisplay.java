/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating;

import java.awt.event.ActionListener;

/**
 *
 * @author Admin
 */
public abstract class BtnDisplay implements ActionListener {

    int index;
    public BtnDisplay(int i) {
        this.index = i;
    }
    
}
