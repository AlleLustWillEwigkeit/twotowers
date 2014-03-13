package allelustwillewigkeit.twotowers.model;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Jatekmotor.
 * 
 * @author baprof
 */
public class Jatekmotor {
	/**
	 * Description of the property ellensegek.
	 */
	public Ellensegek ellensegek = null;

	/**
	 * Description of the property progrgam.
	 */
	public Program progrgam = null;

	/**
	 * Description of the property palya.
	 */
	public Palya palya = null;

	/**
	 * Description of the property josagosSzaruman.
	 */
	public JosagosSzaruman josagosSzaruman = null;

	/**
	 * Description of the property kavicsok.
	 */
	public HashSet<Varazsko> kavicsok = new HashSet<Varazsko>();

	// Start of user code (user defined attributes for Jatekmotor)

	// End of user code

	/**
	 * The constructor.
	 */
	public Jatekmotor() {
		// Start of user code constructor for Jatekmotor)
		super();
		// End of user code
	}

	/**
	 * Description of the method tick.
	 */
	public void tick() {
		// Start of user code for method tick
		SkeletonController.tabNo();
		SkeletonController.println("tick()");
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method lerakTornyot.
	 * 
	 * @param hova
	 */
	public void lerakTornyot(PalyaElem hova) {
		// Start of user code for method lerakTornyot
		SkeletonController.tabNo();
		SkeletonController.println("lerakTornyot(pe)");
		hova.lekerEpitesiTerulet().lerakTornyot();

		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method lerakAkadaly.
	 * 
	 * @param hova
	 */
	public void lerakAkadaly(PalyaElem hova) {
		// Start of user code for method lerakAkadaly
		SkeletonController.tabNo();
		SkeletonController.println("lerakAkadaly(pe)");
		Ut u = hova.lekerUt();
		u.lerakAkadaly();
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method felkovez.
	 * 
	 * @param mit
	 */
	public void felkovez(PalyaElem mit) {
		// Start of user code for method felkovez
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
		// End of user code
	}

	/**
	 * Description of the method ujJatek.
	 */
	public void ujJatek() {
		// Start of user code for method ujJatek
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
		// End of user code
	}

	/**
	 * Description of the method vereseg.
	 */
	public void vereseg() {
		// Start of user code for method vereseg
		//
		SkeletonController.tabNo();
		SkeletonController.println("vereseg()");
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method gyozelem.
	 */
	public void gyozelem() {
		// Start of user code for method gyozelem
		SkeletonController.tabNo();
		SkeletonController.println("gyozelem()");
		SkeletonController.tabCsokken();
		// End of user code
	}

	// Start of user code (user defined methods for Jatekmotor)

	// End of user code

}
