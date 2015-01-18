/**
@author Chaz Kerby
*/
package com.chazwarp.SimpleImageViewer.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import com.chazwarp.SimpleImageViewer.JFrame.MainWindow;
import com.chazwarp.SimpleImageViewer.JPanel.ButtonBar;

public class ButtonBarListener implements ActionListener{

	static public int arrayPos = 0;
	static private File image;
	static private File parentDir;
	static private File[] fileArray;
	
	@Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        
        PopulateArray();
        
        for(int i=0; i < fileArray.length; i++) {
        	if(image == fileArray[i]) {
        		arrayPos = i;
        	}
        }
        
        if (ButtonBar.PREVIOUS == cmd) {
        	if(arrayPos != 0) {
        		MainWindow.OpenNewImage(fileArray[arrayPos - 1]);
                arrayPos = arrayPos - 1;
        	}
        	else {
        		MainWindow.OpenNewImage(fileArray[fileArray.length - 1]);
        		arrayPos = fileArray.length - 1;
        	}
        } 
        else if (ButtonBar.NEXT == cmd) {
        	if(arrayPos != fileArray.length - 1) {
        		MainWindow.OpenNewImage(fileArray[arrayPos + 1]);
            	arrayPos = arrayPos + 1;
        	}
        	else {
        		MainWindow.OpenNewImage(fileArray[0]);
        		arrayPos = 0;
        	}
        }
    }
	
	private static void PopulateArray() {
		
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
					if(name.endsWith("jpg") || name.endsWith("jpeg") || name.endsWith("gif") || name.endsWith("png") || name.endsWith("bmp") || name.endsWith("wbmp")) {
						return true;
					}
					else {
						return false;
					}
			}
		};
		
		image = MainWindow.currentImage;
        parentDir = image.getParentFile();
        fileArray = parentDir.listFiles(filter);
	}
	
	public static File[] GetArray() {
		PopulateArray();
		return fileArray;
	}
}
