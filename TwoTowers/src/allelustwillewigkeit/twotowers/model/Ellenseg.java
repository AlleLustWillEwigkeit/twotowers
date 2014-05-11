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
	 * Az ellenseg konstruktora
	 * 
	 * @param Ut
	 *            start
	 * @param Ellensegek
	 *            ellens
	 */
	public Ellenseg(Ut start, Ellensegek ellens, int szint, int _id) {
		this.ut = start;
		this.tar = ellens;
		this.szint = szint;
		this.id = _id;
	}

	public abstract Ellenseg Szetszakit() throws Exception;

	/**
	 * abstract void sebezNyil Nyil sebzes
	 */
	public abstract void sebezNyil();

	/**
	 * abstract void sebezSzelo Szelo sebzes
	 */
	public void sebezSzelo() {
		tar.egyEllensegSzetszakit(this);
	}

	/**
	 * abstract void sebezTuzgolyo Tuzgolyo sebzes
	 */
	public abstract void sebezTuzgolyo();

	/**
	 * abstract void sebezDarda Darda sebzes
	 */
	public abstract void sebezDarda();

	/**
	 * abstract void sebezSzikla Szikla sebzes
	 */
	public abstract void sebezSzikla();

	/**
	 * int akadalySebzes Visszater, hogy mennyit sebez az akadalyra.
	 * 
	 * @return int
	 */
	public int akadalySebzes() {
		return sebzes;
	}

	/**
	 * void lep A kovetkezo utra lep, ha tud.
	 */
	public void lep() {
		lepesigIdo--;
		if (lepesigIdo <= 0) {
			lepesigIdo = sebesseg;

			List<Ut> lehetosegek = ut.lekerKovUtak();
			
			Ut kov = this.ut;
			if(lehetosegek.size() > 0){
				kov = lehetosegek.get((int) (Math.random() * lehetosegek.size()));
			}

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
	 * void sebezLovedek Lovedek sebzes
	 */
	public abstract void sebezLovedek();

	/**
	 * void eleteroAllit Beallitja az eleterot, az adott ertekre.
	 * 
	 * @param int mennyire
	 */
	public void eleteroAllit(float mennyire) {
		if (mennyire >= 0)
			this.eletero = mennyire;
	}

	/**
	 * float eleteroLeker Visszater az eleterovel
	 * 
	 * @return float
	 */
	public float eleteroLeker() {
		return this.eletero;
	}

	/**
	 * void beallitUt Beallitja az ut referenciajat az parameterul kapottra.
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
	
	public float lekerEletero() {
		return eletero;
	}

	public Ut lekerut() throws NullPointerException {
		if (ut != null)
			return ut;
		throw new NullPointerException("Nincs utam!");
	}
	
	public abstract String lekerFaj();
}
