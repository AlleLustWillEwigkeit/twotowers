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

	/** Ez ellensegek konstruktora
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
	 * Letrehoz annyi ellensegek, amennyit parameterul kapott.
	 * @param int mennyit
	 */
	public void inditEllenseg(int mennyit) {
		SkeletonController.tabNo();
		for(int i=0; i<mennyit; i++){
			Ember e = new Ember(start,this);
			this.ellenseg.add(e);
		}
		SkeletonController.tabCsokken();
	}

	/** void egyEllensegMeghalt
	 * Kiszedi a parameterul kapott ellenseget a listajabol. 
	 * Ha elfogyott az osszes, akkor szol a jatekmotornak, hogy gozelem van.
	 * 
	 * @param ellenseg
	 */
	public void egyEllensegMeghalt(Ellenseg ellenseg) {
		SkeletonController.tabNo();
		if(this.ellenseg.contains(ellenseg))
			this.ellenseg.remove(ellenseg);
		
		if (SkeletonController.kerdezIH("Elfogyott minden ellenfel?")) 
			this.jatekMotor.gyozelem();
		
		SkeletonController.tabCsokken();
	}

	/** void mindLep
	 * Minden ellensegnek szol, hogy lepjen.
	 */
	public void mindLep() {
		SkeletonController.tabNo();
		for (Ellenseg e : this.ellenseg) {
			e.lep();
		}
		SkeletonController.tabCsokken();
	}
}
