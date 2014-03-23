package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class VegzetHegye extends Ut {
	public Jatekmotor jatekmotor = null;

	/** VégzetHegye konstruktora
	 * @param JatekMotor jm
	 */
	public VegzetHegye(Jatekmotor jm) {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> VegzetHegye");
		this.jatekmotor = jm;
		SkeletonController.tabCsokken();
	}
	
	/** void raLep
	 * Ez a metódus felüldefiniálja az útét
	 * Szól a játékmotornak, hogy vereség van.
	 * 
	 * @param Ellenseg ellenseg
	 */
	@Override
	public void raLep(Ellenseg ellenseg) {
		SkeletonController.tabNo();
		this.jatekmotor.vereseg();
		SkeletonController.tabCsokken();
	}
}
