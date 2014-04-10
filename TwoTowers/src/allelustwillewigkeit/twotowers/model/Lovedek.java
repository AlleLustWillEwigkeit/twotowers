package allelustwillewigkeit.twotowers.model;

public class Lovedek {
	/**
	 * A lövedék konstruktora
	 */
	public Lovedek() {
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
}
