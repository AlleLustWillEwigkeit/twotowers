package allelustwillewigkeit.twotowers.model;

public class EpitesiTerulet {
	protected Torony torony = null;
	protected PalyaElem palyaElem = null;

	/**
	 * Ez az építési terület konstruktora
	 */
	public EpitesiTerulet(PalyaElem _palyaElem) {
		palyaElem = _palyaElem;

	}

	/**
	 * PalyaElem minAll Visszaadja a pályaelemet, amin áll.
	 * 
	 * @return PalyaElem
	 */
	public PalyaElem minAll() {
		return this.palyaElem;
	}

	/**
	 * void lerakTornyot Létrehoz egy új tornyot, és felveszi a referenciáját.
	 */
	public void lerakTornyot() {
		this.torony = new Torony();
	}

	/**
	 * boolean vanToronyRajta Igazat ad, ha van rajta torony, különben hamisat
	 * 
	 * @return boolean
	 */
	public boolean vanToronyRajta() {
		return (this.torony != null);
	}

	/**
	 * Torony lekerTorony Visszatér a torony referenciájával.
	 * 
	 * @return
	 */
	public Torony lekerTorony() throws NullPointerException {
		if (torony != null)
			return this.torony;
		else
			throw new NullPointerException(
					"Nincs torony az építési területen! ID:"
							+ palyaElem.lekerID());
	}
}
