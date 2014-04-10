package allelustwillewigkeit.twotowers.model;


public class VegzetHegye extends Ut {
	public Jatekmotor jatekmotor = null;

	/**
	 * VégzetHegye konstruktora
	 * 
	 * @param JatekMotor
	 *            jm
	 */
	public VegzetHegye(Jatekmotor jm) {
		super();
		this.jatekmotor = jm;
	}

	/**
	 * void raLep Ez a metódus felüldefiniálja az útét Szól a játékmotornak,
	 * hogy vereség van.
	 * 
	 * @param Ellenseg
	 *            ellenseg
	 */
	@Override
	public void raLep(Ellenseg ellenseg) {
		this.jatekmotor.vereseg();
	}
}
