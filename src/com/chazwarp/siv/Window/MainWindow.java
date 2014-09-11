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
import javax.swing.JPanel;

import com.chazwarp.siv.JPanel.ButtonBar;
import com.chazwarp.siv.Window.Button.Listeners.OpenNewImageListener;

public class MainWindow {
	
	static JFrame mainFrame = new JFrame("Simple Image Viewer");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static JPanel picPanel;
	static JMenuBar menuBar;
	static JMenu optionsMenu;
	static JMenuItem openNewImage;
	static Component oldImage = null;
	
	public static JFrame CreateWindow() {
		
		try {
			mainFrame.setIconImage(createImageIcon("/com/chazwarp/siv/resources/monitor32.png").getImage());
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		picPanel = new JPanel();
		menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);
		openNewImage = new JMenuItem("Open A New Image");
		openNewImage.addActionListener(new OpenNewImageListener());
		optionsMenu.add(openNewImage);
		
		mainFrame.add(new ButtonBar());
		mainFrame.add(picPanel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setBounds(0, 0, screenSize.width/2, screenSize.height/2);
		mainFrame.setLocationRelativeTo(null);//Centers The Window
		
		return mainFrame;
	}
	
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MainWindow.class.getResource(path);
		if(imgURL != null) {
			return new ImageIcon(imgURL);
		}
		else {
			System.err.println("Couldn't Find File: " + path);
			return null;
		}
	}
	
	public static void OpenNewImage(String filePath) {
		
		if(oldImage != null)picPanel.remove(oldImage);
		oldImage = picPanel.add(new JLabel(new ImageIcon(filePath)));
		
		mainFrame.setVisible(true);
	}
	
	public static void SetCurrentImage(String filePath) {
		if(oldImage != null)picPanel.remove(oldImage);
		oldImage = picPanel.add(new JLabel(new ImageIcon(filePath)));
		mainFrame.setVisible(false);
		mainFrame.setVisible(true);
	}
}
