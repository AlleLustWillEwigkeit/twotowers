package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Darda extends Lovedek {
	public Darda() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Darda");
		SkeletonController.tabCsokken();
	}

	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezDarda();
		SkeletonController.tabCsokken();
	}
}
