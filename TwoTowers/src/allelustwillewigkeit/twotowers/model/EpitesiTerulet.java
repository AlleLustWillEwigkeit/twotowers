package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class EpitesiTerulet {
	public Torony torony = null;
	public EpitesiTerulet epitesiTerulet = null; // TODO: Dávid: ez minek?
	public PalyaElem palyaElem = null;

	/**
	 * Ez az építési terület konstruktora
	 */
	public EpitesiTerulet() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> EpitesiTerulet");
		SkeletonController.tabCsokken();
	}

	/** PalyaElem minAll
	 * Visszaadja a pályaelemet, amin áll.
	 * @return PalyaElem
	 */
	public PalyaElem minAll() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.palyaElem;
	}

	/** void lerakTornyot
	 * Létrehoz egy új tornyot, és felveszi a referenciáját. 
	 */
	public void lerakTornyot() {
		SkeletonController.tabNo();
		torony = new Torony();
		SkeletonController.tabCsokken();
	}

	/** boolean vanToronyRajta
	 * Igazat ad, ha van rajta torony, különben hamisat
	 * @return boolean
	 */
	public boolean vanToronyRajta() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return (torony != null);
	}

	/** Torony lekerTorony
	 * Visszatér a torony referenciájával.
	 * @return
	 */
	public Torony lekerTorony() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return torony;
	}
}
