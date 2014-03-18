package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ut {
	public Akadaly akadaly = null;
	public HashSet<Torony> torony = new HashSet<Torony>();
	public List<Ut> ut = new ArrayList<Ut>();

	public Ut() {
		super();
	}

	public void raLep(Ellenseg ellenseg) {
		SkeletonController.tabNo();
//		SkeletonController.println("raLep()");
		for (Torony t : torony) {
			t.tuzel(ellenseg);
		}
		SkeletonController.tabCsokken();
	}

	public void feliratkozik(Torony torony) {
		SkeletonController.tabNo();
//		SkeletonController.println("feliratkozik(t)");
		SkeletonController.tabCsokken();
	}

	public void akadalyomLebomlott() {
	}

	public void lerakAkadaly() {
		SkeletonController.tabNo();
//		SkeletonController.println("lerakAkadaly()");
		akadaly = new Akadaly();
		SkeletonController.tabCsokken();
	}

	public boolean vanAkadalyRajta() {
		SkeletonController.tabNo();
//		SkeletonController.println("vanAkadalyRajta()");
		SkeletonController.tabCsokken();
		return true;
	}

	public Akadaly lekerAkadaly() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerAkadaly()");
		SkeletonController.tabCsokken();
		return new Akadaly(); //TODO NEW??????
	}

	public Ut lekerKovUt() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerKovUt()");
		SkeletonController.tabCsokken();
		return new Ut(); // TODO NEW???????????,,,,,,
	}

	public void beallitKovUt(Ut ut) {
		SkeletonController.tabNo();
//		SkeletonController.println("beallitKovUt(ut)");
		SkeletonController.tabCsokken();
	}

	public void akadalySebzes(int mennyit) {
		SkeletonController.tabNo();
//		SkeletonController.println("akadalySebzes()");
		if (this.vanAkadalyRajta()) 
			lekerAkadaly().sebzodik(mennyit);
		SkeletonController.tabCsokken();
	}
}
