package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Tuzgolyo extends Lovedek {
	/**
	 * A tűzgolyó konstruktora
	 */
	public Tuzgolyo() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Tuzgolyo");
		SkeletonController.tabCsokken();
	}

	/** void megLo
	 * Meglövi az ellenfelet.
	 * @param Ellenseg kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezTuzgolyo();
		SkeletonController.tabCsokken();
	}
}
