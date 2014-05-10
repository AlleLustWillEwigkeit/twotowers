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
	Start start;
	int osszletszamAmiResetelunk = 500;
	
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
		start =  //(Start) palya.getKezdoPalyaElem().lekerUt(); // TODO 
				null;
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
		
	}
	
	public void akadalyLerak(){
		
	}
	
	public void varazskoLerak_sarga(){
		
	}
	
	public void varazskoLerak_piros(){
		
	}
	
	public void varazskoLerak_zold(){
		
	}
	
	public void varazskoLerak_kek(){
		
	}
	
	public void varazskoLerak_lila(){
		
	}
	
	public void varazskoLerak_lsd(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case "toronyLerak":
			toronyLerak();
			break;
		case "akadalyLerak":
			akadalyLerak();
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
}
