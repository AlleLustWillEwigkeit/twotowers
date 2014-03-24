package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class PalyaElem {
	public EpitesiTerulet epitesiTerulet = null;
	public ArrayList<PalyaElem> szomszedok = new ArrayList<PalyaElem>();
	public PalyaElem palyaElem = null;
	public boolean beregisztralt = false;
	public Ut ut = null;

	/**
	 * A palyaelem konstruktora
	 */
	public PalyaElem() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> PalyaElem");
		SkeletonController.tabCsokken();
	}

	/** EpitesiTerulet lekerEpitesiTerulet
	 * Visszater a rajta levo epitesi terulet referenciajaval
	 * @return EpitesiTerulet
	 */
	public EpitesiTerulet lekerEpitesiTerulet() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.epitesiTerulet;
	}
	
	/** Ut lekerUt
	 * Visszater a rajta levo ut referenciajaval
	 * @return Ut
	 */
	public Ut lekerUt() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.ut;
	}

	/** boolean vanUtja
	 * Igazzal ter vissza, ha van rajta ut, kulonben hamissal.
	 * @return boolean
	 */
	public boolean vanUtja() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (this.ut!=null);
	}
	
	/** boolean vanEpitesiTerulete
	 * Igazzal ter vissza, ha van rajta epitesi terulet, kulonben hamissal.
	 * @return boolean
	 */
	public boolean vanEpitesiTerulete() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (this.epitesiTerulet!=null);
	}

	/** void beregisztral
	 * Minden szomszedjanal rekurzivan beregisztralja a parameterul kapott tornyot, ha
	 * az adott szomszedon van ut. Mindezt a megadott hatotavig csinalja.
	 * @param Torony torony
	 * @param int tavolsag
	 */
	public void beregisztral(Torony torony, int tavolsag) {
		SkeletonController.tabNo();
		
		if(this.beregisztralt)
			return;
		
		if (tavolsag == 0)
			return;
		
		if (this.vanUtja() == true)
			this.lekerUt().feliratkozik(torony);
		
		this.beregisztralt = true; //Ne kelljen meg egyszer foloslegesen figyelni ot.
		
		for (PalyaElem pe : szomszedok) {
			pe.beregisztral(torony, tavolsag--);
		}
		
		this.beregisztralt = false; // Takaritas, hogy mas is fel tudjon iratkozni hozza.
		
		SkeletonController.tabCsokken();
	}

	/** void legyelUt
	 * Letrehoz egy utat magara.
	 */
	public void legyelUt() {
		SkeletonController.tabNo();
		this.ut = new Ut();
		SkeletonController.tabCsokken();
	}

	/** void legyelEpitesiTerulet
	 * Letrehoz egy epitesi teruletet magara.
	 */
	public void legyelEpitesiTerulet() {
		SkeletonController.tabNo();
		this.epitesiTerulet = new EpitesiTerulet();
		SkeletonController.tabCsokken();
	}

	/** void addSzomszed
	 * Hozzaadja a parameterul kapott szomszedot, ha meg nincs a listaban.
	 * @param PalyaElem sz
	 */
	public void addSzomszed(PalyaElem sz) {
		if(!this.szomszedok.contains(sz)){
			this.szomszedok.add(sz);
			sz.addSzomszed(this);
		}
	}
}
