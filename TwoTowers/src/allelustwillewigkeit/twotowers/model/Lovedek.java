package allelustwillewigkeit.twotowers.model;

public class Lovedek {
	int id;

	/**
	 * A lovedek konstruktora
	 */
	public Lovedek(int _id) {
		this.id = _id;
	}

	/**
	 * void megLo Meglovi az ellenfelet.
	 * 
	 * @param Ellenseg
	 *            kit
	 */
	public void megLo(Ellenseg kit) {
		kit.sebezLovedek();
	}

	public int lekerID() {
		return id;
	}
}
