package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import allelustwillewigkeit.twotowers.model.*;

public class Controller implements ActionListener {
	View mainFrame;
	
	Jatekmotor motor;
	Ellensegek ellensegek;
	JosagosSzaruman szaruman;
	
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
	
	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case "ujJatek":
			ujJatek();
			break;
		case "kilep":
			mainFrame.kilep();
			break;
		}

	}
}
