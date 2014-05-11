package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import allelustwillewigkeit.twotowers.model.EpitesiTerulet;
import allelustwillewigkeit.twotowers.model.PalyaElem;
import allelustwillewigkeit.twotowers.model.Ut;

public class MezoPanel extends AlphaPanel {
	static final Color ENABLED_C = new Color(255, 255, 255, 100);
	static final Color DISABLED_C = new Color(255, 0, 0, 100);
	
	boolean focus = false;
	boolean enabled = true;
	Controller controller;
	Point coord;
	Image overlayImage = null;
	Image roleImage = null;
	
	private class MezoMouseListener implements MouseListener {  //EZT OTTHON NE PRÓBÁLJÁTOK KI
		@Override
		public void mouseClicked(MouseEvent arg0) {
			MezoPanel mezo = (MezoPanel)arg0.getSource();
			mezo.doAction();
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
		if (!focus)
			return;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (enabled)
			g2.setColor(ENABLED_C);
		else
			g2.setColor(DISABLED_C);
		
		g2.fillRoundRect(0, 0, 52, 52, 8, 8);
		if (overlayImage != null)
			g2.drawImage(overlayImage, 0, 0, null);
		if (roleImage != null)
			g2.drawImage(roleImage, 0, 0, null);
	}
	
	public void setSelected(boolean selected) {
		this.focus = selected;

		if(selected && controller.getLerakas() != null) {
			PalyaElem pe = controller.getPalyaElemByXY(coord.x, coord.y);
			EpitesiTerulet et = pe.lekerEpitesiTerulet();
			Ut ut = pe.lekerUt();
			
			this.enabled = true;
			switch(controller.getLerakas()) {
				case TORONY:
					if (et == null || et.vanToronyRajta()) {
						enabled = false;
						overlayImage = null;
					} else {
						overlayImage = new ImageIcon(MezoPanel.class.getResource("res/toronyLerak_intermediate.png")).getImage();
					}
					break;	
					
				case AKADALY:
					overlayImage = new ImageIcon(MezoPanel.class.getResource("res/akadalyLerak_intermediate.png")).getImage();
					if (ut == null || ut.vanAkadalyRajta())
						enabled = false;
					break;
					
				case VARAZSKO:
					//TODO varázskő overlay
					try {
						if (ut != null)
							ut.lekerAkadaly();
						if (et != null)
							et.lekerTorony();
					} catch (Exception e) {
						enabled = false;
					}
					
					switch(controller.getVarazskoSzinek()) {
						case SARGA:
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/varazskoLerak_sarga_intermediate.png")).getImage();
							break;
						case ZOLD:
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/varazskoLerak_zold_intermediate.png")).getImage();
							break;
						case PIROS:
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/varazskoLerak_piros_intermediate.png")).getImage();
							break;
						case KEK:
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/varazskoLerak_kek_intermediate.png")).getImage();
							break;
						case LILA:
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/varazskoLerak_lila_intermediate.png")).getImage();
							break;
						case LSD:
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/varazskoLerak_lsd_intermediate.png")).getImage();
							break;
					}
					break;
					
				default:
					overlayImage = null;
			} 
		}
		
		this.repaint();
	}
	
	public void statusChange() {
		PalyaElem pe = controller.getPalyaElemByXY(coord.x, coord.y);
		EpitesiTerulet et = pe.lekerEpitesiTerulet();
		Ut ut = pe.lekerUt();
		
		try {
			if (ut != null)
				ut.lekerAkadaly();
				roleImage = new ImageIcon(MezoPanel.class.getResource("res/akadaly.png")).getImage();
			if (et != null)
				et.lekerTorony();
				roleImage = new ImageIcon(MezoPanel.class.getResource("res/torony.png")).getImage();
		} catch (Exception e) {
		}
	}
	
	public void doAction() {
		if (this.enabled)
			controller.actionPerformed(new ActionEvent(this, 0, "mezoKattint")); // ILYET SOHA TÖBBET NEM CSINÁLUNK, TRÓGER LVL 9000
	}
	
	public Point getPosition() {
		return coord;
	}
}
