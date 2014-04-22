package allelustwillewigkeit.twotowers.model;

public class Tuzgolyo extends Lovedek {
	/**
	 * A tuzgolyo konstruktora
	 */
	public Tuzgolyo(int _id) {
		super(_id);
	}

	/**
	 * void megLo Meglovi az ellenfelet.
	 * 
	 * @param Ellenseg
	 *            kit
	 */
	@Override
	public void megLo(Ellenseg kit) {
		kit.sebezTuzgolyo();
	}
}
