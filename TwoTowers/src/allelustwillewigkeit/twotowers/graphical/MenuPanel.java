package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	ActionListener controller;
	Image hatter;
	
	public MenuPanel(ActionListener controller) {
		this.controller = controller;
		this.setBackground(Color.RED);
		
		URL resource = MenuPanel.class.getResource("res/menu.jpg");
		ImageIcon ii = new ImageIcon(resource);
		hatter = ii.getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hatter, 0, 0, Color.RED, null);
	}
}
