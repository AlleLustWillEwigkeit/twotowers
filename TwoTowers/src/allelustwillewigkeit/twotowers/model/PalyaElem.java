package allelustwillewigkeit.twotowers.model;
/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of PalyaElem.
 * 
 * @author baprof
 */
public class PalyaElem {
	/**
	 * Description of the property palyaElem.
	 */
	public PalyaElem palyaElem = null;

	/**
	 * Description of the property ut.
	 */
	public Ut ut = null;

	/**
	 * Description of the property epitesiTerulet.
	 */
	public EpitesiTerulet epitesiTerulet = null;

	/**
	 * Description of the property szomszedok.
	 */
	public HashSet<PalyaElem> szomszedok = new HashSet<PalyaElem>();

	/**
	 * Description of the property beregisztralt.
	 */
	public boolean beregisztralt = false;

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
	 * @return 
	 */
	public EpitesiTerulet lekerEpitesiTerulet() {
		// Start of user code for method lekerEpitesiTerulet
		EpitesiTerulet lekerEpitesiTerulet = null;
		return lekerEpitesiTerulet;
		// End of user code
	}

	/**
	 * Description of the method lekerUt.
	 * @return 
	 */
	public Ut lekerUt() {
		// Start of user code for method lekerUt
		Ut lekerUt = null;
		return lekerUt;
		// End of user code
	}

	/**
	 * Description of the method vanUtja.
	 * @return 
	 */
	public boolean vanUtja() {
		// Start of user code for method vanUtja
		boolean vanUtja = false;
		return vanUtja;
		// End of user code
	}

	/**
	 * Description of the method vanEpitesiTerulete.
	 * @return 
	 */
	public boolean vanEpitesiTerulete() {
		// Start of user code for method vanEpitesiTerulete
		boolean vanEpitesiTerulete = false;
		return vanEpitesiTerulete;
		// End of user code
	}

	/**
	 * Description of the method beregisztral.
	 * @param torony 
	 * @param tavolsag 
	 */
	public void beregisztral(Torony torony, int tavolsag) {
		// Start of user code for method beregisztral
		// End of user code
	}

	/**
	 * Description of the method legyelUt.
	 */
	public void legyelUt() {
		// Start of user code for method legyelUt
		// End of user code
	}

	/**
	 * Description of the method legyelEpitesiTerulet.
	 */
	public void legyelEpitesiTerulet() {
		// Start of user code for method legyelEpitesiTerulet
		// End of user code
	}

	// Start of user code (user defined methods for PalyaElem)

	// End of user code

}
