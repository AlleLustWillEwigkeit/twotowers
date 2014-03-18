package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ellensegek {
	public HashSet<Ellenseg> ellenseg = new HashSet<Ellenseg>();
	public int osszLetszam = 0;
	public JosagosSzaruman josagosSzaruman = null;
	public Jatekmotor jatekMotor = null;
	public Ellensegek ellensegek = null;
	public Start start = null;

	public Ellensegek() {
		super();
	}

	public void inditEllenseg(int mennyit) {
		SkeletonController.tabNo();
		//TODO;
		SkeletonController.tabCsokken();
	
	}

	public void egyEllensegMeghalt(Ellenseg ellenseg) {
		SkeletonController.tabNo();
//		SkeletonController.println("egyEllensegMeghalt(ellenseg)");
		if (osszLetszam <= 0) //TODO Nem a kedves felhasználó dönt???????????????????????
			jatekMotor.gyozelem();
		SkeletonController.tabCsokken();
	}

	public void mindLep() {
		SkeletonController.tabNo();
//		SkeletonController.println("mindLep()");
		for (Ellenseg e : ellenseg) {
			e.lep();
		}
		SkeletonController.tabCsokken();
	}
}
