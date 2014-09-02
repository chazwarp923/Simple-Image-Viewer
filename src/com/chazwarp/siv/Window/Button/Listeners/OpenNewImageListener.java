/**
@author Chaz Kerby
*/
package com.chazwarp.siv.Window.Button.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chazwarp.siv.Main;

public class OpenNewImageListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		Main.ButtonClicked("OpenNewImage");
	}
}
