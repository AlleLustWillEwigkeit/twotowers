package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

/**
 * Start class
 * Ez az osztály arra szolgál, hogy megkülönböztessük a kezdő utat.
 */
public class Start extends Ut {
	public Start() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Start");
		SkeletonController.tabCsokken();
	}
}
