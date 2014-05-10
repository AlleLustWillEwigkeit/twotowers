package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class AlphaPanel extends JPanel {
	
	final static Color TRANSPARENT = new Color(0, 0, 0, 0);
	
	public AlphaPanel() {
		this.setOpaque(false);
		this.setBackground(TRANSPARENT);
	}
	
	protected void paintComponent(Graphics g)
    {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
