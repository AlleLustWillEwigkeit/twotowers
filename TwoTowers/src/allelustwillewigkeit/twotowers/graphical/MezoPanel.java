package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MezoPanel extends JPanel {
	
	final static Color TRANSPARENT = new Color(0, 0, 0, 0);
	final static Color SELECTED = new Color(255, 255, 255, 100);
	
	public MezoPanel() {
		this.setOpaque(false);
		this.setBackground(TRANSPARENT);
	}
	
	public void setSelected(boolean selected) {
		if (selected)
			this.setBackground(SELECTED);
		else
			this.setBackground(TRANSPARENT);
		
		this.getParent().repaint();
	}
	
	protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
