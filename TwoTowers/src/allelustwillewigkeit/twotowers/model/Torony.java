package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Torony implements Varazskovezheto {
	protected List<Varazsko> kovek = new ArrayList<Varazsko>();
	protected int alapHatotav;
	protected int alapTuzGyorsasag;
	protected EpitesiTerulet minAll = null;
	protected List<Ut> kikhezRegisztraltamFel = new ArrayList<Ut>();
	protected int id;

	/**
	 * A torony konstruktora
	 */
	public Torony(EpitesiTerulet _minAll, int _id) {
		this.kovek.add(new Varazsko(0, id * 10));
		this.alapHatotav = 8;
		this.alapTuzGyorsasag = 1;
		this.minAll = _minAll;
		this.beRegisztralTavonBeluliUtakhoz();
		this.id = _id;
	}

	/**
	 * void tuzel Minden varaszkovenek szol, hogy tuzeljen a celpontra
	 * 
	 * @param Ellenseg
	 *            celpont
	 */
	public void tuzel(Ellenseg celpont) {
		if (celpont == null)
			return;

		for (Varazsko v : this.kovek) {
			v.tuzel(celpont);
		}
	}

	/**
	 * void beRegisztralTavonBeluliUtakhoz Szol az ot tarolo palyaelemnek, hogy
	 * beregisztralna az utakhoz, a megfelelo hatotavon.
	 */
	public void beRegisztralTavonBeluliUtakhoz() {// TODO
		kiregisztral();

		PalyaElem pe = minAll.minAll();
		if (alapHatotav <= 0)
			return;

		double hatotav = alapHatotav;
		for (Varazsko v : kovek) {
			hatotav *= v.lekerHatotavSzorzo();
		}

		hatotav = (int) Math.floor(hatotav);

		pe.beregisztral(this, (int) (hatotav--));
	}

	public void utBeregisztralt(Ut u) {
		if (u == null)
			return;

		if (!kikhezRegisztraltamFel.contains(u)) {
			kikhezRegisztraltamFel.add(u);
		}
	}

	/**
	 * void felkovez Ha meg nincs rajta a parameterul kapott varaszko, akkor
	 * felkovezi vele
	 * 
	 * @param Varazsko
	 *            mivel
	 */
	public void felkovez(Varazsko mivel) throws NullPointerException {
		if (mivel == null)
			throw new NullPointerException();

		if (!this.kovek.contains(mivel)) {
			this.kovek.add(mivel);
			mivel.beallitTarolo(this);

			if (mivel.lekerHatotavSzorzo() != 1)
				this.beRegisztralTavonBeluliUtakhoz();
		}
	}

	public void kiregisztral() {
		if (kikhezRegisztraltamFel.size() > 0) {
			Iterator<Ut> it = kikhezRegisztraltamFel.iterator();
			while (it.hasNext()) {
				Ut u = it.next();
				u.leiratkozik(this);
				it.remove();
			}
		}
	}

	public void tick() {
		Iterator<Varazsko> it = kovek.iterator();
		while (it.hasNext()) {
			Varazsko vk = it.next();
			vk.tick();
			if (vk.duration == 0)
				it.remove();
		}
	}

	@Override
	public void lejarVarazsko(Varazsko v) {
		if (!this.kovek.contains(v))
			return;

		this.kovek.remove(v);
	}

	public void elkodosit() {
		kovek.add(new Varazsko(6, id * 10)); // TODO WTF HOGYADJUNK ID_T
	}

	public List<Varazsko> lekerVarazskovek() {
		return kovek;
	}

	public int lekerID() {
		return id;
	}

	public int lekerhatotav() {
		double hatotav = alapHatotav;
		for (Varazsko v : kovek) {
			hatotav *= v.lekerHatotavSzorzo();
		}
		return (int) Math.floor(hatotav);
	}
}
