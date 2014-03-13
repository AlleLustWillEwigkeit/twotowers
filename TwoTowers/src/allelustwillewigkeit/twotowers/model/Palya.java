package allelustwillewigkeit.twotowers.model;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

import java.util.HashSet;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Palya.
 * 
 * @author baprof
 */
public class Palya {
	/**
	 * Description of the property palyaElem.
	 */
	public HashSet<PalyaElem> palyaElem = new HashSet<PalyaElem>();

	// Start of user code (user defined attributes for Palya)

	// End of user code

	/**
	 * The constructor.
	 */
	public Palya() {
		// Start of user code constructor for Palya)
		super();
		// End of user code
	}

	/**
	 * Description of the method ujPalya.
	 */
	public void ujPalya() {
		// Start of user code for method ujPalya
		SkeletonController.tabNo();
		int i = 3;
		while (i-- != 0) {
			PalyaElem pe = new PalyaElem();
			System.out.println("Mi legyek: Út(u) vagy Építési terület(e)?");
			try {
				int be = System.in.read();
				if (Integer.toString(be).equals("u"))
					pe.legyelUt();
				if (Integer.toString(be).equals("e"))
					pe.legyelEpitesiTerulet();
			} catch (Exception e) {
			}
		}
		SkeletonController.tabCsokken();
		// End of user code
	}

	// Start of user code (user defined methods for Palya)

	// End of user code

}
