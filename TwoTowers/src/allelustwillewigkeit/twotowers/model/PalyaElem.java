package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class PalyaElem {
	public EpitesiTerulet epitesiTerulet = null;
	public HashSet<PalyaElem> szomszedok = new HashSet<PalyaElem>();
	public PalyaElem palyaElem = null;
	public boolean beregisztralt = false;
	public Ut ut = null;

	public PalyaElem() {
		super();
	}

	public EpitesiTerulet lekerEpitesiTerulet() {
		SkeletonController.tabNo();
		SkeletonController.println("lekerEpitesiTerulet()");
		SkeletonController.tabCsokken();
		return null;
	}

	public Ut lekerUt() {
		SkeletonController.tabNo();
		SkeletonController.println("lekerUt()");
		SkeletonController.tabCsokken();
		return null;
	}

	public boolean vanUtja() {
		SkeletonController.tabNo();
		SkeletonController.println("vamUtja()");
		SkeletonController.tabCsokken();
		return true;
	}

	public boolean vanEpitesiTerulete() {
		SkeletonController.tabNo();
		SkeletonController.println("vanEpitesiTerulete()");
		SkeletonController.tabCsokken();
		return true;
	}

	public void beregisztral(Torony torony, int tavolsag) {
		SkeletonController.tabNo();
		SkeletonController.println("beregisztral(t,n)");
		if (tavolsag == 0)
			return;
		if (this.vanUtja() == true)
			this.lekerUt().feliratkozik(torony);
		for (PalyaElem pe : szomszedok) {
			pe.beregisztral(torony, tavolsag--);
		}
		SkeletonController.tabCsokken();
	}

	public void legyelUt() {
		SkeletonController.tabNo();
		SkeletonController.println("legyelUt()");
		SkeletonController.tabCsokken();
	}

	public void legyelEpitesiTerulet() {
		SkeletonController.tabNo();
		SkeletonController.println("legyelEpitesiTerulet()");
		SkeletonController.tabCsokken();
	}

	public void addSzomszed(PalyaElem sz) {
	}
}
