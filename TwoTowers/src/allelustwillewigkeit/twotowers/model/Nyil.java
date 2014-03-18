package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Nyil extends Lovedek {
	public Nyil() {
		super();
	}

	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezNyil();
		SkeletonController.tabCsokken();
	}
}
