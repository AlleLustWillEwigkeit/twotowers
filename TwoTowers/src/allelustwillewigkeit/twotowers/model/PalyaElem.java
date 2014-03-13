package allelustwillewigkeit.twotowers.model;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of PalyaElem.
 * 
 * @author baprof
 */
public class PalyaElem {
	/**
	 * Description of the property epitesiTerulet.
	 */
	public EpitesiTerulet epitesiTerulet = null;

	/**
	 * Description of the property szomszedok.
	 */
	public HashSet<PalyaElem> szomszedok = new HashSet<PalyaElem>();

	/**
	 * Description of the property palyaElem.
	 */
	public PalyaElem palyaElem = null;

	/**
	 * Description of the property beregisztralt.
	 */
	public boolean beregisztralt = false;

	/**
	 * Description of the property ut.
	 */
	public Ut ut = null;

	// Start of user code (user defined attributes for PalyaElem)

	// End of user code

	/**
	 * The constructor.
	 */
	public PalyaElem() {
		// Start of user code constructor for PalyaElem)
		super();
		// End of user code
	}

	/**
	 * Description of the method lekerEpitesiTerulet.
	 * 
	 * @return
	 */
	public EpitesiTerulet lekerEpitesiTerulet() {
		// Start of user code for method lekerEpitesiTerulet
		SkeletonController.tabNo();
		SkeletonController.println("lekerEpitesiTerulet()");
		SkeletonController.tabCsokken();
		return null;
		// End of user code
	}

	/**
	 * Description of the method lekerUt.
	 * 
	 * @return
	 */
	public Ut lekerUt() {
		// Start of user code for method lekerUt
		SkeletonController.tabNo();
		SkeletonController.println("lekerUt()");
		SkeletonController.tabCsokken();
		return null;
		// End of user code
	}

	/**
	 * Description of the method vanUtja.
	 * 
	 * @return
	 */
	public boolean vanUtja() {
		// Start of user code for method vanUtja
		SkeletonController.tabNo();
		SkeletonController.println("vamUtja()");
		SkeletonController.tabCsokken();
		return true;
		// End of user code
	}

	/**
	 * Description of the method vanEpitesiTerulete.
	 * 
	 * @return
	 */
	public boolean vanEpitesiTerulete() {
		// Start of user code for method vanEpitesiTerulete
		SkeletonController.tabNo();
		SkeletonController.println("vanEpitesiTerulete()");
		SkeletonController.tabCsokken();
		return true;
		// End of user code
	}

	/**
	 * Description of the method beregisztral.
	 * 
	 * @param torony
	 * @param tavolsag
	 */
	public void beregisztral(Torony torony, int tavolsag) {
		// Start of user code for method beregisztral
		SkeletonController.tabNo();
		SkeletonController.println("beregisztral(t,n)");
		if(tavolsag == 0) return;
		if(this.vanUtja() == true) this.lekerUt().feliratkozik(torony);
		for(PalyaElem pe : szomszedok){
			pe.beregisztral(torony, tavolsag--);
		}
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method legyelUt.
	 */
	public void legyelUt() {
		// Start of user code for method legyelUt
		SkeletonController.tabNo();
		SkeletonController.println("legyelUt()");
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method legyelEpitesiTerulet.
	 */
	public void legyelEpitesiTerulet() {
		// Start of user code for method legyelEpitesiTerulet
		SkeletonController.tabNo();
		SkeletonController.println("legyelEpitesiTerulet()");
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method addSzomszed.
	 * 
	 * @param
	 */
	public void addSzomszed(PalyaElem sz) {
		// Start of user code for method addSzomszed
		// End of user code
	}

	// Start of user code (user defined methods for PalyaElem)

	// End of user code

}
