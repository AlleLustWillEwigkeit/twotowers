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
	 * Minden varászkövének szól, hogy tüzeljen a célpontra
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
	 * Szól az őt tároló pályaelemnek, hogy beregisztrálna az utakhoz, a megfelelő hatótávon.
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
	 * Ha még nincs rajta a paraméterül kapott varászkő, akkor felveszi
	 * @param Varazsko mivel
	 */
	public void felkovez(Varazsko mivel) {
		SkeletonController.tabNo();
		
		if(!this.varazsko.contains(mivel))
			this.varazsko.add(mivel);
		
		SkeletonController.tabCsokken();
	}
}
