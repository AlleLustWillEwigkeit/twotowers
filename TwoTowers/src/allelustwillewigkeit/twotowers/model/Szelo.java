package allelustwillewigkeit.twotowers.model;

public class Szelo extends Lovedek {

	public Szelo(int _id) {
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
		kit.sebezSzelo();
	}
}
