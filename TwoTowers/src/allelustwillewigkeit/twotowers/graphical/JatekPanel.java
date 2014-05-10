package allelustwillewigkeit.twotowers.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JatekPanel extends JPanel {
	Controller controller;
	Image hatter;
	
	List<JatekButton> gombok;
	
	public JatekPanel(Controller controller) {
		this.controller = controller;
		this.setLayout(null);
		
		URL resource = MenuPanel.class.getResource("res/palya.jpg");
		ImageIcon ii = new ImageIcon(resource);
		hatter = ii.getImage();
		
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				MezoPanel mezo = new MezoPanel(new Point(x, y), this.controller);
				mezo.setSize(52, 52);
				mezo.setLocation(27 + (x * 50), 50 + (y * 50));
				this.add(mezo);
			}
		}
		
		// JOBB FŐPANEL
		AlphaPanel gombPanel = new AlphaPanel();
		gombPanel.setLayout(new BoxLayout(gombPanel, BoxLayout.Y_AXIS));
		gombPanel.setLocation(650, 50);
		gombPanel.setSize(new Dimension(278, 280));
		
		// ÉLETVONAL
		AlphaPanel eletVonalSor = new AlphaPanel();
		EletVonalProgressBar progressBar = new EletVonalProgressBar(1000);
		progressBar.setValue(1000);
        progressBar.setStringPainted(true);
        progressBar.setToolTipText("Varázserő");
		eletVonalSor.add(progressBar);
		gombPanel.add(eletVonalSor);
		
		// ELSŐDLEGES GOMBOK - TORONY LEREAK / AKADÁLY LERAK
		AlphaPanel lerakhatoGombSor = new AlphaPanel();
		lerakhatoGombSor.setLayout(new GridLayout(1, 2));
		// - TORONY LERAK
		JatekButton toronyLerakGomb = new JatekButton("toronyLerak");
		toronyLerakGomb.addActionListener(controller);
		toronyLerakGomb.setToolTipText("Torony lerakása");
		lerakhatoGombSor.add(toronyLerakGomb);
		this.gombok.add(toronyLerakGomb);
		// - AKADÁLY LERAK
		JatekButton akadalyLerakGomb = new JatekButton("akadalyLerak");
		akadalyLerakGomb.addActionListener(controller);
		akadalyLerakGomb.setToolTipText("Akadály lerakása");
		lerakhatoGombSor.add(akadalyLerakGomb);
		this.gombok.add(akadalyLerakGomb);
		
		// MÁSODLAGOS GOMBOK - VARÁZSKŐ LERAKÁSOK
		AlphaPanel akadalyGombSor = new AlphaPanel();
		akadalyGombSor.setLayout(new GridLayout(2, 3));
		// - SÁRGA VARÁZSKŐ
		VarazskoButton sargaVarazskoGomb = new VarazskoButton("varazskoLerak_sarga");
		sargaVarazskoGomb.addActionListener(controller);
		sargaVarazskoGomb.setToolTipText("Sárga varázskő lerakása");
		akadalyGombSor.add(sargaVarazskoGomb);

		this.gombok.add(sargaVarazskoGomb);
		// - PIROS VARÁZSKŐ
		VarazskoButton pirosVarazskoGomb = new VarazskoButton("varazskoLerak_piros");
		pirosVarazskoGomb.addActionListener(controller);
		pirosVarazskoGomb.setToolTipText("Piros varázskő lerakása");
		akadalyGombSor.add(pirosVarazskoGomb);

		this.gombok.add(pirosVarazskoGomb);
		// - ZÖLD VARÁZSKŐ
		VarazskoButton zoldVarazskoGomb = new VarazskoButton("varazskoLerak_zold");
		zoldVarazskoGomb.addActionListener(controller);
		zoldVarazskoGomb.setToolTipText("Zöld varázskő lerakása");
		akadalyGombSor.add(zoldVarazskoGomb);

		this.gombok.add(zoldVarazskoGomb);
		// - KÉK VARÁZSKŐ
		VarazskoButton kekVarazskoGomb = new VarazskoButton("varazskoLerak_kek");
		kekVarazskoGomb.addActionListener(controller);
		kekVarazskoGomb.setToolTipText("Kék varázskő lerakása");
		akadalyGombSor.add(kekVarazskoGomb);

		this.gombok.add(kekVarazskoGomb);
		// - LILA VARÁZSKŐ
		VarazskoButton lilaVarazskoGomb = new VarazskoButton("varazskoLerak_lila");
		lilaVarazskoGomb.addActionListener(controller);
		lilaVarazskoGomb.setToolTipText("Lila varázskő lerakása");
		akadalyGombSor.add(lilaVarazskoGomb);

		this.gombok.add(lilaVarazskoGomb);
		// - LSD VARÁZSKŐ
		VarazskoButton lsdVarazskoGomb = new VarazskoButton("varazskoLerak_lsd");
		lsdVarazskoGomb.addActionListener(controller);
		lsdVarazskoGomb.setToolTipText("LSD varázskő lerakása"); // FIXME Na most ez itt így marad?
		akadalyGombSor.add(lsdVarazskoGomb);

		this.gombok.add(lsdVarazskoGomb);
		
		gombPanel.add(lerakhatoGombSor);
		gombPanel.add(akadalyGombSor);
		this.add(gombPanel);
	}
	
	public void setButtonState(JatekButton.ButtonState bs){
		for(JatekButton gmb : this.gombok){
			gmb.setButtonState(bs);
		}
	}
	
	public void setButtonState(JatekButton jb, JatekButton.ButtonState bs){
		jb.setButtonState(bs);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(hatter, 0, 0, Color.RED, null);
	}
}
