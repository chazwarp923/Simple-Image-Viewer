/**
@author Chaz Kerby
*/
package com.chazwarp.siv.Window.Button.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBarListener implements ActionListener{

	static final private String PREVIOUS = "Previous";
	static final private String NEXT = "Next";
	
	@Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (PREVIOUS.equals(cmd)) {
            
        } 
        else if (NEXT.equals(cmd)) {
            
        }
    }
}
