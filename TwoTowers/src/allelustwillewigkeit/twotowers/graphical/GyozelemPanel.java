package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GyozelemPanel extends JPanel {
	ActionListener controller;
	Image hatter;
	
	public GyozelemPanel(ActionListener controller) {
		this.controller = controller;
		this.setLayout(null);
		
		URL resource = MenuPanel.class.getResource("res/gyozelem.jpg");
		ImageIcon ii = new ImageIcon(resource);
		hatter = ii.getImage();
		
		JButton menuBtn = new JButton("Menübe lépés");
		menuBtn.setBackground(new Color(207, 155, 79));
		menuBtn.setForeground(Color.BLACK);
		menuBtn.setSize(250, 70);
		menuBtn.setLocation(339, 350);
		menuBtn.setActionCommand("menuRajzol");
		menuBtn.addActionListener(controller);
		this.add(menuBtn);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hatter, 0, 0, null);
		
	}
}
