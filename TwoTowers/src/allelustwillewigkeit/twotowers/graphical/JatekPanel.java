package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JatekPanel extends JPanel {
	Controller controller;
	Image hatter;
	
	private class MezoMouseListener implements MouseListener {  //EZT OTTHON NE PRÓBÁLJÁTOK KI
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			//TODO mezőre való kattintás
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			MezoPanel mezo = (MezoPanel)arg0.getSource();
			mezo.setSelected(true);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			MezoPanel mezo = (MezoPanel)arg0.getSource();
			mezo.setSelected(false);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
		
	}
	
	public JatekPanel(Controller controller) {
		this.controller = controller;
		this.setLayout(null);
		
		URL resource = MenuPanel.class.getResource("res/palya.jpg");
		ImageIcon ii = new ImageIcon(resource);
		hatter = ii.getImage();
		
		Random r = new Random();
		MezoMouseListener blockMouseListener = new MezoMouseListener();
		
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				MezoPanel mezo = new MezoPanel();
				mezo.setSize(52, 52);
				mezo.setLocation(27 + (x * 50), 50 + (y * 50));
				mezo.addMouseListener(blockMouseListener);
				this.add(mezo);
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hatter, 0, 0, Color.RED, null);
	}
}
