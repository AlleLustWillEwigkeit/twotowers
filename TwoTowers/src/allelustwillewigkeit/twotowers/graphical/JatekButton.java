package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	
	public enum ButtonState{
		ACTIVE, INACTIVE, SELECTED 
	}

	
	String name;
	MouseState mouseState;
	ButtonState buttonState;
	int koltseg;
	
	private class ButtonMouseListener implements MouseListener {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
			gomb.setMouseState(MouseState.HOVER);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			JatekButton gomb = (JatekButton)arg0.getSource();
			gomb.setMouseState(MouseState.NORMAL);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

		@Override
		public void mouseClicked(MouseEvent e){
		}
	}
	
	final static Color SELECTED = new Color(255, 0, 0, 100);
	final static Color HOVER = new Color(255, 255, 255, 100);
	final static Color TRANSPARENT = new Color(0, 0, 0, 0);
	
	ImageIcon activeIcon;
	ImageIcon inActiveIcon;
	
	public JatekButton(String name, int koltseg) {
		this.name = name;
		this.koltseg = koltseg;
		this.setActionCommand(name);
		this.setPreferredSize(new Dimension(68, 68));
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
	
	public void setButtonState(ButtonState bs, boolean force){
		if(this.buttonState != ButtonState.INACTIVE || force ){
			this.buttonState = bs;
			switch(this.buttonState){
				case ACTIVE:
					this.setEnabled(true);
					break;
				case INACTIVE:
					this.setEnabled(false);
					break;
				case SELECTED:
					break;
			}
			this.repaint();
		}
	}
	
	public void setButtonState(ButtonState bs){
		setButtonState(bs,false);
	}
	
	public void setMouseState(MouseState ms){
		this.mouseState = ms;
		switch(this.mouseState){
			case NORMAL:
				break;
			case HOVER:
				break;
		}
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension pSize = this.getPreferredSize();
		Dimension size = this.getSize();
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		
		switch(this.buttonState){
			case ACTIVE:
				switch(this.mouseState){
					case NORMAL:
						g2.setColor(TRANSPARENT);
						break;
					case HOVER:
						g2.setColor(HOVER);
						break;
				}
				break;
			case INACTIVE:
				g2.setColor(TRANSPARENT);
				break;
			case SELECTED:
				g2.setColor(SELECTED);
				break;
		}
		
		g2.fillRoundRect((size.width-pSize.width)/2, (size.height-pSize.height)/2, pSize.width, pSize.height, (int)(pSize.width * 0.35), (int)(pSize.height * 0.35));
	}
	
	
	
}
