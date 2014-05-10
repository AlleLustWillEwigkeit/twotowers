package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;

import allelustwillewigkeit.twotowers.model.EpitesiTerulet;
import allelustwillewigkeit.twotowers.model.PalyaElem;

public class MezoPanel extends AlphaPanel {
	boolean selected;
	Controller controller;
	Point coord;
	
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
	
	public MezoPanel(Point coord, Controller controller) {
		this.setOpaque(false);
		this.setBackground(TRANSPARENT);
		this.addMouseListener(new MezoMouseListener());
		this.coord = coord;
		this.controller = controller;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (!selected) {
			g.setColor(new Color(255, 255, 255, 255));
			g.drawRect(0, 0, 52, 52);
			return;
		}
		
		PalyaElem pe = controller.getPalyaElemByXY(coord.x, coord.y);
		
		if (controller.getLerakas() == Controller.Lerakas.TORONY) {
			EpitesiTerulet et = pe.lekerEpitesiTerulet();
			if (et == null || et.lekerTorony() != null)
				g.setColor(new Color(255, 0, 0, 100));
			else
				g.setColor(new Color(255, 255, 255, 100));
			g.fillRect(0, 0, 52, 52);
			
			URL resource = MezoPanel.class.getResource("/res/toronyLerak_intermediate.png");
			ImageIcon ii = new ImageIcon(resource);
			g.drawImage(ii.getImage(), 0, 0, null);
		} else if (controller.getLerakas() == Controller.Lerakas.AKADALY) {
			URL resource = MezoPanel.class.getResource("/res/akadalyLerak_intermediate.png");
			ImageIcon ii = new ImageIcon(resource);
			g.drawImage(ii.getImage(), 0, 0, null);
		} else if (controller.getLerakas() == Controller.Lerakas.AKADALY) {
			//TODO varázskő overlay
		}
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
		this.repaint();
	}
	
	public Point getPosition() {
		return coord;
	}
}
