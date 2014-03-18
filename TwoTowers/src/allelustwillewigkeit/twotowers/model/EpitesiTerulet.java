package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class EpitesiTerulet {
	public Torony torony = null;
	public EpitesiTerulet epitesiTerulet = null;
	public PalyaElem palyaElem = null;

	public EpitesiTerulet() {
		super();
	}

	public PalyaElem minAll() {
		SkeletonController.tabNo();
//		SkeletonController.println("minAll()");
		SkeletonController.tabCsokken();
		return new PalyaElem();
	}

	public void lerakTornyot() {
		SkeletonController.tabNo();
//		SkeletonController.println("lerakTornyot()");
		torony = new Torony();
		SkeletonController.tabCsokken();
	}

	public boolean vanToronyRajta() {
		SkeletonController.tabNo();
//		SkeletonController.println("vanToronyRajta()");
		SkeletonController.tabCsokken();
		return true;
	}

	public Torony lekerTorony() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerTorony()");
		SkeletonController.tabCsokken();
		return new Torony();
	}
}
