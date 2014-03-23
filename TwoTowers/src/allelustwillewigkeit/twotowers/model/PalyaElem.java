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
	 * A pályaelem konstruktora
	 */
	public PalyaElem() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> PalyaElem");
		SkeletonController.tabCsokken();
	}

	/** EpitesiTerulet lekerEpitesiTerulet
	 * Visszatér a rajta lévő építési terület referenciájával
	 * @return EpitesiTerulet
	 */
	public EpitesiTerulet lekerEpitesiTerulet() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.epitesiTerulet;
	}
	
	/** Ut lekerUt
	 * Visszatér a rajta lévő út referenciájával
	 * @return Ut
	 */
	public Ut lekerUt() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.ut;
	}

	/** boolean vanUtja
	 * Igazzal tér vissza, ha van rajta út, különben hamissal.
	 * @return boolean
	 */
	public boolean vanUtja() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (this.ut!=null);
	}
	
	/** boolean vanEpitesiTerulete
	 * Igazzal tér vissza, ha van rajta építési terület, különben hamissal.
	 * @return boolean
	 */
	public boolean vanEpitesiTerulete() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (this.epitesiTerulet!=null);
	}

	/** void beregisztral
	 * Minden szomszédjánál rekurzívan beregisztrálja a paraméterül kapott tornyot, ha
	 * az adott szomszédon van út. Mindezt a megadott hatótávig csinálja.
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
		
		this.beregisztralt = true; //Ne kelljen még egyszer fölöslegesen figyelni őt.
		
		for (PalyaElem pe : szomszedok) {
			pe.beregisztral(torony, tavolsag--);
		}
		
		this.beregisztralt = false; // Takarítás, hogy más is fel tudjon iratkozni hozzá.
		
		SkeletonController.tabCsokken();
	}

	/** void legyelUt
	 * Létrehoz egy utat magára.
	 */
	public void legyelUt() {
		SkeletonController.tabNo();
		this.ut = new Ut();
		SkeletonController.tabCsokken();
	}

	/** void legyelEpitesiTerulet
	 * Létrehoz egy építési területet magára.
	 */
	public void legyelEpitesiTerulet() {
		SkeletonController.tabNo();
		this.epitesiTerulet = new EpitesiTerulet();
		SkeletonController.tabCsokken();
	}

	/** void addSzomszed
	 * Hozzáadja a paraméterül kapott szomszédot, ha még nincs a listában.
	 * @param PalyaElem sz
	 */
	public void addSzomszed(PalyaElem sz) {
		if(!this.szomszedok.contains(sz)){
			this.szomszedok.add(sz);
			sz.addSzomszed(this);
		}
	}
}
