package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	ActionListener controller;
	Image hatter;
	
	public MenuPanel(ActionListener controller) {
		this.controller = controller;
		this.setLayout(null);
		
		URL resource = MenuPanel.class.getResource("res/menu.jpg");
		ImageIcon ii = new ImageIcon(resource);
		hatter = ii.getImage();
		
		JButton ujJatek = new JButton("Új játék");
		ujJatek.setBackground(new Color(56, 71, 33));
		ujJatek.setForeground(Color.WHITE);
		ujJatek.setSize(250, 70);
		ujJatek.setLocation(339, 230);
		ujJatek.setActionCommand("ujJatek");
		ujJatek.addActionListener(controller);
		this.add(ujJatek);
		
		JButton kilepes = new JButton("Kilépés");
		kilepes.setBackground(new Color(56, 71, 33));
		kilepes.setForeground(Color.WHITE);
		kilepes.setSize(250, 70);
		kilepes.setLocation(339, 370);
		kilepes.setActionCommand("kilep");
		kilepes.addActionListener(controller);
		this.add(kilepes);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hatter, 0, 0, Color.RED, null);
	}
}
