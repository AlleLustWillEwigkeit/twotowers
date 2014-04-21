package allelustwillewigkeit.twotowers.model;

public class JosagosSzaruman {
	protected int maxVarazsero = 0;
	protected int varazsero = 0; // TODO //FIXME
	protected Varazsko kivalasztottVarazsko = null;

	/**
	 * A jóságos szarumán konstruktora
	 */
	public JosagosSzaruman(int maxVarazsero) {
		this.varazsero = this.maxVarazsero = maxVarazsero;
	}

	/**
	 * void varazseroNovel Növeli a varázserejét a megadott mértékben
	 * 
	 * @param int mennyivel
	 */
	public void varazseroNovel(int mennyivel) {
		this.varazsero += mennyivel;
		if(this.varazsero > this.maxVarazsero)
			this.varazsero = this.maxVarazsero;
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
	
	public void beallitKivalasztottVarazsko(int VarazskoDictID) throws Exception{
		throw new Exception("Varazskobeallitasra kerult a sor, ami nincs is mar a programban");
}
}