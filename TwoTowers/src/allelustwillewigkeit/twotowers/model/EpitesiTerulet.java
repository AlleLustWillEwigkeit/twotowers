package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class EpitesiTerulet {
	public Torony torony = null;
	public PalyaElem palyaElem = null;

	/**
	 * Ez az epitesi terulet konstruktora
	 */
	public EpitesiTerulet() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> EpitesiTerulet");
		SkeletonController.tabCsokken();
	}

	/** PalyaElem minAll
	 * Visszaadja a palyaelemet, amin all.
	 * @return PalyaElem
	 */
	public PalyaElem minAll() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.palyaElem;
	}

	/** void lerakTornyot
	 * Letrehoz egy uj tornyot, es felveszi a referenciajat. 
	 */
	public void lerakTornyot() {
		SkeletonController.tabNo();
		this.torony = new Torony();
		SkeletonController.tabCsokken();
	}

	/** boolean vanToronyRajta
	 * Igazat ad, ha van rajta torony, kulonben hamisat
	 * @return boolean
	 */
	public boolean vanToronyRajta() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (this.torony != null);
	}

	/** Torony lekerTorony
	 * Visszater a torony referenciajaval.
	 * @return
	 */
	public Torony lekerTorony() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.torony;
	}
}
