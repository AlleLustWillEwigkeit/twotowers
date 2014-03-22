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
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Ellenseg");
		SkeletonController.tabCsokken();
	}

	public abstract void sebezNyil();

	public abstract void sebezTuzgolyo();

	public abstract void sebezDarda();

	public abstract void sebezSzikla();

	public int akadalySebzes() {
		int akadalySebzes = 0;
		return akadalySebzes;
	}

	public void lep() {
		SkeletonController.tabNo();
//		SkeletonController.println("lep()");

		if(SkeletonController.kerdezIH("Léphetek már?(H esetén maradok")){
			Ut next = ut.lekerKovUt();
			this.ut = next;
			next.raLep(this);
			next.akadalySebzes(sebzes);
		} else {
			this.ut.raLep(this);
			this.ut.akadalySebzes(sebzes);
		}
		
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
