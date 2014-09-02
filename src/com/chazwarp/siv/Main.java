/**
@author Chaz Kerby
*/
package com.chazwarp.siv;

import java.io.File;

import javax.swing.JFrame;

import com.chazwarp.siv.Window.FileChooserWindow;
import com.chazwarp.siv.Window.MainWindow;

public class Main {
	
	static int windowX = 800;
	static int windowY = 600;
	static JFrame mainFrame = null;
	static File currentImage = null;
	
	public static void main(String[] args) {
		
		CreateNewWindow();
	}
	
	public static void CreateNewWindow() {
		mainFrame = MainWindow.CreateWindow(windowX, windowY);
		MainWindow.ChangeVisibility(mainFrame, true);
	}
	
	public static void openImage() {
		currentImage = FileChooserWindow.OpenNewImage();
		
		if(currentImage != null) {
			MainWindow.ChangeVisibility(mainFrame, false);
			MainWindow.OpenNewImage(mainFrame, currentImage.getAbsolutePath());
		}
	}
	
	public static void ButtonClicked(String id) {
		if(id == "OpenNewImage") openImage();
	}
}
