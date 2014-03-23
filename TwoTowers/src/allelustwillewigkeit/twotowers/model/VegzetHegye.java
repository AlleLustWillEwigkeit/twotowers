package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class VegzetHegye extends Ut {
	public Jatekmotor jatekmotor = null;

	public VegzetHegye(Jatekmotor jm) {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> VegzetHegye");
		jatekmotor = jm;
		SkeletonController.tabCsokken();
	}
	
	public void raLep(Ellenseg ellenseg) {
		SkeletonController.tabNo();
		//SkeletonController.println("raLep()");
		jatekmotor.vereseg();
		SkeletonController.tabCsokken();
	}
}
