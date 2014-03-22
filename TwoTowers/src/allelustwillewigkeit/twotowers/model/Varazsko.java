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
	}

	public void tuzel(Ellenseg celpont) {
		SkeletonController.tabNo();
//		SkeletonController.println("tuzel(celpont)");
		for (Lovedek l : lovedek) {
			celpont.sebezLovedek();
		}
		SkeletonController.tabCsokken();
	}

	public float lekerHatotavSzorzo() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerHatotavSzorzo()");
		SkeletonController.tabCsokken();
		return hatotavSzorzo;
	}

	public float lekerEleteroSzorzo() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerEleteroSzorzo()");
		SkeletonController.tabCsokken();
		return eleteroSzorzo;
	}
}
