package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MezoPanel extends AlphaPanel {
	boolean selected;
	Controller controller;
	
	private class MezoMouseListener implements MouseListener {  //EZT OTTHON NE PRÓBÁLJÁTOK KI
		@Override
		public void mouseClicked(MouseEvent arg0) {
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
	
	Dimension coord;
	
	public MezoPanel(Dimension coord, Controller controller) {
		this.setOpaque(false);
		this.setBackground(TRANSPARENT);
		this.addMouseListener(new MezoMouseListener());
		this.coord = coord;
		this.controller = controller;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (!selected)
			return;
		
		if (controller.getToronyLerakas()) {
			//TODO torony overlay
		} else if (controller.getAkadalyLerakas()) {
			//TODO akadály overlay
		} else if (controller.getVarazskoLerakas()) {
			//TODO varázskő overlay
		}
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Dimension getPosition() {
		return coord;
	}
}
