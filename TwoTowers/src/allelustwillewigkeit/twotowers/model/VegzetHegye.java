package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class VegzetHegye extends Ut {
	public Jatekmotor jatekmotor = null;

	public VegzetHegye(Jatekmotor jm) {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Akadaly");
		jatekmotor = jm;
		SkeletonController.tabCsokken();
	}
}
