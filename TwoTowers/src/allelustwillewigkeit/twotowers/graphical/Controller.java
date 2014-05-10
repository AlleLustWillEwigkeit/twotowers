package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import allelustwillewigkeit.twotowers.model.Ellensegek;
import allelustwillewigkeit.twotowers.model.Jatekmotor;
import allelustwillewigkeit.twotowers.model.JosagosSzaruman;
import allelustwillewigkeit.twotowers.model.Palya;
import allelustwillewigkeit.twotowers.model.PalyaElem;
import allelustwillewigkeit.twotowers.model.Start;
import allelustwillewigkeit.twotowers.model.Ut;

public class Controller implements ActionListener {
	public enum Lerakas {
		TORONY, AKADALY, VARAZSKO
	};
	
	public enum VarazskoSzinek {
		SARGA, ZOLD, PIROS, KEK, LILA, LSD
	};
	
	View mainFrame;
	Palya palya;
	Jatekmotor motor;
	Ellensegek ellensegek;
	JosagosSzaruman szaruman;
	JatekButton jb;
	Start start;
	int osszletszamAmiResetelunk = 500;
	Lerakas lerakas;
	VarazskoSzinek vkSzinek;
	
	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
	}
	
	Controller() {
		mainFrame = new View(this);
		mainFrame.setVisible(true);
		
		mainFrame.menuRajzol();
		jb = null;
	}
	
	public void ujJatek() {

		palya = new Palya();
		start = palya.getStart(); // TODO 

		szaruman = new JosagosSzaruman(500);
		ellensegek = new Ellensegek(motor = new Jatekmotor(ellensegek, szaruman, palya), 500, start, szaruman);
		//Ellensegek(Jatekmotor _jatekmotor, int _osszletszam, Start _kezdohely, JosagosSzaruman _szaruman) {
		

		
		//szaruman = new JosagosSzaruman(1000);
		//ellensegek = new Ellensegek(_jatekmotor, _osszletszam, _kezdohely, _szaruman)
		//motor = new Jatekmotor(_ellensegek, _josagosSzaruman, _palya)        //FIXME kölcsönös kizárás, WTF!!
		
		
		mainFrame.jatekRajzol();
	}
	
	public PalyaElem getPalyaElemByXY(int x, int y){
		return palya.getElementByXY(x, y);
	}
	
	public void tick() {
		
	}
	

	public void toronyLerak(JatekButton jbt){
		lerakas = Lerakas.TORONY;
		jb = jbt;
	}
	

	public void akadalyLerak(JatekButton jbt){
		jb = jbt;
		lerakas = Lerakas.AKADALY;
	}
	

	public void varazskoLerak_sarga(JatekButton jbt){
		jb = jbt;
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.SARGA;
	}
	

	public void varazskoLerak_piros(JatekButton jbt){
		jb = jbt;
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.PIROS;
	}

	public void varazskoLerak_zold(JatekButton jbt){
		jb = jbt;
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.ZOLD;
	}

	public void varazskoLerak_kek(JatekButton jbt){
		jb = jbt;
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.KEK;
	}
	
	public void varazskoLerak_lila(JatekButton jbt){
		jb = jbt;
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.LILA;
	}
	
	public void varazskoLerak_lsd(JatekButton jbt){
		jb = jbt;
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.LSD;
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case "toronyLerak":
			toronyLerak((JatekButton)a.getSource());
			break;
		case "akadalyLerak":
			akadalyLerak((JatekButton)a.getSource());
			break;
		case "varazskoLerak_sarga":
			varazskoLerak_sarga((JatekButton)a.getSource());
			break;
		case "varazskoLerak_piros":
			varazskoLerak_piros((JatekButton)a.getSource());
			break;
		case "varazskoLerak_zold":
			varazskoLerak_zold((JatekButton)a.getSource());
			break;
		case "varazskoLerak_kek":
			varazskoLerak_kek((JatekButton)a.getSource());
			break;
		case "varazskoLerak_lila":
			varazskoLerak_lila((JatekButton)a.getSource());
			break;
		case "varazskoLerak_lsd":
			varazskoLerak_lsd((JatekButton)a.getSource());
			break;
		case "ujJatek":
			ujJatek();
			break;
		case "kilep":
			mainFrame.kilep();
			break;
		}

	}

	public Lerakas getLerakas() {
		return lerakas;
	}
	public JatekButton getLastJatekButton(){
		return jb;
	}
}
