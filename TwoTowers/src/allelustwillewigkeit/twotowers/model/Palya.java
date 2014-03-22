package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Palya {
	public ArrayList<PalyaElem> palyaElem = new ArrayList<PalyaElem>();

	public Palya() {
		super();
	}

	//Once a Dummy, always a dummy.
	public void ujPalya() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return;
	}
}
