package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Darda extends Lovedek {
	public Darda() {
		super();
	}

	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezDarda();
		SkeletonController.tabCsokken();
	}
}
