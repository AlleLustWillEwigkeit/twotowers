package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Akadaly implements Varazskovezheto{
	protected float eletero = 0;
	protected List<Varazsko> varazsko = new ArrayList<Varazsko>();
	protected Ut ut = null;

	/**
	 * Az akadály konstruktora
	 * 
	 * @param Ut
	 *            u
	 */
	public Akadaly(Ut u) throws NullPointerException {
		if(u == null)
			throw new NullPointerException();
		
		this.ut = u;
	}

	/**
	 * void felkovez Felveszi a paraméterül kapott varászkő referenciáját
	 * 
	 * @param Varazsko
	 *            mivel
	 */
	public void felkovez(Varazsko mivel) throws NullPointerException {
		if(mivel == null)
			throw new NullPointerException();
		
		mivel.beallitTarolo(this);
		this.varazsko.add(mivel);
	}

	/**
	 * void sebzodik Levonja a paraméterül kapott értéket az életerejéből.
	 * 
	 * @param int mennyit
	 */
	public void sebzodik(float mennyit) {
		if(mennyit <= 0)
			return;
		
		float szorzo = 0.0f;
		
		for(Varazsko v : varazsko){
			szorzo += v.lekerEleteroSzorzo();
		}
		
		eletero -= mennyit / szorzo;
		
		if(eletero <= 0){ //meghalás
			ut.akadalyomLebomlott();
		}
	}
	
	public void tick(){
		for (Varazsko v : this.varazsko) {
			v.tick();
		}
	}

	@Override
	public void lejarVarazsko(Varazsko v) {
		// TODO Auto-generated method stub
		if(!this.varazsko.contains(v)) return;
		
		this.varazsko.remove(v);
	}
}
