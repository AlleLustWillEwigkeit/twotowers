package allelustwillewigkeit.twotowers.model;

public class Torp extends Ellenseg {
	/**
	 * A torp konstruktora
	 * 
	 * @param start
	 * @param ellens
	 */
	public Torp(Ut start, Ellensegek ellens, int szint, int _id)
			throws Exception { // FIXME
		super(start, ellens, szint, _id);

		if ((szint < 0) || (szint > 5))
			throw new Exception("A szintnek 1, es 5 kozott kelle lennie");

		this.varazseroNovel = 10;
		this.eletero = 20 * (szint + 1);
		this.sebzes = 2 * (szint + 1);
		this.sebesseg = this.lepesigIdo = 1;
	}

	/**
	 * void sebezNyil Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezNyil() {
		eletero -= 10;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezLovedek() {
		eletero -= 10;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	/**
	 * void sebezTuzgolyo Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezTuzgolyo() {
		eletero -= 10;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	/**
	 * void sebezDarda Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezDarda() {
		eletero -= 15;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezSzikla() {
		eletero -= 20;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public Ellenseg Szetszakit() throws Exception {
		this.eleteroAllit(eletero / 2);
		Ellenseg clone = new Torp(this.ut, this.tar, this.szint, this.id + 1);
		clone.eleteroAllit(this.eletero);
		return clone;
	}

	@Override
	public String lekerFaj() {
		return "torp";
	}
}
