package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Lovedek {
	public Lovedek() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Lovedek");
		SkeletonController.tabCsokken();
	}

	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezLovedek();
		SkeletonController.tabCsokken();
	}
}
