/**
@author Chaz Kerby
*/
package com.chazwarp.siv.Window;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.chazwarp.siv.JPanel.ButtonBar;
import com.chazwarp.siv.Window.Button.Listeners.OpenNewImageListener;

public class MainWindow {
	
	static JFrame mainWindow = new JFrame("Simple Image Viewer");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Dimension screenSize = tk.getScreenSize();
	static JPanel mainPanel = new JPanel();
	static JPanel imagePanel = new JPanel();
	static JPanel toolBarPanel = new JPanel();
	static JScrollPane scrollBars = new JScrollPane(imagePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	static JMenuBar menuBar = new JMenuBar();
	static JMenu optionsMenu;
	static JMenuItem openNewImage;
	static Component oldImage = null;
	
	public static JFrame CreateWindow() {
		
		try {
			mainWindow.setIconImage(createImageIcon("/com/chazwarp/siv/resources/monitor32.png").getImage());
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		mainWindow.setJMenuBar(menuBar);
		optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);
		openNewImage = new JMenuItem("Open Image");
		openNewImage.addActionListener(new OpenNewImageListener());
		optionsMenu.add(openNewImage);
		
		scrollBars.getVerticalScrollBar().setUnitIncrement(10);
		mainPanel.add(scrollBars);
		Component tempComponent = ButtonBar.InstantiateButtonBar(mainPanel);
		toolBarPanel.add(tempComponent);
		Dimension tempDim = tempComponent.getPreferredSize();
		toolBarPanel.setMaximumSize(new Dimension(screenSize.width, tempDim.height));
		mainPanel.add(toolBarPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		mainWindow.add(mainPanel);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setBounds(0, 0, screenSize.width/2, screenSize.height/2);
		mainWindow.setLocationRelativeTo(null);//Centers The Window
		
		return mainWindow;
	}
	
	private static ImageIcon createImageIcon(String path) {
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
		if(oldImage != null) imagePanel.remove(oldImage);
		
		oldImage = imagePanel.add(new JLabel(new ImageIcon(filePath)));
		
		mainWindow.setVisible(true);
	}
}
