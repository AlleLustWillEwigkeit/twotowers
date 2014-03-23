package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Akadaly {
	public int eletero = 0;
	public HashSet<Varazsko> varazsko = new HashSet<Varazsko>();
	public Ut ut = null;

	/** Az akadály konstruktora
	 * @param Ut u
	 */
	public Akadaly(Ut u) {
		super();
		this.ut = u;
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Akadaly");
		SkeletonController.tabCsokken();
	}

	/** void felkovez
	 * Felveszi a paraméterül kapott varászkő referenciáját
	 * @param Varazsko mivel
	 */
	public void felkovez(Varazsko mivel) {
		SkeletonController.tabNo();
		this.varazsko.add(mivel);
		SkeletonController.tabCsokken();
	}

	/** void sebzodik
	 * Levonja a paraméterül kapott értéket az életerejéből.
	 * @param int mennyit
	 */
	public void sebzodik(int mennyit) {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
	}
}
