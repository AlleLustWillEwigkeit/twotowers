package allelustwillewigkeit.twotowers.model;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.HashSet;
// Start of user code (user defined imports)

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

// End of user code

/**
 * Description of Varazsko.
 * 
 * @author baprof
 */
public class Varazsko {
	/**
	 * Description of the property lovedek.
	 */
	public HashSet<Lovedek> lovedek = new HashSet<Lovedek>();

	/**
	 * Description of the property hatotavSzorzo.
	 */
	public float hatotavSzorzo = 0F;

	/**
	 * Description of the property eleteroSzorzo.
	 */
	public float eleteroSzorzo = 0F;

	// Start of user code (user defined attributes for Varazsko)

	// End of user code

	/**
	 * The constructor.
	 */
	public Varazsko() {
		// Start of user code constructor for Varazsko)
		super();
		// End of user code
	}

	/**
	 * Description of the method tuzel.
	 * 
	 * @param celpont
	 */
	public void tuzel(Ellenseg celpont) {
		// Start of user code for method tuzel
		SkeletonController.tabNo();
		SkeletonController.println("tuzel(celpont)");
		for (Lovedek l : lovedek) {
			celpont.sebezLovedek();
		}
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method lekerHatotavSzorzo.
	 * 
	 * @return
	 */
	public float lekerHatotavSzorzo() {
		// Start of user code for method lekerHatotavSzorzo
		SkeletonController.tabNo();
		SkeletonController.println("lekerHatotavSzorzo()");
		SkeletonController.tabCsokken();
		return hatotavSzorzo;
		// End of user code
	}

	/**
	 * Description of the method lekerEleteroSzorzo.
	 * 
	 * @return
	 */
	public float lekerEleteroSzorzo() {
		// Start of user code for method lekerEleteroSzorzo
		SkeletonController.tabNo();
		SkeletonController.println("lekerEleteroSzorzo()");
		SkeletonController.tabCsokken();
		return eleteroSzorzo;
		// End of user code
	}

	// Start of user code (user defined methods for Varazsko)

	// End of user code

}
