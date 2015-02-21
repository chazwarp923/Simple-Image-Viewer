/**
@author Chaz Kerby
*/
package com.chazwarp.SimpleImageViewer.JPanel;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import com.chazwarp.SimpleImageViewer.Listener.ButtonBarListener;

public class ButtonBar {

	static Toolkit tk = Toolkit.getDefaultToolkit();
	static final public String PREVIOUS = "Previous";
	static final public String NEXT = "Next";

	public static JToolBar InstantiateButtonBar(JPanel panel) {
		JToolBar toolBar = new JToolBar("ToolBar", JToolBar.HORIZONTAL);
		addButtons(toolBar);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		
		return toolBar;
	}
	
	protected static void addButtons(JToolBar toolBar) {
		JButton button = null;
		
		button = makeButton("leftArrow32", PREVIOUS, "Previous!", "Previous", KeyStroke.getKeyStroke("LEFT"));
		toolBar.add(button);
		button = makeButton("rightArrow32", NEXT, "Next!", "Next", KeyStroke.getKeyStroke("RIGHT"));
		toolBar.add(button);
	}
	
	protected static JButton makeButton(String imageName, String actionCommand, String toolTipText, String altText, KeyStroke keyStroke) {
		
		URL url = ButtonBar.class.getResource("/resources/"+ imageName + ".png");
		Image img = tk.createImage(url);
		tk.prepareImage(img, -1, -1, null);
		
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(new ButtonBarListener());
		button.getInputMap().put(keyStroke, actionCommand);
		
		if(img != null) {
			button.setIcon(new ImageIcon(img, altText));
		}
		else {
			button.setText(altText);
		}
		return button;
	}
}
