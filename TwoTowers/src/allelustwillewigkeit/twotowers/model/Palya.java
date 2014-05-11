package allelustwillewigkeit.twotowers.model;

import java.util.ArrayList;
import java.util.List;

public class Palya {
	PalyaElem[][] palyaelemek = new PalyaElem[12][12]; // TODO MODIFIED!
	Start start;
	VegzetHegye vegzet;

	/**
	 * A palya konstruktora
	 */
	public Palya(Jatekmotor jm) {
		// MAPGENERÁLÁS	
		int id = 1;
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				palyaelemek[x][y] = new PalyaElem(id++,this);
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
		
		palyaelemek[11][11].legyelVegzetHegye(jm, 0);
		
		start = (Start)palyaelemek[0][2].lekerUt();
		vegzet = (VegzetHegye)palyaelemek[11][11].lekerUt();
		
		utatRak(0,2,1,2);
		utatRak(1,2,1,6);
		utatRak(1,5,5,5);
		utatRak(4,5,4,-1);
		utatRak(4,0,9,0);
		utatRak(8,0,8,4);
		
		utatRak(8,3,5,3);
		utatRak(6,3,6,12);
		utatRak(6,11,12,11);
		
		utatRak(8,3,11,3);
		utatRak(10,3,10,8);
		utatRak(10,7,7,7);
		utatRak(8,7,8,12);
		utatRak(8,11,12,11);
		
		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 12; y++) {
				if(!palyaelemek[x][y].vanUtja()){
					palyaelemek[x][y].legyelEpitesiTerulet(0);
				}
			}
		}
		
		start.beallitKovUt(palyaelemek[1][2].lekerUt());
		
		//END OF UT GENERATION MAGIC
	}


	public Start getStart(){
		return start;
	}
	
	public VegzetHegye getVegzet(){
		return vegzet;
	}
	
	public void EndBeregisztral(){
		for (PalyaElem[] plist : this.palyaelemek) {
			for( PalyaElem p : plist ){
				p.beregisztralt = false;
				p.tav = 0;
			}
		}
	}
	
	private void utatRak(int kezdx, int kezdy, int vegx, int vegy){
		if(kezdx == vegx){
			
			if(kezdy < vegy){
				for(int y = kezdy; y != vegy;  ++y){
					palyaelemek[kezdx][y].legyelUt(0);
				}
				for(int y = kezdy; y!=vegy-1 ;++y){
					palyaelemek[kezdx][y].lekerUt().beallitKovUt(palyaelemek[kezdx][y+1].lekerUt());
				}

			}else{
				for(int y = kezdy; y != vegy;  --y){
					palyaelemek[kezdx][y].legyelUt(0);
				}
				for(int y = kezdy; y!=vegy+1; --y){
					palyaelemek[kezdx][y].lekerUt().beallitKovUt(palyaelemek[kezdx][y-1].lekerUt());
				}
				
			}

		}else if (kezdy == vegy){
			
			if(kezdx < vegx){
				for(int x = kezdx; x != vegx;  ++x){
					palyaelemek[x][kezdy].legyelUt(0);
				}
				for(int x = kezdx; x!=vegx-1; ++x){
					palyaelemek[x][kezdy].lekerUt().beallitKovUt(palyaelemek[x+1][kezdy].lekerUt());
				}
				
			}
			else{
				for(int x = kezdx; x != vegx;  --x){
					palyaelemek[x][kezdy].legyelUt(0);
				}
				for(int x = kezdx; x!=vegx+1; --x){
					palyaelemek[x][kezdy].lekerUt().beallitKovUt(palyaelemek[x-1][kezdy].lekerUt());
				}
				
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

