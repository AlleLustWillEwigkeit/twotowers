package allelustwillewigkeit.twotowers.model;

public class JosagosSzaruman {
	protected int varazsero = 1000; // TODO//FIXME
	protected Varazsko kivalasztottVarazsko = null;

	/**
	 * A jóságos szarumán konstruktora
	 */
	public JosagosSzaruman() {
	}

	/**
	 * void varazseroNovel Növeli a varázserejét a megadott mértékben
	 * 
	 * @param int mennyivel
	 */
	public void varazseroNovel(int mennyivel) {
		this.varazsero += mennyivel;
	}

	/**
	 * Varazsko lekerKivalasztottVarazsko Visszaadja a kiválasztott varászkövet.
	 * Ha nincs, létrehoz egyet.
	 * 
	 * @return Varazsko
	 */
	public Varazsko lekerKivalasztottVarazsko() {
		return this.kivalasztottVarazsko;
	}

	public void beallitKivalasztottVarazsko(Varazsko erre) {
		kivalasztottVarazsko = erre;
	}
}
