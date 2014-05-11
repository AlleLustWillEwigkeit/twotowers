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
import java.util.List;

import javax.swing.ImageIcon;

import allelustwillewigkeit.twotowers.model.Ellenseg;
import allelustwillewigkeit.twotowers.model.EpitesiTerulet;
import allelustwillewigkeit.twotowers.model.PalyaElem;
import allelustwillewigkeit.twotowers.model.Ut;

public class MezoPanel extends AlphaPanel {
	static final Color ENABLED_C = new Color(255, 255, 255, 100);
	static final Color DISABLED_C = new Color(255, 0, 0, 100);
	
	boolean focus = false;
	boolean enabled = true;
	Controller controller;
	PalyaElem pe;
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
		
		this.pe = controller.getPalyaElemByXY(coord.x, coord.y);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (focus) {
			if (enabled)
				g2.setColor(ENABLED_C);
			else
				g2.setColor(DISABLED_C);
			
			g2.fillRoundRect(0, 0, 52, 52, 8, 8);
			if (overlayImage != null)
				g2.drawImage(overlayImage, 0, 0, null);
		}
		
		if (roleImage != null)
			g2.drawImage(roleImage, 0, 0, null);
		
		if (pe.lekerUt() != null) {
			List<Ellenseg> ellensegek = controller.getEllensegekAt(coord.x, coord.y);
			for (Ellenseg e : ellensegek) {
				Image ellensegImg = new ImageIcon(MezoPanel.class.getResource("res/" + e.lekerFaj() + ".png")).getImage();
				g2.drawImage(ellensegImg, 0, 0, null);
			}
		}
	}
	
	public void setSelected(boolean selected) {
		this.focus = selected;

		if(selected && controller.getLerakas() != null) {
			EpitesiTerulet et = pe.lekerEpitesiTerulet();
			Ut ut = pe.lekerUt();
			
			this.enabled = true;
			switch(controller.getLerakas()) {
				case TORONY:
					if (et == null) {
						enabled = false;
						overlayImage = new ImageIcon(MezoPanel.class.getResource("res/toronyLerak_intermediate.png")).getImage();
					} else {
						if (et.vanToronyRajta()) {
							enabled = false;
							overlayImage = null;
						} else
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/toronyLerak_intermediate.png")).getImage();
					}
					break;
					
				case AKADALY:
					if (ut == null) {
						enabled = false;
						overlayImage = new ImageIcon(MezoPanel.class.getResource("res/akadalyLerak_intermediate.png")).getImage();
					} else {
						if (ut.vanAkadalyRajta())
							overlayImage = null;
						else
							overlayImage = new ImageIcon(MezoPanel.class.getResource("res/akadalyLerak_intermediate.png")).getImage();
					}
					break;	
					
				case VARAZSKO:
					enabled = false;
					if (ut != null && ut.vanAkadalyRajta() || et != null && et.vanToronyRajta())
						enabled = true;
					
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
		EpitesiTerulet et = pe.lekerEpitesiTerulet();
		Ut ut = pe.lekerUt();
		
		if (ut != null && ut.vanAkadalyRajta())
			roleImage = new ImageIcon(MezoPanel.class.getResource("res/akadaly.png")).getImage();
		if (et != null && et.vanToronyRajta())
			roleImage = new ImageIcon(MezoPanel.class.getResource("res/torony.png")).getImage();
	}
	
	public void doAction() {
		if (this.enabled)
			controller.actionPerformed(new ActionEvent(this, 0, "mezoKattint")); // ILYET SOHA TÖBBET NEM CSINÁLUNK, TRÓGER LVL 9000
	}
	
	public Point getPosition() {
		return coord;
	}
}
