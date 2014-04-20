package allelustwillewigkeit.twotowers.model;

public class Lovedek {
	int id;

	/**
	 * A lövedék konstruktora
	 */
	public Lovedek(int _id) {
		this.id = _id;
	}

	/**
	 * void megLo Meglövi az ellenfelet.
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
