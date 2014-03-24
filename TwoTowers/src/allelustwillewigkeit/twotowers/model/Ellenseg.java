package allelustwillewigkeit.twotowers.model;

import allelustwillewigkeit.twotowers.skeleton.SkeletonController;

public abstract class Ellenseg {
	private int lepesigIdo = 0;
	private int sebesseg = 0;
	private float eletero = 0F;
	public Ut ut = null;
	public Ellensegek ellensegek = null;
	private int sebzes = 0;

	/** Az ellenseg konstruktora
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
	 * Nyil sebzes
	 */
	public abstract void sebezNyil();
	
	/** abstract void sebezTuzgolyo
	 * Tuzgolyo sebzes
	 */
	public abstract void sebezTuzgolyo();

	/** abstract void sebezDarda
	 * Darda sebzes
	 */
	public abstract void sebezDarda();

	/** abstract void sebezSzikla
	 * Szikla sebzes
	 */
	public abstract void sebezSzikla();

	/** int akadalySebzes
	 * Visszater, hogy mennyit sebez az akadalyra.
	 * @return int
	 */
	public int akadalySebzes() {
		int akadalySebzes = 0;
		return akadalySebzes;
	}

	/** void lep
	 * A kovetkezo utra lep, ha tud.
	 */
	public void lep() {
		SkeletonController.tabNo();

		if(SkeletonController.kerdezIH("Lephetek mar?(H eseten maradok")){ 
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
	 * Lovedek sebzes
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
	 * Beallitja az eleterot, az adott ertekre.
	 * @param int mennyire
	 */
	public void eleteroAllit(int mennyire) {
		SkeletonController.tabNo();
		this.eletero = mennyire;
		SkeletonController.tabCsokken();
	}

	/** float eleteroLeker
	 * Visszater az eleterovel
	 * @return float
	 */
	public float eleteroLeker() {
		SkeletonController.tabNo();
		SkeletonController.tabCsokken();
		return this.eletero;
	}

	/**void beallitUt
	 * Beallitja az ut referenciajat az parameterul kapottra.
	 * @param Ut ut
	 */
	public void beallitUt(Ut ut) {
		SkeletonController.tabNo();
		this.ut = ut;
		SkeletonController.tabCsokken();
	}
}
