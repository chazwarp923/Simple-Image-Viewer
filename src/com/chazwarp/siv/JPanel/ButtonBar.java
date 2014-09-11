/**
@author Chaz Kerby
*/
package com.chazwarp.siv.JPanel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ButtonBar extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static final private String PREVIOUS = "Previous";
	static final private String NEXT = "Next";

	public ButtonBar() {
		super(new BorderLayout());
		
		JToolBar toolBar = new JToolBar("ToolBar", JToolBar.HORIZONTAL);
		addButtons(toolBar);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		
		add(toolBar, BorderLayout.SOUTH);
	}
	
	protected void addButtons(JToolBar toolBar) {
		JButton button = null;
		
		button = makeButton("leftArrow32", PREVIOUS, "Back!", "Back");
		toolBar.add(button);
		button = makeButton("rightArrow32", NEXT, "Next!", "Next");
		toolBar.add(button);
	}
	
	protected JButton makeButton(String imageName, String actionCommand, String toolTipText, String altText) {
		
		URL url = getClass().getResource("/com/chazwarp/siv/resources/"+ imageName + ".png");
		Image img = tk.createImage(url);
		tk.prepareImage(img, -1, -1, null);
		
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
		
		if(img != null) {
			button.setIcon(new ImageIcon(img, altText));
		}
		else {
			button.setText(altText);
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
