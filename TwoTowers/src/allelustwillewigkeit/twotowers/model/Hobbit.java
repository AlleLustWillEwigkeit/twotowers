package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;
/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Hobbit.
 * 
 * @author baprof
 */
public class Hobbit extends Ellenseg {
	// Start of user code (user defined attributes for Hobbit)

	// End of user code

	/**
	 * The constructor.
	 */
	public Hobbit() {
		// Start of user code constructor for Hobbit)
		super();
		// End of user code
	}

	/**
	 * Description of the method sebezNyil.
	 */
	public void sebezNyil() {
		// Start of user code for method sebezNyil
		if(SkeletonController.kerdezIH("Hobbit vagyok. Eltalalt egy Nyil. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezSzikla.
	 */
	public void sebezSzikla() {
		// Start of user code for method sebezSzikla
		if(SkeletonController.kerdezIH("Hobbit vagyok. Eltalalt egy Szikla. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezTuzgolyo.
	 */
	public void sebezTuzgolyo() {
		// Start of user code for method sebezTuzgolyo
		if(SkeletonController.kerdezIH("Hobbit vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezDarda.
	 */
	public void sebezDarda() {
		// Start of user code for method sebezDarda
		if(SkeletonController.kerdezIH("Hobbit vagyok. Eltalalt egy Darda. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	// Start of user code (user defined methods for Hobbit)

	// End of user code

}
