package allelustwillewigkeit.twotowers.model;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.HashSet;
// Start of user code (user defined imports)

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

// End of user code

/**
 * Description of Ellensegek.
 * 
 * @author baprof
 */
public class Ellensegek {
	/**
	 * Description of the property ellenseg.
	 */
	public HashSet<Ellenseg> ellenseg = new HashSet<Ellenseg>();

	/**
	 * Description of the property osszLetszam.
	 */
	public int osszLetszam = 0;

	/**
	 * Description of the property josagosSzaruman.
	 */
	public JosagosSzaruman josagosSzaruman = null;

	public Jatekmotor jatekMotor = null;

	/**
	 * Description of the property ellensegek.
	 */
	public Ellensegek ellensegek = null;

	/**
	 * Description of the property start.
	 */
	public Start start = null;

	// Start of user code (user defined attributes for Ellensegek)

	// End of user code

	/**
	 * The constructor.
	 */
	public Ellensegek() {
		// Start of user code constructor for Ellensegek)
		super();
		// End of user code
	}

	/**
	 * Description of the method inditEllenseg.
	 * 
	 * @param mennyit
	 */
	public void inditEllenseg(int mennyit) {
		// Start of user code for method inditEllenseg
		// End of user code
	}

	/**
	 * Description of the method egyEllensegMeghalt.
	 * 
	 * @param ellenseg
	 */
	public void egyEllensegMeghalt(Ellenseg ellenseg) {
		// Start of user code for method egyEllensegMeghalt
		SkeletonController.tabNo();
		SkeletonController.println("egyEllensegMeghalt(ellenseg)");
		if (osszLetszam <= 0)
			jatekMotor.gyozelem();
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method mindLep.
	 */
	public void mindLep() {
		// Start of user code for method mindLep
		SkeletonController.tabNo();
		SkeletonController.println("mindLep()");
		for (Ellenseg e : ellenseg) {
			e.lep();
		}
		SkeletonController.tabCsokken();
		// End of user code
	}

	// Start of user code (user defined methods for Ellensegek)

	// End of user code

}
