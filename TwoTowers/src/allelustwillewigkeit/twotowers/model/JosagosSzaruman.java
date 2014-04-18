package allelustwillewigkeit.twotowers.model;

public class JosagosSzaruman {
	protected int maxVarazsero = 0;
	protected int varazsero = 0; // TODO//FIXME
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
	
	public void beallitKivalasztottVarazsko(int VarazskoDictID){
		switch(VarazskoDictID){
			case 0:
				this.kivalasztottVarazsko = new Varazsko(1,1,-1);
				this.kivalasztottVarazsko.hozzaadLovedek(new Lovedek());
				break;
			case 1:
				this.kivalasztottVarazsko = new Varazsko(1.5f,1.5f,-1);
				this.kivalasztottVarazsko.hozzaadLovedek(new Nyil());
				break;
			case 2:
				this.kivalasztottVarazsko = new Varazsko(2,1.1f,-1);
				this.kivalasztottVarazsko.hozzaadLovedek(new Darda());
				break;
			case 3:
				this.kivalasztottVarazsko = new Varazsko(2,2,-1);
				this.kivalasztottVarazsko.hozzaadLovedek(new Tuzgolyo());
				break;
			case 4:
				this.kivalasztottVarazsko = new Varazsko(2,0.8f,-1);
				this.kivalasztottVarazsko.hozzaadLovedek(new Szikla());
				break;
			case 5:
				this.kivalasztottVarazsko = new Varazsko(2,0.5f,-1);
				this.kivalasztottVarazsko.hozzaadLovedek(new Szelo());
				break;
			case 6:
				this.kivalasztottVarazsko = new Varazsko(0.5f,1,10);
				break;
		}
	}
}
