/**
@author Chaz Kerby
*/
package com.chazwarp.siv.Window;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.chazwarp.siv.Window.Button.Listeners.OpenNewImageListener;

public class MainWindow {
	
	static JMenuBar menuBar;
	static JMenuBar tabBar;
	static JMenu optionsMenu;
	static JMenuItem openNewImage;
	static Component oldImage = null;
	
	public static JFrame CreateWindow(int windowX, int windowY) {
		
		JFrame mainFrame = new JFrame("Simple Image Viewer");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);
		openNewImage = new JMenuItem("Open A New Image");
		openNewImage.addActionListener(new OpenNewImageListener());
		optionsMenu.add(openNewImage);
		
		//workingFrame.add(new ButtonBar());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setBounds(0, 0, screenSize.width/2, screenSize.height/2);
		mainFrame.setLocationRelativeTo(null);//Centers The Window
		
		return mainFrame;
	}
	
	public static void OpenNewImage(JFrame mainFrame, String filePath) {
		
		if(oldImage != null)mainFrame.remove(oldImage);
		oldImage = mainFrame.add(new JLabel(new ImageIcon(filePath)));
		mainFrame.setTitle("Simple Image Viewer - " + filePath);
		
		mainFrame.setVisible(true);
	}
	
	public static void ChangeVisibility(JFrame mainFrame, Boolean b) {
		mainFrame.setVisible(b);
	}
}
