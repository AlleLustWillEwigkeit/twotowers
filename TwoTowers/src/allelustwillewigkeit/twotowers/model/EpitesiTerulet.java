package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of EpitesiTerulet.
 * 
 * @author baprof
 */
public class EpitesiTerulet {
	/**
	 * Description of the property torony.
	 */
	public Torony torony = null;

	/**
	 * Description of the property epitesiTerulet.
	 */
	public EpitesiTerulet epitesiTerulet = null;

	/**
	 * Description of the property palyaElem.
	 */
	public PalyaElem palyaElem = null;

	// Start of user code (user defined attributes for EpitesiTerulet)

	// End of user code

	/**
	 * The constructor.
	 */
	public EpitesiTerulet() {
		// Start of user code constructor for EpitesiTerulet)
		super();
		// End of user code
	}

	/**
	 * Description of the method minAll.
	 * 
	 * @return
	 */
	public PalyaElem minAll() {
		// Start of user code for method minAll
		SkeletonController.tabNo();
		SkeletonController.println("minAll()");
		SkeletonController.tabCsokken();
		return new PalyaElem();
		// End of user code
	}

	/**
	 * Description of the method lerakTornyot.
	 */
	public void lerakTornyot() {
		// Start of user code for method lerakTornyot
		SkeletonController.tabNo();
		SkeletonController.println("lerakTornyot()");
		torony = new Torony();
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method vanToronyRajta.
	 * 
	 * @return
	 */
	public boolean vanToronyRajta() {
		// Start of user code for method vanToronyRajta
		SkeletonController.tabNo();
		SkeletonController.println("vanToronyRajta()");
		SkeletonController.tabCsokken();
		return true;
		// End of user code
	}

	/**
	 * Description of the method lekerTorony.
	 * 
	 * @return
	 */
	public Torony lekerTorony() {
		// Start of user code for method lekerTorony
		SkeletonController.tabNo();
		SkeletonController.println("lekerTorony()");
		SkeletonController.tabCsokken();
		return new Torony();
		// End of user code
	}

	// Start of user code (user defined methods for EpitesiTerulet)

	// End of user code

}
