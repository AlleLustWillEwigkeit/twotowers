package allelustwillewigkeit.twotowers.model;

public class Elf extends Ellenseg {
	/**
	 * A tünde konstruktora
	 * 
	 * @param start
	 * @param ellens
	 */
	public Elf(Ut start, Ellensegek ellens, int szint) throws Exception { // FIXME
		super(start, ellens,szint);
		
		if((szint < 0) || (szint > 5))
			throw new Exception("A szintnek 1, és 5 kozott kelle lennie");
		
		this.varazseroNovel = 10;
		this.eletero = 20 + 10*(szint);
		this.sebzes = 2 + 1*(szint);
		this.sebesseg = this.lepesigIdo = 1;
	}

	/**
	 * void sebezNyil Sebzi magát a megfelelő métrékben
	 */
	@Override
	public void sebezNyil() {
		eletero -= 10;// TODO//FIXME
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezLovedek() {
		eletero -= 8;// TODO//FIXME
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	/**
	 * void sebezTuzgolyo Sebzi magát a megfelelő métrékben
	 */
	@Override
	public void sebezTuzgolyo() {
		eletero -= 5;// TODO//FIXME
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	/**
	 * void sebezDarda Sebzi magát a megfelelő mértékben
	 */
	@Override
	public void sebezDarda() {
		eletero -= 5;// TODO//FIXME
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezSzikla() {
		eletero -= 20;// TODO//FIXME
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public Ellenseg Szetszakit() throws Exception {
		this.eleteroAllit(eletero / 2);
		Ellenseg clone = new Elf(this.ut,this.tar,this.szint);
		clone.eleteroAllit(this.eletero);
		return clone;
	}

}
