package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Varazsko {
	public List<Lovedek> lovedek = new ArrayList<Lovedek>();
	public float hatotavSzorzo = 0F;
	public float eleteroSzorzo = 0F;

	public Varazsko() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Varazsko");
		SkeletonController.tabCsokken();
	}

	/** void tuzel
	 * Minden lovedekenek szol, hogy loje meg a celpontot
	 * @param Ellenseg celpont
	 */
	public void tuzel(Ellenseg celpont) {
		SkeletonController.tabNo();
		for (Lovedek l : this.lovedek) {
			l.megLo(celpont);
		}
		SkeletonController.tabCsokken();
	}

	/** float lekerHatotavSzorzo
	 * Visszater a hatotavszorzoval
	 * @return float
	 */
	public float lekerHatotavSzorzo() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.hatotavSzorzo;
	}
	
	/** float lekerEleteroSzorzo
	 * Visszater az eleteroszorzoval
	 * @return float
	 */
	public float lekerEleteroSzorzo() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.eleteroSzorzo;
	}
}
