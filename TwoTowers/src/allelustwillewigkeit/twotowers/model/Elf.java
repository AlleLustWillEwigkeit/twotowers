package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Elf.
 * 
 * @author baprof
 */
public class Elf extends Ellenseg {
	// Start of user code (user defined attributes for Elf)

	// End of user code

	/**
	 * The constructor.
	 */
	public Elf() {
		// Start of user code constructor for Elf)
		super();
		// End of user code
	}

	/**
	 * Description of the method sebezNyil.
	 */
	public void sebezNyil() {
		// Start of user code for method sebezNyil
		if(SkeletonController.kerdezIH("Tunde vagyok. Eltalalt egy Nyil. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezTuzgolyo.
	 */
	public void sebezTuzgolyo() {
		// Start of user code for method sebezTuzgolyo
		if(SkeletonController.kerdezIH("Tunde vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezDarda.
	 */
	public void sebezDarda() {
		// Start of user code for method sebezDarda
		if(SkeletonController.kerdezIH("Tunde vagyok. Eltalalt egy Darda. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezSzikla.
	 */
	public void sebezSzikla() {
		// Start of user code for method sebezSzikla
		if(SkeletonController.kerdezIH("Tunde vagyok. Eltalalt egy Szikla. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	// Start of user code (user defined methods for Elf)

	// End of user code

}
