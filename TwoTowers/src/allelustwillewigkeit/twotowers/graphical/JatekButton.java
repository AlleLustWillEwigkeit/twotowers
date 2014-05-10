package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class JatekButton extends JButton {
	private enum MouseState{
		NORMAL,HOVER 
	}
	
	private enum ButtonState{
		ACTIVE, INACTIVE, SELECTED 
	}

	
	String name;
	MouseState mouseState;
	ButtonState buttonState;
	
	private class ButtonMouseListener implements MouseListener {  //EZT OTTHON NE PRÓBÁLJÁTOK KI
		@Override
		public void mouseClicked(MouseEvent arg0) {
			//TODO mezőre való kattintás
			JatekButton gomb = (JatekButton)arg0.getSource();
			gomb.mouseState = MouseState.NORMAL;
			gomb.buttonState = ButtonState.SELECTED;
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
			gomb.mouseState = MouseState.HOVER;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
			gomb.mouseState = MouseState.NORMAL;
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
		}
	}
	
	final static Color SELECTED = new Color(255, 0, 0, 100);
	final static Color HOVER = new Color(255, 255, 255, 100);
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
		
		this.mouseState = MouseState.NORMAL;
		this.buttonState = ButtonState.ACTIVE;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension pSize = this.getPreferredSize();
		Dimension size = this.getSize();
		
		switch(this.buttonState){
			case ACTIVE:
				switch(this.mouseState){
					case NORMAL:
						g.setColor(TRANSPARENT);
						break;
					case HOVER:
						g.setColor(HOVER);
						break;
				}
				break;
			case INACTIVE:
				g.setColor(TRANSPARENT);
				break;
			case SELECTED:
				g.setColor(SELECTED);
				break;
		}
		
		g.fillRect((size.width-pSize.width)/2, (size.height-pSize.height)/2, pSize.width, pSize.height);
		
	}
	
	
	
}
