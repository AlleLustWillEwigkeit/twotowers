package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Torony {
	public HashSet<Varazsko> varazsko = new HashSet<Varazsko>();
	public int alapHatotav = 0;
	public EpitesiTerulet epitesiTerulet = null;
	public HashSet<Ut> ut = new HashSet<Ut>();

	public Torony() {
		beRegisztralTavonBeluliUtakhoz();
	}

	public void tuzel(Ellenseg celpont) {
		SkeletonController.tabNo();
		SkeletonController.println("tuzel(celpont)");
		for (Varazsko v : varazsko) {
			v.tuzel(celpont);
		}
		SkeletonController.tabCsokken();
	}

	public void beRegisztralTavonBeluliUtakhoz() {
		SkeletonController.tabNo();
		SkeletonController.println("beRegisztralTavonBeluliUtakhoz");
		PalyaElem pe = epitesiTerulet.minAll();
		float tavolsag = alapHatotav;
		for (Varazsko v : varazsko) {
			tavolsag *= v.lekerHatotavSzorzo();
		}
		pe.beregisztral(this, (int) tavolsag);
		SkeletonController.tabCsokken();
	}

	public void felkovez(Varazsko mivel) {
		SkeletonController.tabNo();
		SkeletonController.println("felkovez(v)");
		SkeletonController.tabCsokken();
	}
}
