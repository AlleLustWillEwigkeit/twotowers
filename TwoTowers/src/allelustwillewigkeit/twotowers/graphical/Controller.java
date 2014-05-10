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
	
	public void toronyLerak(){
		lerakas = Lerakas.TORONY;
	}
	
	public void akadalyLerak(){
		lerakas = Lerakas.AKADALY;
	}
	
	public void varazskoLerak_sarga() {
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.SARGA;
	}
	
	public void varazskoLerak_piros() {
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.PIROS;
	}
	
	public void varazskoLerak_zold(){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.ZOLD;
	}
	
	public void varazskoLerak_kek(){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.KEK;
	}
	
	public void varazskoLerak_lila(){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.LILA;
	}
	
	public void varazskoLerak_lsd(){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.LSD;
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case "toronyLerak":
			lerakas = Lerakas.TORONY;
			break;
		case "akadalyLerak":
			lerakas = Lerakas.AKADALY;
			break;
		case "varazskoLerak_sarga":
			varazskoLerak_sarga();
			break;
		case "varazskoLerak_piros":
			varazskoLerak_piros();
			break;
		case "varazskoLerak_zold":
			varazskoLerak_zold();
			break;
		case "varazskoLerak_kek":
			varazskoLerak_kek();
			break;
		case "varazskoLerak_lila":
			varazskoLerak_lila();
			break;
		case "varazskoLerak_lsd":
			varazskoLerak_lsd();
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
	
	public String getActionType(){
		
		if(lerakas == Lerakas.TORONY){
			return "toronyLerak";
		}else if (lerakas == Lerakas.AKADALY) {
			return "akadalyLerak";
		}else if (lerakas == Lerakas.VARAZSKO) {
			return "varazskoLerak_"; //+varazskoTipus; - ez itt enum miatt vicces, de megoldható
		}else{
			return "";
		}
	}
}
