package allelustwillewigkeit.twotowers.model;
/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.HashSet;
// Start of user code (user defined imports)

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

// End of user code

/**
 * Description of Torony.
 * 
 * @author baprof
 */
public class Torony {
	/**
	 * Description of the property varazsko.
	 */
	public HashSet<Varazsko> varazsko = new HashSet<Varazsko>();

	/**
	 * Description of the property alapHatotav.
	 */
	public int alapHatotav = 0;

	/**
	 * Description of the property epitesiTerulet.
	 */
	public EpitesiTerulet epitesiTerulet = null;

	/**
	 * Description of the property ut.
	 */
	public HashSet<Ut> ut = new HashSet<Ut>();

	// Start of user code (user defined attributes for Torony)

	// End of user code

	/**
	 * The constructor.
	 */
	public Torony() {
		// Start of user code constructor for Torony)
		//super();
		beRegisztralTavonBeluliUtakhoz();
		// End of user code
	}

	/**
	 * Description of the method tuzel.
	 * @param celpont 
	 */
	public void tuzel(Ellenseg celpont) {
		// Start of user code for method tuzel
		SkeletonController.tabNo();
		SkeletonController.println("tuzel(celpont)");
		for(Varazsko v : varazsko){
			v.tuzel(celpont);
		}
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method beRegisztralTavonBeluliUtakhoz.
	 */
	public void beRegisztralTavonBeluliUtakhoz() {
		// Start of user code for method beRegisztralTavonBeluliUtakhoz
		SkeletonController.tabNo();
		SkeletonController.println("beRegisztralTavonBeluliUtakhoz");
		PalyaElem pe = epitesiTerulet.minAll();
		float tavolsag = alapHatotav;
		for(Varazsko v : varazsko){
			tavolsag *= v.lekerHatotavSzorzo(); //FIXME
		}
		pe.beregisztral(this, (int) tavolsag);
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method felkovez.
	 * @param mivel 
	 */
	public void felkovez(Varazsko mivel) {
		// Start of user code for method felkovez
		SkeletonController.tabNo();
		SkeletonController.println("felkovez(v)");
		SkeletonController.tabCsokken();
		// End of user code
	}

	// Start of user code (user defined methods for Torony)

	// End of user code

}
