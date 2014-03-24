package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class JosagosSzaruman {
	public int varazsero = 0;
	public Varazsko kivalasztottVarazsko = null;

	/**
	 * A josagos szaruman konstruktora
	 */
	public JosagosSzaruman() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Josagos Szaruman");
		SkeletonController.tabCsokken();
	}

	/** void varazseroNovel
	 * Noveli a varazserejet a megadott mertekben
	 * @param int mennyivel
	 */
	public void varazseroNovel(int mennyivel) {
		SkeletonController.tabNo();
		this.varazsero += mennyivel;
		SkeletonController.tabCsokken();
	}

	/** Varazsko lekerKivalasztottVarazsko
	 * Visszaadja a kivalasztott varaszkovet. Ha nincs, letrehoz egyet.
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
