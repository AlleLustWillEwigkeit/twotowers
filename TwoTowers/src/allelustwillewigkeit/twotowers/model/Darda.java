package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Darda extends Lovedek {
	/**
	 * A dárda konstruktora
	 */
	public Darda() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Darda");
		SkeletonController.tabCsokken();
	}

	/** void megLo
	 * Meglövi az ellenfelet.
	 * @param Ellenseg kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezDarda();
		SkeletonController.tabCsokken();
	}
}
