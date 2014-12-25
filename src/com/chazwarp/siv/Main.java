/**
@author Chaz Kerby
*/
package com.chazwarp.siv;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.chazwarp.siv.Window.FileChooserWindow;
import com.chazwarp.siv.Window.MainWindow;

public class Main {
	
	static JFrame mainFrame = null;
	static File currentImage = null;
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		CreateNewWindow();
	}
	
	public static void CreateNewWindow() {
		mainFrame = MainWindow.CreateWindow();
		mainFrame.setVisible(true);
	}
	
	public static void openImage() {
		currentImage = FileChooserWindow.OpenNewImage();
		
		if(currentImage != null) {
			mainFrame.setVisible(false);
			MainWindow.OpenNewImage(currentImage.getAbsolutePath());
		}
	}
	
	public static void ButtonClicked(String id) {
		if(id == "OpenNewImage") openImage();
	}
}
