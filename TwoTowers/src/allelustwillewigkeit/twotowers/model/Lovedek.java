package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Lovedek {
	/**
	 * A lövedék konstruktora
	 */
	public Lovedek() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Lovedek");
		SkeletonController.tabCsokken();
	}

	/** void megLo
	 * Meglövi az ellenfelet.
	 * @param Ellenseg kit
	 */
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezLovedek();
		SkeletonController.tabCsokken();
	}
}
