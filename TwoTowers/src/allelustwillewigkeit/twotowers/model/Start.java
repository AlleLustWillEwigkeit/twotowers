package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

/**
 * Start class
 * Ez az osztaly arra szolgal, hogy megkulonboztessuk a kezdo utat.
 */
public class Start extends Ut {
	/**
	 * A start konstruktora
	 */
	public Start() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Start");
		SkeletonController.tabCsokken();
	}
}
