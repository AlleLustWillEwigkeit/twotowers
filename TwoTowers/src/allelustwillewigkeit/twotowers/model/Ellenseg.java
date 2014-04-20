package allelustwillewigkeit.twotowers.model;

import java.util.List;

public abstract class Ellenseg {
	protected int lepesigIdo = 0;
	protected int sebesseg = 0;
	protected float eletero = 0F;
	protected Ut ut = null;
	protected Ellensegek tar = null;
	protected int sebzes = 0;
	protected int varazseroNovel = 0;
	protected int szint = 1;
	protected int id;

	/**
	 * Az ellenség konstruktora
	 * 
	 * @param Ut
	 *            start
	 * @param Ellensegek
	 *            ellens
	 */
	public Ellenseg(Ut start, Ellensegek ellens, int szint) {
		this.ut = start;
		this.tar = ellens;
		this.szint = szint;
		this.id = tar.nextID();
	}

	public abstract Ellenseg Szetszakit() throws Exception;

	/**
	 * abstract void sebezNyil Nyíl sebzés
	 */
	public abstract void sebezNyil();

	/**
	 * abstract void sebezSzelo Szelő sebzés
	 */
	public void sebezSzelo() {
		tar.egyEllensegSzetszakit(this);
	}

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
		if (lepesigIdo <= 0) {
			lepesigIdo = sebesseg;

			List<Ut> lehetosegek = ut.lekerKovUtak();
			Ut kov = lehetosegek
					.get((int) (Math.random() * lehetosegek.size()));

			try {
				kov.lekerAkadaly();
				kov.akadalySebzes(sebzes);
			} catch (NullPointerException ex) {
				this.beallitUt(kov);
			}
			ut.raLep(this);
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
	public void eleteroAllit(float mennyire) {
		if (mennyire >= 0)
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

	public int lekerid() {
		return id;
	}

	public int lekersebesseg() {
		return sebesseg;
	}

	public Ut lekerut() throws NullPointerException {
		if (ut != null)
			return ut;
		throw new NullPointerException("Nincs utam!");
	}
}
