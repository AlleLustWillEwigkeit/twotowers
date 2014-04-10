package allelustwillewigkeit.twotowers.model;

public abstract class Ellenseg {
	protected int lepesigIdo = 0;
	protected int sebesseg = 0;
	protected float eletero = 0F;
	protected Ut ut = null;
	protected Ellensegek tar = null;
	protected int sebzes = 0;

	/**
	 * Az ellenség konstruktora
	 * 
	 * @param Ut
	 *            start
	 * @param Ellensegek
	 *            ellens
	 */
	public Ellenseg(Ut start, Ellensegek ellens) {
		super();
		this.ut = start;
		this.tar = ellens;
	}

	/**
	 * abstract void sebezNyil Nyíl sebzés
	 */
	public abstract void sebezNyil();

	/**
	 * abstract void sebezTuzgolyo Tűzgolyó sebzés
	 */
	public abstract void sebezTuzgolyo();

	/**
	 * abstract void sebezDarda Dárda sebzés
	 */
	public abstract void sebezDarda();

	/**
	 * abstract void sebezSzikla Szikla sebzés
	 */
	public abstract void sebezSzikla();

	/**
	 * int akadalySebzes Visszatér, hogy mennyit sebez az akadályra.
	 * 
	 * @return int
	 */
	public int akadalySebzes() {
		return sebzes;
	}

	/**
	 * void lep A következő útra lép, ha tud.
	 */
	public void lep() {
		lepesigIdo--;
		if (lepesigIdo == 0) {
			Ut kov = ut.lekerKovUtak().get(RANDOM);
			if (kov.lekerAkadaly() == null)
				kov.raLep(this);
			else
				kov.akadalySebzes(sebzes);
		}
	}

	/**
	 * void sebezLovedek Lövedék sebzés
	 */
	public abstract void sebezLovedek();

	/**
	 * void eleteroAllit Beállítja az életerőt, az adott értékre.
	 * 
	 * @param int mennyire
	 */
	public void eleteroAllit(int mennyire) {
		this.eletero = mennyire;
	}

	/**
	 * float eleteroLeker Visszatér az életerővel
	 * 
	 * @return float
	 */
	public float eleteroLeker() {
		return this.eletero;
	}

	/**
	 * void beallitUt Beállítja az út referenciáját az paraméterül kapottra.
	 * 
	 * @param Ut
	 *            ut
	 */
	public void beallitUt(Ut ut) {
		this.ut = ut;
	}
}
