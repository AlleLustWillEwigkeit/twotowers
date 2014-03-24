package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Torony {
	public HashSet<Varazsko> varazsko = new HashSet<Varazsko>();
	public int alapHatotav = 0;
	public EpitesiTerulet epitesiTerulet = null;
	public HashSet<Ut> ut = new HashSet<Ut>();

	/**
	 * A torony konstruktora
	 */
	public Torony() {
		super();		
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Torony");
		//beRegisztralTavonBeluliUtakhoz();
		SkeletonController.tabCsokken();
	}

	/** void tuzel
	 * Minden varaszkovenek szol, hogy tuzeljen a celpontra
	 * @param Ellenseg celpont
	 */
	public void tuzel(Ellenseg celpont) {
		SkeletonController.tabNo();
		for (Varazsko v : this.varazsko) {
			v.tuzel(celpont);
		}
		SkeletonController.tabCsokken();
	}

	/** void beRegisztralTavonBeluliUtakhoz
	 * Szol az ot tarolo palyaelemnek, hogy beregisztralna az utakhoz, a megfelelo hatotavon.
	 */
	public void beRegisztralTavonBeluliUtakhoz() {
		SkeletonController.tabNo();
		
		PalyaElem pe = epitesiTerulet.minAll();
		float tavolsag = alapHatotav;
		for (Varazsko v : varazsko) {
			tavolsag *= v.lekerHatotavSzorzo();
		}
		pe.beregisztral(this, (int) tavolsag);
		
		SkeletonController.tabCsokken();
	}

	/** void felkovez
	 * Ha meg nincs rajta a parameterul kapott varaszko, akkor felveszi
	 * @param Varazsko mivel
	 */
	public void felkovez(Varazsko mivel) {
		SkeletonController.tabNo();
		
		if(!this.varazsko.contains(mivel))
			this.varazsko.add(mivel);
		
		SkeletonController.tabCsokken();
	}
}
