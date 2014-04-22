package allelustwillewigkeit.twotowers.model;

public class EpitesiTerulet {
	protected Torony torony = null;
	protected PalyaElem palyaElem = null;
	protected int id;

	/**
	 * Ez az epitesi terulet konstruktora
	 */
	public EpitesiTerulet(PalyaElem _palyaElem, int _id) {
		this.palyaElem = _palyaElem;
		this.id = _id;
	}

	/**
	 * PalyaElem minAll Visszaadja a palyaelemet, amin all.
	 * 
	 * @return PalyaElem
	 */
	public PalyaElem minAll() {
		return this.palyaElem;
	}

	/**
	 * void lerakTornyot Letrehoz egy uj tornyot, es felveszi a referenciajat.
	 */
	public void lerakTornyot(int _id) {
		this.torony = new Torony(this, _id);
	}

	/**
	 * boolean vanToronyRajta Igazat ad, ha van rajta torony, kulonben hamisat
	 * 
	 * @return boolean
	 */
	public boolean vanToronyRajta() {
		return (this.torony != null);
	}

	/**
	 * Torony lekerTorony Visszater a torony referenciajaval.
	 * 
	 * @return
	 */
	public Torony lekerTorony() throws NullPointerException {
		if (torony != null)
			return this.torony;
		else
			throw new NullPointerException(
					"Nincs torony az epitesi teruleten! ID:"
							+ palyaElem.lekerID());
	}

	public int lekerID() {
		// TODO Auto-generated method stub
		return id;
	}
}
