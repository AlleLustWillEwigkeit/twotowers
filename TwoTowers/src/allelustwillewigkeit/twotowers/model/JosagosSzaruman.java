package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class JosagosSzaruman {
	public int varazsero = 0;
	public Varazsko kivalasztottVarazsko = null;

	public JosagosSzaruman() {
		super();
	}

	public void varazseroNovel(int mennyivel) {
		SkeletonController.tabNo();
		varazsero += mennyivel;
		SkeletonController.tabCsokken();
	}

	public Varazsko lekerKivalasztottVarazsko() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerKivalasztottVarazsko");
		SkeletonController.tabCsokken();
		return null;
	}
}
