package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Ellenseg.
 * 
 * @author baprof
 */
public abstract class Ellenseg {
	/**
	 * Description of the property lepesigIdo.
	 */
	private int lepesigIdo = 0;

	/**
	 * Description of the property sebesseg.
	 */
	private int sebesseg = 0;

	/**
	 * Description of the property eletero.
	 */
	private float eletero = 0F;

	/**
	 * Description of the property .
	 */
	public Ut ut = null;

	/**
	 * Description of the property ellensegek.
	 */
	public Ellensegek ellensegek = null;

	/**
	 * Description of the property sebzes.
	 */
	private int sebzes = 0;

	// Start of user code (user defined attributes for Ellenseg)

	// End of user code

	/**
	 * The constructor.
	 */
	public Ellenseg() {
		// Start of user code constructor for Ellenseg)
		super();
		// End of user code
	}

	/**
	 * Description of the method sebezNyil.
	 */
	public abstract void sebezNyil();

	/**
	 * Description of the method sebezTuzgolyo.
	 */
	public abstract void sebezTuzgolyo();

	/**
	 * Description of the method sebezDarda.
	 */
	public abstract void sebezDarda();

	/**
	 * Description of the method sebezSzikla.
	 */
	public abstract void sebezSzikla();

	/**
	 * Description of the method akadalySebzes.
	 * 
	 * @return
	 */
	public int akadalySebzes() {
		// Start of user code for method akadalySebzes
		int akadalySebzes = 0;
		return akadalySebzes;
		// End of user code
	}

	/**
	 * Description of the method lep.
	 */
	public void lep() {
		// Start of user code for method lep
		SkeletonController.tabNo();
		SkeletonController.println("lep()");
		Ut u = ut.lekerKovUt();
		u.raLep(this);
		u.akadalySebzes(sebzes);
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method sebezLovedek.
	 */
	public void sebezLovedek() {// FIXME itt valami sántit... GD
		// Start of user code for method sebezLovedek
		SkeletonController.tabNo();
		SkeletonController.println("sebezLovedek()");
		int mennyire = 1;
		eleteroAllit(mennyire);
		float ee = eleteroLeker();
		if (ee <= 0) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method eleteroAllit.
	 * 
	 * @param mennyire
	 */
	public void eleteroAllit(int mennyire) {
		// Start of user code for method eleteroAllit
		SkeletonController.tabNo();
		SkeletonController.println("eleteroAllit(mennyire)");
		eletero = mennyire;
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method eleteroLeker.
	 * 
	 * @return
	 */
	public float eleteroLeker() {
		// Start of user code for method eleteroLeker
		SkeletonController.tabNo();
		SkeletonController.println("eleteroLeker()");
		SkeletonController.tabCsokken();
		return eletero;
		// End of user code
	}

	/**
	 * Description of the method beallitUt.
	 * 
	 * @param ut
	 */
	public void beallitUt(Ut ut) {
		// Start of user code for method beallitUt
		// End of user code
	}

	// Start of user code (user defined methods for Ellenseg)

	// End of user code

}