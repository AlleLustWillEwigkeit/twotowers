package allelustwillewigkeit.twotowers.model;


public class Nyil extends Lovedek {
	/**
	 * A nyíl konstruktora
	 */
	public Nyil() {
	}

	/**
	 * void megLo Meglövi az ellenfelet.
	 * 
	 * @param Ellenseg
	 *            kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		kit.sebezNyil();
	}
}
