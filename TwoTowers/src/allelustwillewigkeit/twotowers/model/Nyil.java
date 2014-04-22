package allelustwillewigkeit.twotowers.model;

public class Nyil extends Lovedek {
	/**
	 * A nyil konstruktora
	 */
	public Nyil(int _id) {
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
		kit.sebezNyil();
	}
}
