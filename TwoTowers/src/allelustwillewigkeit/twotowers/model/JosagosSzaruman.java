package allelustwillewigkeit.twotowers.model;

public class JosagosSzaruman {
	protected int maxVarazsero = 0;
	protected int varazsero = 0; // TODO //FIXME
	protected Varazsko kivalasztottVarazsko = null;

	/**
	 * A josagos szaruman konstruktora
	 */
	public JosagosSzaruman(int maxVarazsero) {
		this.varazsero = this.maxVarazsero = maxVarazsero;
	}

	/**
	 * void varazseroNovel Noveli a varazserejet a megadott mertekben
	 * 
	 * @param int mennyivel
	 */
	public void varazseroNovel(int mennyivel) {
		this.varazsero += mennyivel;
		if (this.varazsero > this.maxVarazsero)
			this.varazsero = this.maxVarazsero;
	}
	
	public void varazseroCsokkent(int mennyivel){
		this.varazsero -= mennyivel;
		if (this.varazsero < 0)
			this.varazsero = 0;
	}
	
	public int lekerVarazsero(){
		return this.varazsero;
	}

	/**
	 * Varazsko lekerKivalasztottVarazsko Visszaadja a kivalasztott varaszkovet.
	 * Ha nincs, letrehoz egyet.
	 * 
	 * @return Varazsko
	 */
	public Varazsko lekerKivalasztottVarazsko() {
		return this.kivalasztottVarazsko;
	}
	
	public int lekerMaxVarazsero() {
		return maxVarazsero;
	}

	public void beallitKivalasztottVarazsko(Varazsko erre) {
		kivalasztottVarazsko = erre;
	}

	public void beallitKivalasztottVarazsko(int VarazskoDictID)
			throws Exception {
		throw new Exception(
				"Varazskobeallitasra kerult a sor, ami nincs is mar a programban");
	}
}