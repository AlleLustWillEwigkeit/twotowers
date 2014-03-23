package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Ut {
	public Akadaly akadaly = null;
	public List<Torony> torony = new ArrayList<Torony>();
	public List<Ut> ut = new ArrayList<Ut>();

	public Ut() {
		super();
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Ut");
		SkeletonController.tabCsokken();
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
		return (akadaly != null);
	}

	public Akadaly lekerAkadaly() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerAkadaly()");
		SkeletonController.tabCsokken();
		return akadaly; 
	}

	public Ut lekerKovUt() {
		SkeletonController.tabNo();
//		SkeletonController.println("lekerKovUt()");
		SkeletonController.tabCsokken();
		return ut.get(0);
	}

	public void beallitKovUt(Ut ut) {
		SkeletonController.tabNo();
//		SkeletonController.println("beallitKovUt(ut)");
		if( !this.ut.contains(ut)){
			this.ut.add(ut);
		}
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
