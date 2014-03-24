package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Program {
	public Jatekmotor jatekmotor = null;
	public Program program = null;

	/**
	 * A program konstruktora
	 */
	public Program() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Akadaly");
		SkeletonController.tabCsokken();
	}

	/** void ujJatek
	 * uj jatekot indit
	 */
	public void ujJatek() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}

	/** static void main
	 * Itt van a program indulo pontja
	 */
	public static void main() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}
}
