package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JatekPanel extends JPanel {
	Controller controller;
	Image hatter;
	
	ArrayList<JatekButton> gombok;
	ArrayList<MezoPanel> mezok;
	EletVonalProgressBar pbar;
	EletVonalProgressBar mbar;
	
	public JatekPanel(Controller controller) {
		this.controller = controller;
		this.setLayout(null);
		this.gombok = new ArrayList<JatekButton>();
		this.mezok = new ArrayList<MezoPanel>();
		
		URL resource = MenuPanel.class.getResource("res/palya.jpg");
		ImageIcon ii = new ImageIcon(resource);
		hatter = ii.getImage();
		
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				MezoPanel mezo = new MezoPanel(new Point(x, y), this.controller);
				mezo.setSize(52, 52);
				mezo.setLocation(27 + (x * 50), 50 + (y * 50));
				this.add(mezo);
				this.mezok.add(mezo);
			}
		}
		
		// JOBB FŐPANEL
		AlphaPanel gombPanel = new AlphaPanel();
		gombPanel.setLayout(new BoxLayout(gombPanel, BoxLayout.Y_AXIS));
		gombPanel.setLocation(650, 50);
		gombPanel.setSize(new Dimension(278, 320));
		
		// ÉLETVONAL
		AlphaPanel eletVonalSor = new AlphaPanel();
		pbar = new EletVonalProgressBar(controller.szaruman.lekerMaxVarazsero());
		pbar.setValue(0);
		pbar.setStringPainted(true);
		pbar.setToolTipText("Varázserő");
		
		// ELLENSEGEK
		mbar = new EletVonalProgressBar(controller.ellensegek.lekerHanyEllensegVanMeg());
		mbar.setValue(0);
		mbar.setStringPainted(true);
		mbar.setToolTipText("Maradék ellenségek");

		eletVonalSor.add(mbar);
		eletVonalSor.add(pbar);
		
		gombPanel.add(eletVonalSor);
		
		// ELSŐDLEGES GOMBOK - TORONY LEREAK / AKADÁLY LERAK
		AlphaPanel lerakhatoGombSor = new AlphaPanel();
		lerakhatoGombSor.setLayout(new GridLayout(1, 2));
		// - TORONY LERAK
		JatekButton toronyLerakGomb = new JatekButton("toronyLerak", 175);
		toronyLerakGomb.addActionListener(controller);
		toronyLerakGomb.setToolTipText("Torony lerakása");
		lerakhatoGombSor.add(toronyLerakGomb);
		this.gombok.add(toronyLerakGomb);
		
		// - AKADÁLY LERAK
		JatekButton akadalyLerakGomb = new JatekButton("akadalyLerak", 200);
		akadalyLerakGomb.addActionListener(controller);
		akadalyLerakGomb.setToolTipText("Akadály lerakása");
		lerakhatoGombSor.add(akadalyLerakGomb);
		this.gombok.add(akadalyLerakGomb);
		
		// MÁSODLAGOS GOMBOK - VARÁZSKŐ LERAKÁSOK
		AlphaPanel akadalyGombSor = new AlphaPanel();
		akadalyGombSor.setLayout(new GridLayout(2, 3));
		// - SÁRGA VARÁZSKŐ
		VarazskoButton sargaVarazskoGomb = new VarazskoButton("varazskoLerak_sarga", 40);
		sargaVarazskoGomb.addActionListener(controller);
		sargaVarazskoGomb.setToolTipText("Sárga varázskő lerakása");
		akadalyGombSor.add(sargaVarazskoGomb);
		this.gombok.add(sargaVarazskoGomb);
		
		// - PIROS VARÁZSKŐ
		VarazskoButton pirosVarazskoGomb = new VarazskoButton("varazskoLerak_piros", 40);
		pirosVarazskoGomb.addActionListener(controller);
		pirosVarazskoGomb.setToolTipText("Piros varázskő lerakása");
		akadalyGombSor.add(pirosVarazskoGomb);
		this.gombok.add(pirosVarazskoGomb);
		
		// - ZÖLD VARÁZSKŐ
		VarazskoButton zoldVarazskoGomb = new VarazskoButton("varazskoLerak_zold", 40);
		zoldVarazskoGomb.addActionListener(controller);
		zoldVarazskoGomb.setToolTipText("Zöld varázskő lerakása");
		akadalyGombSor.add(zoldVarazskoGomb);
		this.gombok.add(zoldVarazskoGomb);
		
		// - KÉK VARÁZSKŐ
		VarazskoButton kekVarazskoGomb = new VarazskoButton("varazskoLerak_kek", 50);
		kekVarazskoGomb.addActionListener(controller);
		kekVarazskoGomb.setToolTipText("Kék varázskő lerakása");
		akadalyGombSor.add(kekVarazskoGomb);
		this.gombok.add(kekVarazskoGomb);
		
		// - LILA VARÁZSKŐ
		VarazskoButton lilaVarazskoGomb = new VarazskoButton("varazskoLerak_lila", 50);
		lilaVarazskoGomb.addActionListener(controller);
		lilaVarazskoGomb.setToolTipText("Szelő varázskő lerakása");
		akadalyGombSor.add(lilaVarazskoGomb);
		this.gombok.add(lilaVarazskoGomb);
		
		// - LSD VARÁZSKŐ
		VarazskoButton lsdVarazskoGomb = new VarazskoButton("varazskoLerak_lsd", 60);
		lsdVarazskoGomb.addActionListener(controller);
		lsdVarazskoGomb.setToolTipText("Ködösítő varázskő lerakása");
		akadalyGombSor.add(lsdVarazskoGomb);
		this.gombok.add(lsdVarazskoGomb);
		
		gombPanel.add(lerakhatoGombSor);
		gombPanel.add(akadalyGombSor);
		this.add(gombPanel);
	}
	
	public void setButtonState(JatekButton.ButtonState bs){
		for(JatekButton gmb : this.gombok){
			gmb.setButtonState(bs,false);
		}
	}
	
	public void setButtonState(JatekButton jb, JatekButton.ButtonState bs){
		jb.setButtonState(bs,false);
	}
	
	public void setButtonState(JatekButton jb, JatekButton.ButtonState bs, boolean force){
		jb.setButtonState(bs,force);
	}
	
	public void varazseroFeldolgoz(int varazsero){
		System.out.println("Varazsero: "+varazsero);
		this.pbar.setValue(varazsero);
		this.pbar.setToolTipText("Varázserő: "+this.pbar.getValue());
		for(JatekButton gmb : this.gombok){
			if(gmb.koltseg <= varazsero){
				this.setButtonState(gmb, JatekButton.ButtonState.ACTIVE, true);
			}else{
				this.setButtonState(gmb, JatekButton.ButtonState.INACTIVE, true);
			}
		}
	}
	
	public void statusChange(){
		for(MezoPanel mezo : this.mezok){
			mezo.statusChange();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hatter, 0, 0, Color.RED, null);
	}
}
