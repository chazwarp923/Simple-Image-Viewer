/**
@author Chaz Kerby
*/
package com.chazwarp.siv.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.chazwarp.siv.Window.MainWindow;

public class ButtonBar extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	static final private String PREVIOUS = "Previous";
	static final private String NEXT = "Next";

	public ButtonBar() {
		super(new BorderLayout());
		
		JToolBar toolBar = new JToolBar("ToolBar");
		addButtons(toolBar);
		
		add(toolBar, BorderLayout.PAGE_END);
	}
	
	protected void addButtons(JToolBar toolBar) {
		JButton button = null;
		
		button = makeButton("Back", PREVIOUS, "Back!", "Back");
		toolBar.add(button);
	}
	
	protected JButton makeButton(String imageName, String actionCommand, String toolTipText, String altText) {
		
		//String imgLocation = "Resources/" + imageName + ".png";
		String imgLocation = "C:\\Users\\Chazk_000\\Desktop\\Random Shit\\Textures\\death_chest_front.png";
		
		URL imageURL = MainWindow.class.getResource(imgLocation);
		
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
		
		if(imageURL != null) {
			button.setIcon(new ImageIcon(imageURL, altText));
		}
		else {
			button.setText(altText);
			System.err.println("Resource Not Found: " + imgLocation);
		}
		return button;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (PREVIOUS.equals(cmd)) {
            
        } 
        else if (NEXT.equals(cmd)) {
            
        }
    }
}
