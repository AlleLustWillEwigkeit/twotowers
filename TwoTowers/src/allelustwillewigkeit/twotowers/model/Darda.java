package allelustwillewigkeit.twotowers.model;

public class Darda extends Lovedek {
	/**
	 * A darda konstruktora
	 */
	public Darda(int _id) {
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
		kit.sebezDarda();
	}
}
