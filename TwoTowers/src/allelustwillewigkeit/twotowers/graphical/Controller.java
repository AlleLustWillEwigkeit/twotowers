package allelustwillewigkeit.twotowers.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

import allelustwillewigkeit.twotowers.model.Akadaly;
import allelustwillewigkeit.twotowers.model.Ellenseg;
import allelustwillewigkeit.twotowers.model.Ellensegek;
import allelustwillewigkeit.twotowers.model.Jatekmotor;
import allelustwillewigkeit.twotowers.model.JosagosSzaruman;
import allelustwillewigkeit.twotowers.model.Palya;
import allelustwillewigkeit.twotowers.model.PalyaElem;
import allelustwillewigkeit.twotowers.model.Start;
import allelustwillewigkeit.twotowers.model.Torony;
import allelustwillewigkeit.twotowers.model.Ut;
import allelustwillewigkeit.twotowers.model.Varazsko;

public class Controller implements ActionListener {
	
	private class Worker extends SwingWorker<Boolean, Integer>{
		int tc;
		
		@Override
		protected Boolean doInBackground() throws Exception {
			tc=0;
			while(doWork){
				Thread.sleep(1000);
				try{
					if(motor.lekerallapot() == 0){
						ellensegek.mindLep();
						palya.tick();
						tc++;
						
						/*Ellengeneralo logika*/
						final int magicConstant = 5;
						if(tc % magicConstant == 0){
							for(int i = 0; i < tc/ magicConstant ; i++){
								ellensegek.inditEllenseg(1,1, 10000 );
							}
						}
						
						if(tc % (int) (1+(Math.random() * 100)) == 0){
							List<Torony> lehetosegek = palya.lekerKodositetlenTornyok();
							if(lehetosegek.size() > 0){
								Torony t = lehetosegek.get((int) (Math.random() * lehetosegek.size()));
								t.elkodosit();
							}
						}
						
						publish(tc);
					}else{
						doWork = false;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			return true;
		}
		
		@Override
		protected void done() {
			if(motor.lekerallapot() == 1337)
				mainFrame.gyozelemRajz();
			else
				mainFrame.veresegRajz();
	    }
		
		@Override
		protected void process(List<Integer> chunks) {
			tickCounter = chunks.get(chunks.size()-1);
			ujraRajzol();
		}
	}
	
	public enum Lerakas {
		TORONY, AKADALY, VARAZSKO
	};
	
	public enum VarazskoSzinek {
		SARGA, ZOLD, PIROS, KEK, LILA, LSD
	};
	
	JatekButton aktGomb;
	
	View mainFrame;
	Palya palya;
	Jatekmotor motor;
	Ellensegek ellensegek;
	JosagosSzaruman szaruman;
	Start start;
	int osszletszamAmiResetelunk = 500;
	Lerakas lerakas;
	VarazskoSzinek vkSzinek;
	
	Worker worker;
	boolean doWork;
	
	int tickCounter;
	
	
	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
	}
	
	Controller() {
		mainFrame = new View(this);
		mainFrame.setVisible(true);
		
		mainFrame.menuRajzol();
		this.aktGomb = null;
		this.doWork = false;
		
	}
	
	public void ujJatek() {

		palya = new Palya();
		motor = new Jatekmotor(ellensegek, szaruman, palya);
		palya.init(motor);
		start = palya.getStart(); // TODO 

		szaruman = new JosagosSzaruman(500);
		this.aktGomb = null;
		
		ellensegek = new Ellensegek(motor, 500, start, szaruman);
		
		//Ellensegek(Jatekmotor _jatekmotor, int _osszletszam, Start _kezdohely, JosagosSzaruman _szaruman) {
		

		
		//szaruman = new JosagosSzaruman(1000);
		//ellensegek = new Ellensegek(_jatekmotor, _osszletszam, _kezdohely, _szaruman)
		//motor = new Jatekmotor(_ellensegek, _josagosSzaruman, _palya)        //FIXME kölcsönös kizárás, WTF!!
		
		
		mainFrame.jatekRajzol();
		
		//TESZT ELLENSÉG HOZZÁADÁSA
		try {
			ellensegek.inditEllenseg(1, 1, 10000);
		} catch (Exception e) {
			
		}
		
		this.ujraRajzol();
		
		this.doWork = true;
		this.worker = new Worker();
		this.worker.execute();
	}
	
	public PalyaElem getPalyaElemByXY(int x, int y){
		return palya.getElementByXY(x, y);
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
			this.aktGomb = jbt;
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
			
			if((this.aktGomb != null) && (this.aktGomb.koltseg > varazsero)){
				this.aktGomb = null;
				this.lerakas = null;
				this.vkSzinek = null;
			}
		}
	}
	
	public void mezoKattint(MezoPanel mezo){
		if(this.getLerakas() == null) return;
		PalyaElem pe = this.getPalyaElemByXY(mezo.coord.x, mezo.coord.y);
		
		switch(this.getLerakas()){
			case TORONY:
				if(!pe.vanEpitesiTerulete()) return;
				if(pe.lekerEpitesiTerulet().vanToronyRajta()) return;
				
				pe.lekerEpitesiTerulet().lerakTornyot(0);
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

		this.szaruman.varazseroCsokkent(this.aktGomb.koltseg);
		return;
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case "mezoKattint":
			//TODO mezőre kattintás
			this.mezoKattint((MezoPanel)a.getSource());
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
		case "menuRajzol":
			mainFrame.menuRajzol();
			break;
		case "kilep":
			mainFrame.kilep();
			break;
		}

		this.ujraRajzol();
	}
	
	public void ujraRajzol(){
		this.mainFrame.repaint();
		this.varazseroFeldolgoz();
		
		if(mainFrame.isPlaying){
			JatekPanel jp = (JatekPanel)mainFrame.jelenlegiPanel;
			jp.statusChange();
			jp.mbar.setValue(this.ellensegek.lekerHanyEllensegVanMeg());
			jp.mbar.setToolTipText("Maradék ellenségek száma: "+jp.mbar.getValue());
			
			if(this.aktGomb != null){
				jp.setButtonState(this.aktGomb, JatekButton.ButtonState.SELECTED);
			}
		}
		
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
