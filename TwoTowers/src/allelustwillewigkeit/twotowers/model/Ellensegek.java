package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ellensegek {
	public List<Ellenseg> ellenseg = new ArrayList<Ellenseg>();
	public int osszLetszam = 0;
	public JosagosSzaruman josagosSzaruman = null;
	public Jatekmotor jatekMotor = null;
	public Ellensegek ellensegek = null;
	public Start start = null;

	public Ellensegek(Jatekmotor jm) {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Akadaly");
		jatekMotor = jm;
		SkeletonController.tabCsokken();
		
	}

	public void inditEllenseg(int mennyit) {
		SkeletonController.tabNo();
		//TODO Imádkozzunk, hogy ez nem fut le.
		SkeletonController.tabCsokken();
	
	}

	public void egyEllensegMeghalt(Ellenseg ellenseg) {
		SkeletonController.tabNo();
//		SkeletonController.println("egyEllensegMeghalt(ellenseg)");
		if (SkeletonController.kerdezIH("Elfogyott minden ellenfél?")) 
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
