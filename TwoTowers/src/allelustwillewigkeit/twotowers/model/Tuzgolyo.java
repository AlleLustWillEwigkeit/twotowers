package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Tuzgolyo extends Lovedek {
	public Tuzgolyo() {
		super();
	}

	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezTuzgolyo();
		SkeletonController.tabCsokken();
	}
}
