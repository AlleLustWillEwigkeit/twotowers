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
		// MAPGENERÁLÁS
		PalyaElem[][] palyaelemek = new PalyaElem[12][12];
		
		int id = 1;
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				palyaelemek[x][y] = new PalyaElem(id++);
			}
		}
		
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				PalyaElem palyaelem = palyaelemek[x][y];
				if ((x + 1) < 12)
					palyaelem.addSzomszed(palyaelemek[x + 1][y]);
				if ((y + 1) < 12)
					palyaelem.addSzomszed(palyaelemek[x][y + 1]);
			}
		}
		//END OF MAP GENERATION MAGIC
		
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
