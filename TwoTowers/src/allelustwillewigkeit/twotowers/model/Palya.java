package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Palya {
	public ArrayList<PalyaElem> palyaElem = new ArrayList<PalyaElem>();

	/**
	 * A pálya konstruktora
	 */
	public Palya() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Palya");
		SkeletonController.tabCsokken();
	}

	/** void ujPalya
	 * Létrehoz egy pálya összeállítást.
	 */
	public void ujPalya() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}
}
