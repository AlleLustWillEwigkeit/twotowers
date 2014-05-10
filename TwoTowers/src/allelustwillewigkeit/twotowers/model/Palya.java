package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Palya {
	PalyaElem[][] palyaelemek = new PalyaElem[12][12]; // TODO MODIFIED!
	Start start;

	/**
	 * A palya konstruktora
	 */
	public Palya() {
		// MAPGENERÁLÁS	
		int id = 1;
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				palyaelemek[x][y] = new PalyaElem(id++);
			}
		}
		
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				PalyaElem palyaelem = palyaelemek[x][y];
				if ((x + 1) < 12)
					palyaelem.addSzomszed(palyaelemek[x + 1][y]);
				if ((y + 1) < 12)
					palyaelem.addSzomszed(palyaelemek[x][y + 1]);
			}
		}
		//END OF MAP GENERATION MAGIC
		//~~YOLO SWAG~~
		//UT GENERATION MAGIC
		palyaelemek[0][2].legyelStart(0);
		
		start = (Start)palyaelemek[0][2].lekerUt();
		
	//	utatRak(0,2,1,2);
		utatRak(1,2,1,5);
		utatRak(1,5,4,5);
		utatRak(4,5,4,0);
		utatRak(4,0,8,0);
		utatRak(8,0,8,3);
		
		utatRak(8,3,6,3);
		utatRak(6,3,6,11);
		utatRak(6,11,11,11);
		
		utatRak(8,3,10,3);
		utatRak(10,3,10,7);
		utatRak(10,7,8,7);
		utatRak(8,7,8,11);
		utatRak(8,11,11,11);
		
		palyaelemek[0][2].lekerUt().beallitKovUt(palyaelemek[1][2].lekerUt());
		
		//END OF UT GENERATION MAGIC
	}

	public Start getStart(){
		return start;
	}
	
	private void utatRak(int kezdx, int kezdy, int vegx, int vegy){
		if(kezdx == vegx){
			for(int y = kezdy; y != vegy; y = kezdy < vegy ? ++y : --y){
				palyaelemek[kezdx][y].legyelUt(0);
			}
			for(int y = kezdy;  kezdy < vegy ? y!=vegy-1 : y!=vegy+1 ; y = kezdy < vegy ? ++y : --y){
				palyaelemek[kezdx][y].lekerUt().beallitKovUt(palyaelemek[kezdx][y+1].lekerUt());
			}
			
		}else if (kezdy == vegy){
			for(int x = kezdx; x != vegx; x = kezdx < vegx ? ++x : --x){
				palyaelemek[x][kezdy].legyelUt(0);
			}
			for(int x = kezdx; kezdx < vegx ? x!=vegx-1 : x!=vegx+1; x = kezdx < vegx ? ++x : --x){
				palyaelemek[x][kezdy].lekerUt().beallitKovUt(palyaelemek[x+1][kezdy].lekerUt());
			}
		}else{
			return; //SHIT
		}
	}
	
	public void tick() {
		for (PalyaElem[] plist : this.palyaelemek) {
			for( PalyaElem p : plist ){
				p.tick();
			}
		}
	}
	
	public PalyaElem getElementByXY(int x, int y){
		return palyaelemek[x][y];
		
	}

	/**
	 * void ujPalya Letrehoz egy palya osszeallitast.
	 * @throws Exception 
	 */
	/*
	public void ujPalya() throws Exception { // TODO
		throw new Exception("Not implemented"); // TODO
	} //FIXME

	public void hozzaAdPalyahoz(PalyaElem _pe) throws Exception { // TODO
		throw new Exception("Not implemented"); // TODO
	} //FIXME

	public PalyaElem lekerPalyaElemIDvel(int _palyaElemID) throws Exception { // TODO
		throw new Exception("Not implemented"); // TODO
	} //FIXME

	public List<PalyaElem> lekerlista()throws Exception { // TODO
		throw new Exception("Not implemented"); // TODO
	} //FIXME
	*/
}

