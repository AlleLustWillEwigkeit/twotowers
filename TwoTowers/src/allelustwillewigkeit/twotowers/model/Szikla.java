package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Szikla extends Lovedek {
	/**
	 * A szikla konstruktora
	 */
	public Szikla() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Szikla");
		SkeletonController.tabCsokken();
	}

	/** void megLo
	 * Meglovi az ellenfelet.
	 * @param Ellenseg kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezSzikla();
		SkeletonController.tabCsokken();
	}
}
