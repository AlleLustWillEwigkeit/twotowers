package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import allelustwillewigkeit.twotowers.model.Ellenseg;
import allelustwillewigkeit.twotowers.model.Ellensegek;
import allelustwillewigkeit.twotowers.model.Jatekmotor;
import allelustwillewigkeit.twotowers.model.JosagosSzaruman;
import allelustwillewigkeit.twotowers.model.Palya;
import allelustwillewigkeit.twotowers.model.PalyaElem;
import allelustwillewigkeit.twotowers.model.Start;
import allelustwillewigkeit.twotowers.model.Ut;
import allelustwillewigkeit.twotowers.model.Varazsko;

public class Controller implements ActionListener {
	public enum Lerakas {
		TORONY, AKADALY, VARAZSKO
	};
	
	public enum VarazskoSzinek {
		SARGA, ZOLD, PIROS, KEK, LILA, LSD
	};
	
	int koltseg;
	
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
		this.koltseg = 0;
	}
	
	public void ujJatek() {

		palya = new Palya(motor);
		start = palya.getStart(); // TODO 

		szaruman = new JosagosSzaruman(500);
		this.koltseg = 0;
		
		ellensegek = new Ellensegek(motor = new Jatekmotor(ellensegek, szaruman, palya), 500, start, szaruman);
		//Ellensegek(Jatekmotor _jatekmotor, int _osszletszam, Start _kezdohely, JosagosSzaruman _szaruman) {
		

		
		//szaruman = new JosagosSzaruman(1000);
		//ellensegek = new Ellensegek(_jatekmotor, _osszletszam, _kezdohely, _szaruman)
		//motor = new Jatekmotor(_ellensegek, _josagosSzaruman, _palya)        //FIXME kölcsönös kizárás, WTF!!
		
		
		mainFrame.jatekRajzol();
		this.varazseroFeldolgoz();
		
		//TESZT ELLENSÉG HOZZÁADÁSA
		try {
			ellensegek.inditEllenseg(1, 1, 10000);
		} catch (Exception e) {
			
		}
	}
	
	public PalyaElem getPalyaElemByXY(int x, int y){
		return palya.getElementByXY(x, y);
	}
	
	public void tick() {
	}
	

	public void toronyLerak(JatekButton jbt){
		lerakas = Lerakas.TORONY;
		setActualButton(jbt);
	}
	

	public void akadalyLerak(JatekButton jbt){
		lerakas = Lerakas.AKADALY;
		setActualButton(jbt);
	}
	

	public void varazskoLerak_sarga(JatekButton jbt){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.SARGA;
		setActualButton(jbt);
	}
	

	public void varazskoLerak_piros(JatekButton jbt){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.PIROS;
		setActualButton(jbt);
	}

	public void varazskoLerak_zold(JatekButton jbt){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.ZOLD;
		setActualButton(jbt);
	}

	public void varazskoLerak_kek(JatekButton jbt){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.KEK;
		setActualButton(jbt);
	}
	
	public void varazskoLerak_lila(JatekButton jbt){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.LILA;
		setActualButton(jbt);
	}
	
	public void varazskoLerak_lsd(JatekButton jbt){
		lerakas = Lerakas.VARAZSKO;
		vkSzinek = VarazskoSzinek.LSD;
		setActualButton(jbt);
	}
	
	public void setActualButton(JatekButton jbt){
		if(mainFrame.isPlaying){
			this.koltseg = jbt.koltseg;
			JatekPanel jp = (JatekPanel)mainFrame.jelenlegiPanel;
			jp.setButtonState(JatekButton.ButtonState.ACTIVE);
			jp.setButtonState(jbt, JatekButton.ButtonState.SELECTED);
		}
	}
	
	public void varazseroFeldolgoz(){
		if(mainFrame.isPlaying){
			int varazsero = this.szaruman.lekerVarazsero();
			JatekPanel jp = (JatekPanel)mainFrame.jelenlegiPanel;
			jp.varazseroFeldolgoz(varazsero);
			
			if(this.koltseg > varazsero){
				this.lerakas = null;
				this.vkSzinek = null;
			}
		}
	}
	
	public void mezoKattint(MezoPanel mezo){
		System.out.println("Mezo kattintas");
		if(this.getLerakas() == null) return;
		
		System.out.println("Van gomb kivalasztva");
		PalyaElem pe = this.getPalyaElemByXY(mezo.coord.x, mezo.coord.y);
		
		switch(this.getLerakas()){
			case TORONY:
				System.out.println("Torony lerakas");
				if(!pe.vanEpitesiTerulete()) return;
				System.out.println("Van epitesi terulet");
				if(pe.lekerEpitesiTerulet().vanToronyRajta()) return;
				System.out.println("Nincs torony rajta");
				
				pe.lekerEpitesiTerulet().lerakTornyot(0);
				System.out.println("Torony lerakása sikerult");
				break;
			case AKADALY:
				if(!pe.vanUtja()) return;
				if(pe.lekerUt().vanAkadalyRajta()) return;
				
				pe.lekerUt().lerakAkadaly(0);
				break;
			case VARAZSKO:
				if(!pe.vanEpitesiTerulete() && !pe.vanUtja()) return;
				
				if(this.getVarazskoSzinek() == null) return;
				Varazsko v = null;
				switch(this.getVarazskoSzinek()){
					case SARGA:
						v = new Varazsko(1,0);
						break;
					case ZOLD: 
						v = new Varazsko(3,0); 
						break;
					case PIROS: 
						v = new Varazsko(2,0); 
						break;
					case KEK:  
						v = new Varazsko(4,0);
						break;
					case LILA:
						v = new Varazsko(5,0);  
						break;
					case LSD: 
						v = new Varazsko(6,0);
						break;
				}
				
				if(pe.vanEpitesiTerulete()){
					if(!pe.lekerEpitesiTerulet().vanToronyRajta()) return;
					
					pe.lekerEpitesiTerulet().lekerTorony().felkovez(v);
				}
				
				if(pe.vanUtja()){
					if(!pe.lekerUt().vanAkadalyRajta()) return;
					
					pe.lekerUt().lekerAkadaly().felkovez(v);
				}
				
				break;
		}

		this.szaruman.varazseroCsokkent(this.koltseg);

		System.out.println("Mezoelemek frissitese");
		if(mainFrame.isPlaying){
			JatekPanel jp = (JatekPanel)mainFrame.jelenlegiPanel;
			jp.statusChange();
		}
		
		this.varazseroFeldolgoz();
		
		System.out.println("Kesz");
		return;
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case "mezoKattint":
			//TODO mezőre kattintás
			this.mezoKattint((MezoPanel)a.getSource());
			System.out.println("Mezokattint kesz");
			break;
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

		this.mainFrame.repaint();
	}

	public Lerakas getLerakas() {
		return this.lerakas;
	}
	
	public VarazskoSzinek getVarazskoSzinek(){
		return this.vkSzinek;
	}

	public List<Ellenseg> getEllensegekAt(int x, int y) {
		List<Ellenseg> ellenek = ellensegek.lekerLista();
		List<Ellenseg> result = new ArrayList<Ellenseg>();
		PalyaElem pe = palya.getElementByXY(x, y);
		Ut ut = pe.lekerUt();
		
		for (Ellenseg e : ellenek) {
			if (e.lekerut() == ut)
				result.add(e);
		}
		
		return result;
	}
}
