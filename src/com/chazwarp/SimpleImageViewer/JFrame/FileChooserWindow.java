/**
@author Chaz Kerby
*/
package com.chazwarp.SimpleImageViewer.JFrame;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserWindow {

	public static final FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "gif", "png", "bmp", "wbmp");
	
	public static File OpenNewImage() {
		JFileChooser chooser = new JFileChooser();		
		String[] extArray = {"JPG", "JPEG", "GIF", "PNG", "BMP", "WBMP"};
		for(int i=0; i < extArray.length; i++) {
			FileNameExtensionFilter forFilter = new FileNameExtensionFilter(extArray[i], extArray[i].toLowerCase());
			chooser.addChoosableFileFilter(forFilter);
		}
		chooser.setFileFilter(filter);
		chooser.setDragEnabled(true);
		chooser.showOpenDialog(null);
		
		if(chooser.getSelectedFile() != null) {
			return chooser.getSelectedFile();
		}
		else {
			return null;
		}
	}
}
