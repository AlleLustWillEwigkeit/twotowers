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
import allelustwillewigkeit.twotowers.model.Ut;

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
		
		if(controller.getLerakas() != null){
			PalyaElem pe = controller.getPalyaElemByXY(coord.x, coord.y);
			
			switch(controller.getLerakas()){
				case TORONY:
					EpitesiTerulet et = pe.lekerEpitesiTerulet();
					if (et == null || et.vanToronyRajta()){
						g.setColor(new Color(255, 0, 0, 100));
					}else{
						g.setColor(new Color(255, 255, 255, 100));
					}
					g.fillRect(0, 0, 52, 52);
					
					/*ImageIcon torony = new ImageIcon(MezoPanel.class.getResource("/res/toronyLerak_intermediate.png"));
					g.drawImage(torony.getImage(), 0, 0, null);*/
					break;	
					
				case AKADALY:
					Ut ut = pe.lekerUt();
					if (ut == null || ut.vanAkadalyRajta())
						g.setColor(new Color(255, 0, 0, 100));
					else
						g.setColor(new Color(255, 255, 255, 100));
					g.fillRect(0, 0, 52, 52);
					
					/*ImageIcon akadaly = new ImageIcon(MezoPanel.class.getResource("/res/akadalyLerak_intermediate.png"));
					g.drawImage(akadaly.getImage(), 0, 0, null);*/
					break;
				case VARAZSKO:
					//TODO varázskő overlay
					Ut utt = pe.lekerUt();
					EpitesiTerulet ett = pe.lekerEpitesiTerulet();
					
					if ((utt != null) && (utt.vanAkadalyRajta()))
						g.setColor(new Color(255, 255, 255, 100));
					else if((ett != null) && (ett.vanToronyRajta()))
						g.setColor(new Color(255, 255, 255, 100));
					else
						g.setColor(new Color(255, 0, 0, 100));
						
					g.fillRect(0, 0, 52, 52);
					
					switch(controller.getVarazskoSzinek()){
						case SARGA:
							break;
						case ZOLD:
							break;
						case PIROS:
							break;
						case KEK:
							break;
						case LILA:
							break;
						case LSD:
							break;
					}
					
					break;
	
			}
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
