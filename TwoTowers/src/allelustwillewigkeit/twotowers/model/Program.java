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
	 * Új játékot indít
	 */
	public void ujJatek() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}

	/** static void main
	 * Itt van a program induló pontja
	 */
	public static void main() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}
}
