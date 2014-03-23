package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class JosagosSzaruman {
	public int varazsero = 0;
	public Varazsko kivalasztottVarazsko = null;

	/**
	 * A jóságos szarumán konstruktora
	 */
	public JosagosSzaruman() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Josagos Szaruman");
		SkeletonController.tabCsokken();
	}

	/** void varazseroNovel
	 * Növeli a varázserejét a megadott mértékben
	 * @param int mennyivel
	 */
	public void varazseroNovel(int mennyivel) {
		SkeletonController.tabNo();
		this.varazsero += mennyivel;
		SkeletonController.tabCsokken();
	}

	/** Varazsko lekerKivalasztottVarazsko
	 * Visszaadja a kiválasztott varászkövet. Ha nincs, létrehoz egyet.
	 * @return Varazsko
	 */
	public Varazsko lekerKivalasztottVarazsko() {
		SkeletonController.tabNo();
		if(this.kivalasztottVarazsko == null){
			this.kivalasztottVarazsko = new Varazsko();
		}
		SkeletonController.tabCsokken();
		return this.kivalasztottVarazsko;
	}
}
