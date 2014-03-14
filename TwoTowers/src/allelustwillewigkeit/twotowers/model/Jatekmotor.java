package allelustwillewigkeit.twotowers.model;

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public class Jatekmotor {
	public Ellensegek ellensegek = null;
	public Program progrgam = null;
	public Palya palya = null;
	public JosagosSzaruman josagosSzaruman = null;
	public HashSet<Varazsko> kavicsok = new HashSet<Varazsko>();

	public Jatekmotor() {
		super();
	}

	public void tick() {
		SkeletonController.tabNo();
		SkeletonController.println("tick()");
		SkeletonController.tabCsokken();
	}

	public void lerakTornyot(PalyaElem hova) {
		SkeletonController.tabNo();
		SkeletonController.println("lerakTornyot(pe)");
		hova.lekerEpitesiTerulet().lerakTornyot();
		SkeletonController.tabCsokken();
	}

	public void lerakAkadaly(PalyaElem hova) {
		SkeletonController.tabNo();
		SkeletonController.println("lerakAkadaly(pe)");
		Ut u = hova.lekerUt();
		u.lerakAkadaly();
		SkeletonController.tabCsokken();
	}

	public void felkovez(PalyaElem mit) {
		SkeletonController.tabNo();
		SkeletonController.println("felkovez(p)");
		Varazsko v = josagosSzaruman.lekerKivalasztottVarazsko();
		if (mit.vanEpitesiTerulete()) {
			EpitesiTerulet et = mit.lekerEpitesiTerulet();
			if (et.vanToronyRajta()) {
				Torony t = et.lekerTorony();
				t.felkovez(v);
			}
		}
		if (mit.vanUtja()) {
			Ut u = mit.lekerUt();
			if (u.vanAkadalyRajta()) {
				Akadaly a = u.lekerAkadaly();
				a.felkovez(v);
			}
		}
		SkeletonController.tabCsokken();
	}

	public void ujJatek() {
		SkeletonController.tabNo();
		SkeletonController.println("ujJatek()");
		Palya p = new Palya();
		p.ujPalya();
		JosagosSzaruman jsz = new JosagosSzaruman();
		Ellensegek e = new Ellensegek();
		int i = 3;
		while (i-- != 0) {
			tick();
		}
		SkeletonController.tabCsokken();
	}

	public void vereseg() {
		SkeletonController.tabNo();
		SkeletonController.println("vereseg()");
		SkeletonController.tabCsokken();
	}

	public void gyozelem() {
		SkeletonController.tabNo();
		SkeletonController.println("gyozelem()");
		SkeletonController.tabCsokken();
	}
}
