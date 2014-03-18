package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Szikla extends Lovedek {
	public Szikla() {
		super();
	}

	@Override
	public void megLo(Ellenseg kit) {
		SkeletonController.tabNo();
		kit.sebezSzikla();
		SkeletonController.tabCsokken();
	}
}
