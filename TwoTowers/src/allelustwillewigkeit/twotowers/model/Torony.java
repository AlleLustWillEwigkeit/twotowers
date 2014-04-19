package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Torony implements Varazskovezheto{
	protected List<Varazsko> kovek = new ArrayList<Varazsko>();
	public int alapHatotav;
	protected EpitesiTerulet minAll = null;
	protected List<Ut> kikhezRegisztraltamFel = new ArrayList<Ut>();

	/**
	 * A torony konstruktora
	 */
	public Torony() {
		alapHatotav = 5;
		this.beRegisztralTavonBeluliUtakhoz();
	}

	/**
	 * void tuzel Minden varászkövének szól, hogy tüzeljen a célpontra
	 * 
	 * @param Ellenseg
	 *            celpont
	 */
	public void tuzel(Ellenseg celpont) {
		if(celpont == null)
			return;
		
		for (Varazsko v : this.kovek) {
			v.tuzel(celpont);
		}
	}

	/**
	 * void beRegisztralTavonBeluliUtakhoz Szól az őt tároló pályaelemnek, hogy
	 * beregisztrálna az utakhoz, a megfelelő hatótávon.
	 */
	public void beRegisztralTavonBeluliUtakhoz() {// TODO
		kiregisztral();
		
		PalyaElem pe = minAll.minAll();
		if (alapHatotav <= 0)
			return;
		
		float hatotav = alapHatotav;
		for (Varazsko v : kovek) {
			hatotav *= v.lekerHatotavSzorzo();
		}
		
		hatotav = (int)Math.floor(hatotav);
		
		pe.beregisztral(this, (int)(hatotav--));
	}
	
	public void utBeregisztralt(Ut u){
		if(u == null) return;
		
		if(!kikhezRegisztraltamFel.contains(u)){
			kikhezRegisztraltamFel.add(u);
		}
	}

	/**
	 * void felkovez Ha még nincs rajta a paraméterül kapott varászkő, akkor
	 * felkövezi vele
	 * 
	 * @param Varazsko
	 *            mivel
	 */
	public void felkovez(Varazsko mivel) throws NullPointerException  {
		if(mivel == null)
			throw new NullPointerException();
		
		if (!this.kovek.contains(mivel)){
			this.kovek.add(mivel);
			mivel.beallitTarolo(this);
			
			if(mivel.lekerHatotavSzorzo() != 1)
				this.beRegisztralTavonBeluliUtakhoz();
		}
	}

	public void kiregisztral() {
		if(kikhezRegisztraltamFel.size() > 0){
			for(Ut u:kikhezRegisztraltamFel){
				u.leiratkozik(this);
				kikhezRegisztraltamFel.remove(u);
			}
		}
	}
	
	public void tick(){
		for (Varazsko v : this.kovek) {
			v.tick();
		}
	}

	@Override
	public void lejarVarazsko(Varazsko v) {
		if(!this.kovek.contains(v)) return;
		
		this.kovek.remove(v);
	}

	public void elkodosit() {
		kovek.add(new Varazsko(1, 0.5, 10));
	}
}
