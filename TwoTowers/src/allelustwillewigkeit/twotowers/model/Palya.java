package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Palya {
	public ArrayList<PalyaElem> palyaElem = new ArrayList<PalyaElem>();

	/**
	 * A palya konstruktora
	 */
	public Palya() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Palya");
		SkeletonController.tabCsokken();
	}

	/** void ujPalya
	 * Letrehoz egy palya osszeallitast.
	 */
	public void ujPalya() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}
}
