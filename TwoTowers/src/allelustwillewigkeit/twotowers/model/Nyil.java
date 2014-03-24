package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Nyil extends Lovedek {
	/**
	 * A nyil konstruktora
	 */
	public Nyil() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Nyil");
		SkeletonController.tabCsokken();
	}

	/** void megLo
	 * Meglovi az ellenfelet.
	 * @param Ellenseg kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezNyil();
		SkeletonController.tabCsokken();
	}
}
