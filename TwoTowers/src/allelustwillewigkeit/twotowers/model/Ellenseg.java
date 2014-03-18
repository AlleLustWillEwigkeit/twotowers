package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public abstract class Ellenseg {
	private int lepesigIdo = 0;
	private int sebesseg = 0;
	private float eletero = 0F;
	public Ut ut = null;
	public Ellensegek ellensegek = null;
	private int sebzes = 0;

	public Ellenseg() {
		super();
	}

	public abstract void sebezNyil();

	public abstract void sebezTuzgolyo();

	public abstract void sebezDarda();

	public abstract void sebezSzikla();

	public int akadalySebzes() {
		int akadalySebzes = 0;
		return akadalySebzes;
	}

	public void lep() { //TODO döntés hogy a kövire lépjünk az hol a picsában van?
		SkeletonController.tabNo();
//		SkeletonController.println("lep()");
		Ut u = ut.lekerKovUt();
		u.raLep(this);
		u.akadalySebzes(sebzes);
		SkeletonController.tabCsokken();
	}

	public void sebezLovedek() { 
		SkeletonController.tabNo();
//		SkeletonController.println("sebezLovedek()");
		int mennyire = 1;
		eleteroAllit(mennyire);
		float ee = eleteroLeker();
		if (ee <= 0) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	public void eleteroAllit(int mennyire) {
		SkeletonController.tabNo();
//		SkeletonController.println("eleteroAllit(mennyire)");
		eletero = mennyire;
		SkeletonController.tabCsokken();
	}

	public float eleteroLeker() {
		SkeletonController.tabNo();
//		SkeletonController.println("eleteroLeker()");
		SkeletonController.tabCsokken();
		return eletero;
	}

	public void beallitUt(Ut ut) {
	}
}
