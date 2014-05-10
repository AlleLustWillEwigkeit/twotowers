package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import allelustwillewigkeit.twotowers.model.Ellensegek;
import allelustwillewigkeit.twotowers.model.Jatekmotor;
import allelustwillewigkeit.twotowers.model.JosagosSzaruman;
import allelustwillewigkeit.twotowers.model.PalyaElem;

public class Controller implements ActionListener {
	View mainFrame;
	
	Jatekmotor motor;
	Ellensegek ellensegek;
	JosagosSzaruman szaruman;
	boolean toronyLerakas, akadalyLerakas, varazskoLerakas;
	
	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
	}
	
	Controller() {
		mainFrame = new View(this);
		mainFrame.setVisible(true);
		
		mainFrame.menuRajzol();
	}
	
	public void ujJatek() {

		Palya palya = new Palya();
		
		

		
		//szaruman = new JosagosSzaruman(1000);
		//ellensegek = new Ellensegek(_jatekmotor, _osszletszam, _kezdohely, _szaruman)
		//motor = new Jatekmotor(_ellensegek, _josagosSzaruman, _palya, _program)        //FIXME kölcsönös kizárás, WTF!!
		
		
		mainFrame.jatekRajzol();
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

	public boolean getToronyLerakas() {
		return toronyLerakas;
	}

	public boolean getAkadalyLerakas() {
		return akadalyLerakas;
	}

	public boolean getVarazskoLerakas() {
		return varazskoLerakas;
	}
}
