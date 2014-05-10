package allelustwillewigkeit.twotowers.graphical;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JatekButton extends JButton {
	String name;
	
	public JatekButton(String name) {
		this.name = name;
		this.setActionCommand(name);
		this.setPreferredSize(new Dimension(68, 69));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		
		URL resource = MenuPanel.class.getResource("res/" + name + ".png");
		ImageIcon ii = new ImageIcon(resource);
		this.setIcon(ii);
		
		resource = MenuPanel.class.getResource("res/" + name + "_disabled.png");
		ii = new ImageIcon(resource);
		this.setIcon(ii);
	}
	
	
	
}
