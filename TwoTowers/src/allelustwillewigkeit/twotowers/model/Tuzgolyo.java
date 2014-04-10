package allelustwillewigkeit.twotowers.model;


public class Tuzgolyo extends Lovedek {
	/**
	 * A tűzgolyó konstruktora
	 */
	public Tuzgolyo() {
	}

	/**
	 * void megLo Meglövi az ellenfelet.
	 * 
	 * @param Ellenseg
	 *            kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		kit.sebezTuzgolyo();
	}
}
