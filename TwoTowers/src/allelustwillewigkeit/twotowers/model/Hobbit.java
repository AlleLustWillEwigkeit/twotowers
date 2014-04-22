package allelustwillewigkeit.twotowers.model;

public class Hobbit extends Ellenseg {
	/**
	 * A hobbit konstruktora
	 * 
	 * @param start
	 * @param ellens
	 */
	public Hobbit(Ut start, Ellensegek ellens, int szint, int _id)
			throws Exception {
		super(start, ellens, szint, _id);

		if ((szint < 0) || (szint > 5))
			throw new Exception("A szintnek 1, es 5 kozott kell lennie");

		this.varazseroNovel = 10;
		this.eletero = 5 * (szint);
		this.sebesseg = this.lepesigIdo = 1;
		switch (szint) {
		case 1:
		case 2:
		case 3:
			this.sebzes = 1;
			break;
		case 4:
			this.sebzes = 2;
			break;
		case 5:
			this.sebzes = 3;
			break;
		}

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
		eletero -= 20;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	/**
	 * void sebezDarda Sebzi magat a megfelelo metrekben
	 */
	@Override
	public void sebezDarda() {
		eletero -= 10;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public void sebezSzikla() {
		eletero -= 15;
		if (eletero <= 0) {
			tar.egyEllensegMeghalt(this);
		}
	}

	@Override
	public Ellenseg Szetszakit() throws Exception {
		this.eleteroAllit(eletero / 2);
		Ellenseg clone = new Hobbit(this.ut, this.tar, this.szint, this.id + 1);
		clone.eleteroAllit(this.eletero);
		return clone;
	}
}