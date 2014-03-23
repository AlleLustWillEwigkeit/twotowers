package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ellensegek {
	public List<Ellenseg> ellenseg = new ArrayList<Ellenseg>();
	public int osszLetszam = 0;
	public JosagosSzaruman josagosSzaruman = null;
	public Jatekmotor jatekMotor = null;
	public Ellensegek ellensegek = null;
	public Start start = null;

	/** Ez ellenségek konstruktora
	 * @param Jatekmotor jm
	 * @param Start st
	 */
	public Ellensegek(Jatekmotor jm, Start st) {
		super();
		
		SkeletonController.tabNo();
		this.start = st;
		this.jatekMotor = jm;
		
		SkeletonController.println("<<create>> Ellensegek");
		SkeletonController.tabCsokken();
	}

	/** void inditEllenseg
	 * Létrehoz annyi ellenségek, amennyit paraméterül kapott.
	 * @param int mennyit
	 */
	public void inditEllenseg(int mennyit) {
		SkeletonController.tabNo();
		for(int i=0; i<mennyit; i++){
			Ember e = new Ember(start,this);
			this.ellenseg.add(e);
		}
		//TODO Imádkozzunk, hogy ez nem fut le. | Dávid: Miért is?
		SkeletonController.tabCsokken();
	}

	/** void egyEllensegMeghalt
	 * Kiszedi a paraméterül kapott ellenséget a listájából. 
	 * Ha elfogyott az összes, akkor szól a játékmotornak, hogy gőzelem van.
	 * 
	 * @param ellenseg
	 */
	public void egyEllensegMeghalt(Ellenseg ellenseg) {
		SkeletonController.tabNo();
		if(this.ellenseg.contains(ellenseg))
			this.ellenseg.remove(ellenseg);
		
		if (SkeletonController.kerdezIH("Elfogyott minden ellenfél?")) 
			this.jatekMotor.gyozelem();
		
		SkeletonController.tabCsokken();
	}

	/** void mindLep
	 * Minden ellenségnek szól, hogy lépjen.
	 */
	public void mindLep() {
		SkeletonController.tabNo();
		for (Ellenseg e : this.ellenseg) {
			e.lep();
		}
		SkeletonController.tabCsokken();
	}
}
