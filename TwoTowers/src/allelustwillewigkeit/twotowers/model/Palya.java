package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Palya {
	public HashSet<PalyaElem> palyaElem = new HashSet<PalyaElem>();

	public Palya() {
		super();
	}

	public void ujPalya() {
		SkeletonController.tabNo();
		int i = 3;
		while (i-- != 0) {
			PalyaElem pe = new PalyaElem();
			System.out
					.println("Mi legyek: Út(u) vagy Építési terület(e)?"); //TODO erre van már finomabb megoldás.
			try {
				int be = System.in.read();
				if (Integer.toString(be).equals("u"))
					pe.legyelUt();
				if (Integer.toString(be).equals("e"))
					pe.legyelEpitesiTerulet();
			} catch (Exception e) {
			}
		}
		SkeletonController.tabCsokken();
	}
}
