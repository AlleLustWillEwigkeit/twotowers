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
	View mainFrame;
	Palya palya;
	Jatekmotor motor;
	Ellensegek ellensegek;
	JosagosSzaruman szaruman;
	boolean toronyLerakas, akadalyLerakas, varazskoLerakas;
	JatekButton jb;
	Start start;
	int osszletszamAmiResetelunk = 500;
	
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
		toronyLerakas = true;
		akadalyLerakas = false;
		varazskoLerakas = false;
		jb = jbt;
	}
	
	public void akadalyLerak(JatekButton jbt){
		toronyLerakas = false;
		akadalyLerakas = true;
		varazskoLerakas = false;
		jb = jbt;
	}
	
	public void varazskoLerak_sarga(JatekButton jbt){
		toronyLerakas = false;
		akadalyLerakas = false;
		varazskoLerakas = true;
		jb = jbt;
	}
	
	public void varazskoLerak_piros(JatekButton jbt){
		toronyLerakas = false;
		akadalyLerakas = false;
		varazskoLerakas = true;
		jb = jbt;
	}
	
	public void varazskoLerak_zold(JatekButton jbt){
		toronyLerakas = false;
		akadalyLerakas = false;
		varazskoLerakas = true;
		jb = jbt;
	}
	
	public void varazskoLerak_kek(JatekButton jbt){
		toronyLerakas = false;
		akadalyLerakas = false;
		varazskoLerakas = true;
		jb = jbt;
	}
	
	public void varazskoLerak_lila(JatekButton jbt){
		toronyLerakas = false;
		akadalyLerakas = false;
		varazskoLerakas = true;
		jb = jbt;
	}
	
	public void varazskoLerak_lsd(JatekButton jbt){
		toronyLerakas = false;
		akadalyLerakas = false;
		varazskoLerakas = true;
		jb = jbt;
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

	public boolean getToronyLerakas() {
		return toronyLerakas;
	}

	public boolean getAkadalyLerakas() {
		return akadalyLerakas;
	}

	public boolean getVarazskoLerakas() {
		return varazskoLerakas;
	}
	
	public JatekButton getLastJatekButton(){
		return jb;
	}
}
