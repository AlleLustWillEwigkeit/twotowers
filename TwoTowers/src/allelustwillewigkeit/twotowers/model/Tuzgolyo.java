package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Tuzgolyo extends Lovedek {
	public Tuzgolyo() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Tuzgolyo");
		SkeletonController.tabCsokken();
	}

	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezTuzgolyo();
		SkeletonController.tabCsokken();
	}
}
