/**
@author Chaz Kerby
*/
package com.chazwarp.SimpleImageViewer;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.chazwarp.SimpleImageViewer.JFrame.FileChooserWindow;
import com.chazwarp.SimpleImageViewer.JFrame.MainWindow;

public class Main {
	
	static JFrame mainFrame = null;
	static File currentImage = null;
	static File openedFile = null;
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		if(args.length > 0) {
			openedFile = new File(args[0]);
			CreateNewWindow(openedFile);		
		}
		
		else {
			CreateNewWindow(null);
		}
	}
	
	public static void CreateNewWindow(File f) {
		
		if(f != null) {
			mainFrame = MainWindow.CreateWindow(f);
			mainFrame.setVisible(true);
		}
		
		else {
			mainFrame = MainWindow.CreateWindow(null);
			mainFrame.setVisible(true);
		}
	}
	
	public static void openImage() {
		currentImage = FileChooserWindow.OpenNewImage();
		
		if(currentImage != null) {
			mainFrame.setVisible(false);
			MainWindow.OpenNewImage(currentImage);
		}
	}
	
	public static void ButtonClicked(String id) {
		if(id == "OpenNewImage") openImage();
	}
}
