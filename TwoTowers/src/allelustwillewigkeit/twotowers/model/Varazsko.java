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
	 * Minden lövedékének szól, hogy lője meg a célpontot
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
	 * Visszatér a hatótávszorzóval
	 * @return float
	 */
	public float lekerHatotavSzorzo() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.hatotavSzorzo;
	}
	
	/** float lekerEleteroSzorzo
	 * Visszatér az életerőszorzóval
	 * @return float
	 */
	public float lekerEleteroSzorzo() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.eleteroSzorzo;
	}
}
