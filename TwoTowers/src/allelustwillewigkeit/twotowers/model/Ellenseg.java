package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public abstract class Ellenseg {
	private int lepesigIdo = 0;
	private int sebesseg = 0;
	private float eletero = 0F;
	public Ut ut = null;
	public Ellensegek ellensegek = null;
	private int sebzes = 0;

	/** Az ellenség konstruktora
	 * @param Ut start
	 * @param Ellensegek ellens
	 */
	public Ellenseg(Ut start, Ellensegek ellens) {
		super();
		this.ut=start;
		this.ellensegek = ellens;
		SkeletonController.tabNo();
		SkeletonController.println("<<create>> Ellenseg");
		SkeletonController.tabCsokken();
	}

	/** abstract void sebezNyil
	 * Nyíl sebzés
	 */
	public abstract void sebezNyil();
	
	/** abstract void sebezTuzgolyo
	 * Tűzgolyó sebzés
	 */
	public abstract void sebezTuzgolyo();

	/** abstract void sebezDarda
	 * Dárda sebzés
	 */
	public abstract void sebezDarda();

	/** abstract void sebezSzikla
	 * Szikla sebzés
	 */
	public abstract void sebezSzikla();

	/** int akadalySebzes
	 * Visszatér, hogy mennyit sebez az akadályra.
	 * @return int
	 */
	public int akadalySebzes() {
		int akadalySebzes = 0;
		return akadalySebzes;
	}

	/** void lep
	 * A következő útra lép, ha tud.
	 */
	public void lep() {
		SkeletonController.tabNo();

		if(SkeletonController.kerdezIH("Léphetek már?(H esetén maradok")){ 
			this.ut = this.ut.lekerKovUt();
			this.ut.raLep(this);
			this.ut.akadalySebzes(sebzes);
		} else {
			this.ut.raLep(this);
			this.ut.akadalySebzes(sebzes);
		}
		
		SkeletonController.tabCsokken();
	}

	/** void sebezLovedek
	 * Lövedék sebzés
	 */
	public void sebezLovedek() { 
		SkeletonController.tabNo();
		int mennyire = 1;
		eleteroAllit(mennyire);
		float ee = eleteroLeker();
		if (ee <= 0) {
			ellensegek.egyEllensegMeghalt(this);
		}
		SkeletonController.tabCsokken();
	}

	/** void eleteroAllit
	 * Beállítja az életerőt, az adott értékre.
	 * @param int mennyire
	 */
	public void eleteroAllit(int mennyire) {
		SkeletonController.tabNo();
		this.eletero = mennyire;
		SkeletonController.tabCsokken();
	}

	/** float eleteroLeker
	 * Visszatér az életerővel
	 * @return float
	 */
	public float eleteroLeker() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.eletero;
	}

	/**void beallitUt
	 * Beállítja az út referenciáját az paraméterül kapottra.
	 * @param Ut ut
	 */
	public void beallitUt(Ut ut) {
		SkeletonController.tabNo();
		this.ut = ut;
		SkeletonController.tabCsokken();
	}
}
