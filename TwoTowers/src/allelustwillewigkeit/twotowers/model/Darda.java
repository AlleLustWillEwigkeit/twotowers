package allelustwillewigkeit.twotowers.model;

public class Darda extends Lovedek {
	/**
	 * A dárda konstruktora
	 */
	public Darda() {
	}

	/**
	 * void megLo Meglövi az ellenfelet.
	 * 
	 * @param Ellenseg
	 *            kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		kit.sebezDarda();
	}
}
