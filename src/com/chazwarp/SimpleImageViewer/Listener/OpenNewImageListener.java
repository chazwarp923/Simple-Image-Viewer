/**
@author Chaz Kerby
*/
package com.chazwarp.SimpleImageViewer.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chazwarp.SimpleImageViewer.Main;

public class OpenNewImageListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		Main.ButtonClicked("OpenNewImage");
	}
}
