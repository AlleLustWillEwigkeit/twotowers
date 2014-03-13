package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;
/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * A törp felelőssége, hogy implementáljon bizonyos lövedék által meghívott metódusokat, úton lévő akadály esetén azt lebontsa(és ne haladjon át addig amíg ez nem sikerül), jelezze, hogy rálépett egy adott útszakaszra, tárolja a saját életerejét, jelezze ha elhalálozik, illetve tárolja, hogy mekkora sebzést mér egy akadályra. 
 * 
 * @author baprof
 */
public class Ember extends Ellenseg {
	// Start of user code (user defined attributes for Ember)

	// End of user code

	/**
	 * The constructor.
	 */
	public Ember() {
		// Start of user code constructor for Ember)
		super();
		// End of user code
	}

	/**
	 * Description of the method sebezDarda.
	 */
	public void sebezDarda() {
		// Start of user code for method sebezDarda
		if(SkeletonController.kerdezIH("Ember vagyok. Eltalalt egy Darda. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezTuzgolyo.
	 */
	public void sebezTuzgolyo() {
		// Start of user code for method sebezTuzgolyo
		if(SkeletonController.kerdezIH("Ember vagyok. Eltalalt egy Tuzgolyo. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezSzikla.
	 */
	public void sebezSzikla() {
		// Start of user code for method sebezSzikla
		if(SkeletonController.kerdezIH("Ember vagyok. Eltalalt egy Szikla. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	/**
	 * Description of the method sebezNyil.
	 */
	public void sebezNyil() {
		// Start of user code for method sebezNyil
		if(SkeletonController.kerdezIH("Ember vagyok. Eltalalt egy Nyil. Meghaltam?")){
			ellensegek.egyEllensegMeghalt(this);
		}
		// End of user code
	}

	// Start of user code (user defined methods for Ember)

	// End of user code

}
