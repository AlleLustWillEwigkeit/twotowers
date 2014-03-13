package allelustwillewigkeit.twotowers.model;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.ArrayList;
import java.util.HashSet;
// Start of user code (user defined imports)

import java.util.List;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

// End of user code

/**
 * Description of Ut.
 * 
 * @author baprof
 */
public class Ut {
	/**
	 * Description of the property akadaly.
	 */
	public Akadaly akadaly = null;

	/**
	 * Description of the property torony.
	 */
	public HashSet<Torony> torony = new HashSet<Torony>();

	/**
	 * Description of the property ut.
	 */
	public List<Ut> ut = new ArrayList<Ut>();

	// Start of user code (user defined attributes for Ut)

	// End of user code

	/**
	 * The constructor.
	 */
	public Ut() {
		// Start of user code constructor for Ut)
		super();
		// End of user code
	}

	/**
	 * Description of the method raLep.
	 * 
	 * @param ellenseg
	 */
	public void raLep(Ellenseg ellenseg) {
		// Start of user code for method raLep
		SkeletonController.tabNo();
		SkeletonController.println("raLep()");
		for (Torony t : torony) {
			t.tuzel(ellenseg);
		}
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method feliratkozik.
	 * 
	 * @param torony
	 */
	public void feliratkozik(Torony torony) {
		// Start of user code for method feliratkozik
		SkeletonController.tabNo();
		SkeletonController.println("feliratkozik(t)");
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method akadalyomLebomlott.
	 */
	public void akadalyomLebomlott() {
		// Start of user code for method akadalyomLebomlott
		// End of user code
	}

	/**
	 * Description of the method lerakAkadaly.
	 */
	public void lerakAkadaly() {
		// Start of user code for method lerakAkadaly
		SkeletonController.tabNo();
		SkeletonController.println("lerakAkadaly()");
		akadaly = new Akadaly();
		SkeletonController.tabCsokken();
		// End of user code
	}

	/**
	 * Description of the method vanAkadalyRajta.
	 * 
	 * @return
	 */
	public boolean vanAkadalyRajta() {
		// Start of user code for method vanAkadalyRajta
		SkeletonController.tabNo();
		SkeletonController.println("vanAkadalyRajta()");
		SkeletonController.tabCsokken();
		return true;
		// End of user code
	}

	/**
	 * Description of the method lekerAkadaly.
	 * 
	 * @return
	 */
	public Akadaly lekerAkadaly() {
		// Start of user code for method lekerAkadaly
		SkeletonController.tabNo();
		SkeletonController.println("lekerAkadaly()");
		SkeletonController.tabCsokken();
		return new Akadaly();
		// End of user code
	}

	/**
	 * Description of the method lekerKovUt.
	 * 
	 * @return
	 */
	public Ut lekerKovUt() {
		// Start of user code for method lekerKovUt
		SkeletonController.tabNo();
		SkeletonController.println("lekerKovUt()");
		SkeletonController.tabCsokken();
		return new Ut();
		// End of user code
	}

	/**
	 * beallitKovUt
	 * 
	 * @param ut
	 */
	public void beallitKovUt(Ut ut) {
		// Start of user code for method beallitKovUt
		SkeletonController.tabNo();
		SkeletonController.println("beallitKovUt(ut)");
		SkeletonController.tabCsokken();
		// End of user code
	}

	// Start of user code (user defined methods for Ut)
	public void akadalySebzes(int mennyit) {
		SkeletonController.tabNo();
		SkeletonController.println("akadalySebzes()");
		if (this.vanAkadalyRajta())
			lekerAkadaly().sebzodik(mennyit);
		SkeletonController.tabCsokken();
	}
	// End of user code

}
