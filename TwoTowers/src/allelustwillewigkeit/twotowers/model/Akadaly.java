package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Akadaly {
	public int eletero = 0;
	public HashSet<Varazsko> varazsko = new HashSet<Varazsko>();
	public Ut ut = null;

	public Akadaly() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Akadaly");
		SkeletonController.tabCsokken();
	}

	public void felkovez(Varazsko mivel) {
		SkeletonController.tabNo();
//		SkeletonController.println("felkovez(v)");
		SkeletonController.tabCsokken();
	}

	public void sebzodik(int mennyit) {
		SkeletonController.tabNo();
//		SkeletonController.println("sebzodik(mennyit)");
//		for (Varazsko v : varazsko) {
//			v.lekerEleteroSzorzo();
//		}
		SkeletonController.tabCsokken();
	}
}
