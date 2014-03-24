package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Lovedek {
	/**
	 * A lovedek konstruktora
	 */
	public Lovedek() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Lovedek");
		SkeletonController.tabCsokken();
	}

	/** void megLo
	 * Meglovi az ellenfelet.
	 * @param Ellenseg kit
	 */
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezLovedek();
		SkeletonController.tabCsokken();
	}
}
