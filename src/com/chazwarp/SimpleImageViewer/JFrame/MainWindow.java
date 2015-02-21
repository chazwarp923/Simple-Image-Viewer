/**
@author Chaz Kerby
*/
package com.chazwarp.SimpleImageViewer.JFrame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.File;

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

import com.chazwarp.JWarpCore.File.IconHelper;
import com.chazwarp.SimpleImageViewer.JPanel.ButtonBar;
import com.chazwarp.SimpleImageViewer.Listener.ButtonBarListener;
import com.chazwarp.SimpleImageViewer.Listener.OpenNewImageListener;

public class MainWindow {
	
	static JFrame mainWindow = new JFrame("Simple Image Viewer");
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Dimension screenSize = tk.getScreenSize();
	static JPanel mainPanel = new JPanel();
	static JPanel imagePanel = new JPanel(new GridBagLayout());
	static JPanel toolBarPanel = new JPanel();
	static JScrollPane scrollBars = new JScrollPane(imagePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	static JMenuBar menuBar = new JMenuBar();
	static JMenu optionsMenu;
	static JMenuItem openNewImage;
	static Component oldImage = null;
	public static File currentImage;
	
	public static JFrame CreateWindow(File f) {
		
		IconHelper.setWindowIcon(mainWindow, "/resources/" + "monitor32.png");
		
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
		Dimension screenSize = tk.getScreenSize();
		Dimension minSize = new Dimension(screenSize.width/2, screenSize.height/2);
		mainWindow.setMinimumSize(minSize);
		mainWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		if(f != null) {
			OpenNewImage(f);
		}
		
		return mainWindow;
	}
	
	public static void OpenNewImage(File image) {		
		if(oldImage != null) imagePanel.remove(oldImage);
		currentImage = image;
		
		oldImage = imagePanel.add(new JLabel(new ImageIcon(image.getAbsolutePath())));
		imagePanel.repaint();
		
		File[] tempArray = ButtonBarListener.GetArray();
		for(int i = 0; i < tempArray.length; i++) {
			if(tempArray[i] == image) {
				ButtonBarListener.arrayPos = i;
			}
		}		
		mainWindow.setVisible(true);
	}
}
