package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MezoPanel extends AlphaPanel {
	
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
	
	final static Color SELECTED = new Color(255, 255, 255, 100);
	Dimension coord;
	
	public MezoPanel(Dimension coord) {
		this.setOpaque(false);
		this.setBackground(TRANSPARENT);
		this.addMouseListener(new MezoMouseListener());
		this.coord = coord;
	}
	
	public void setSelected(boolean selected) {
		if (selected)
			this.setBackground(SELECTED);
		else
			this.setBackground(TRANSPARENT);
		
		this.getParent().repaint();
	}
	
	public Dimension getPosition() {
		return coord;
	}
}
