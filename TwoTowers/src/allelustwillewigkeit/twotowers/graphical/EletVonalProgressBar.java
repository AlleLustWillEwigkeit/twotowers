package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class EletVonalProgressBar extends JProgressBar {
	Image border;
	
	public EletVonalProgressBar(int max) {
		super(0, max);
		this.setValue(0);
		
		this.setPreferredSize(new Dimension(208, 31));
		this.setBorderPainted(false);
		
		URL resource = MenuPanel.class.getResource("res/eletvonal.png");
		ImageIcon ii = new ImageIcon(resource);
		border = ii.getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(border, 0, 0, null, null);
		
		double progress_percent = this.getValue() / (double)this.getMaximum();
		if (!Double.isInfinite(progress_percent) && progress_percent > 0) {
			g.setColor(new Color(255, 0, 0, 100));
			g.fillRect(7, 6, (int)(195 * progress_percent), 20);
		}
	}
}

