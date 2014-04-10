package allelustwillewigkeit.twotowers.model;


public class Szikla extends Lovedek {
	/**
	 * A szikla konstruktora
	 */
	public Szikla() {
	}

	/**
	 * void megLo Meglövi az ellenfelet.
	 * 
	 * @param Ellenseg
	 *            kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		kit.sebezSzikla();
	}
}
