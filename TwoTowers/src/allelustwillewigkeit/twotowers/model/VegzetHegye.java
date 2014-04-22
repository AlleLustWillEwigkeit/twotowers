package allelustwillewigkeit.twotowers.model;

public class VegzetHegye extends Ut {
	public Jatekmotor jatekmotor = null;

	/**
	 * VegzetHegye konstruktora
	 * 
	 * @param JatekMotor
	 *            jm
	 */
	public VegzetHegye(Jatekmotor jm, PalyaElem _palyaelem, int _id) {
		super(_palyaelem, _id);
		this.jatekmotor = jm;
	}

	/**
	 * void raLep Ez a metodus feluldefinialja az utet Szol a jatekmotornak,
	 * hogy vereseg van.
	 * 
	 * @param Ellenseg
	 *            ellenseg
	 */
	@Override
	public void raLep(Ellenseg ellenseg) {
		this.jatekmotor.vereseg();
	}
}
