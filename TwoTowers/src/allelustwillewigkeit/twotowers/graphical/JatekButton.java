package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class JatekButton extends JButton {
	
	String name;
	
	
	private class ButtonMouseListener implements MouseListener {  //EZT OTTHON NE PRÓBÁLJÁTOK KI
		@Override
		public void mouseClicked(MouseEvent arg0) {
			//TODO mezőre való kattintás
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
			gomb.setSelected(true);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
			gomb.setSelected(false);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	
	final static Color SELECTED = new Color(255, 255, 255, 100);
	final static Color TRANSPARENT = new Color(0, 0, 0, 0);
	ImageIcon activeIcon;
	ImageIcon inActiveIcon;
	
	public JatekButton(String name) {
		this.name = name;
		this.setActionCommand(name);
		this.setPreferredSize(new Dimension(68, 69));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		
		this.setBackground(TRANSPARENT);
		this.addMouseListener(new ButtonMouseListener());
		
		this.activeIcon = new ImageIcon(MenuPanel.class.getResource("res/" + name + ".png"));
		this.inActiveIcon = new ImageIcon(MenuPanel.class.getResource("res/" + name + "_disabled.png"));
		
		this.setIcon(this.activeIcon);
		this.setDisabledIcon(this.inActiveIcon);
	}
	
	public void setSelected(boolean selected) {
		if (selected)
			this.setBackground(SELECTED);
		else
			this.setBackground(TRANSPARENT);
		
		this.getParent().repaint();
	}
	
	
	
}
