package allelustwillewigkeit.twotowers.model;

public class Torp extends Ellenseg {
	/**
	 * A törp konstruktora
	 * 
	 * @param start
	 * @param ellens
	 */
	public Torp(Ut start, Ellensegek ellens, int szint) throws Exception { // FIXME
		super(start, ellens,szint);
		
		if((szint < 0) || (szint > 5))
			throw new Exception("A szintnek 1, és 5 kozott kelle lennie");

		this.varazseroNovel = 10;
		this.eletero = 20*(szint+1);
		this.sebzes = 2*(szint+1);
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
	 * void sebezDarda Sebzi magát a megfelelő métrékben
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
		Ellenseg clone = new Torp(this.ut,this.tar,this.szint);
		clone.eleteroAllit(this.eletero);
		return clone;
	}
}
