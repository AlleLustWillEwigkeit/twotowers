package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class PalyaElem {
	public EpitesiTerulet epitesiTerulet = null;
	public ArrayList<PalyaElem> szomszedok = new ArrayList<PalyaElem>();
	public PalyaElem palyaElem = null;
	public boolean beregisztralt = false;
	public Ut ut = null;

	public PalyaElem() {
		super();
	}

	public EpitesiTerulet lekerEpitesiTerulet() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerEpitesiTerulet()");
		SkeletonController.tabCsokken();
		return epitesiTerulet;
	}

	public Ut lekerUt() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerUt()");
		SkeletonController.tabCsokken();
		return ut;
	}

	public boolean vanUtja() {
		SkeletonController.tabNo();
//		SkeletonController.println("vamUtja()");
		if(ut!=null){
			SkeletonController.tabCsokken();
			return true;
		} else {
			SkeletonController.tabCsokken();
			return false;
		}
	}

	public boolean vanEpitesiTerulete() {
		SkeletonController.tabNo();
//		SkeletonController.println("vanEpitesiTerulete()");
		if(epitesiTerulet!=null){
			SkeletonController.tabCsokken();
			return true;
		} else {
			SkeletonController.tabCsokken();
			return false;
		}
	}

	public void beregisztral(Torony torony, int tavolsag) {
		SkeletonController.tabNo();
//		SkeletonController.println("beregisztral(t,n)");
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
//		SkeletonController.println("legyelUt()");
		Ut rarakando = new Ut();
		this.ut = rarakando;
		SkeletonController.tabCsokken();
	}

	public void legyelEpitesiTerulet() {
		SkeletonController.tabNo();
//		SkeletonController.println("legyelEpitesiTerulet()");
		EpitesiTerulet rarakando = new EpitesiTerulet();
		this.epitesiTerulet = rarakando;
		SkeletonController.tabCsokken();
	}

	public void addSzomszed(PalyaElem sz) {
		if(!szomszedok.contains(sz)){
				szomszedok.add(sz);
				sz.addSzomszed(this);
		}
		
	}
}
