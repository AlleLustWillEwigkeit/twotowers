package allelustwillewigkeit.twotowers.skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkeletonController {
	private static int tabok = 0;
	public static void tabNo(){
		tabok++;
	}
	public static void tabCsokken(){
		if(tabok < 0) // csak a biztonság kedvéért, igazából nem túl lényeges, a forciklus max nem futna le egyszer sem.
			tabok--;
	}
	private static void kiiro(String mit){ // Forráscsere esetére.
		System.out.print(mit);
	}
	
	public static void print(String mit){
		for(int i=0; i!= tabok; i++){
			SkeletonController.kiiro("\t");
		}
		SkeletonController.kiiro(mit);
	}
	public static void println(String mit){
		SkeletonController.print(mit);
		SkeletonController.kiiro("\n");
	}
	
	public static boolean kerdezIH(String mihez){//TODO REFACTOR
		kiiro(mihez);
		kiiro(" (I/H)\n");
		InputStreamReader isr = new InputStreamReader(System.in); // Lehet hogy ez az osztálynak kéne eleme legyen, hogy csak egyszer zongorázzuk végig?
		BufferedReader br = new BufferedReader ( isr );	 // Lehet hogy ez az osztálynak kéne eleme legyen, hogy csak egyszer zongorázzuk végig?
		try {
			String eredmeny = br.readLine();
			eredmeny.toUpperCase();
			if(eredmeny.charAt(0) == 'I'){
				return true;
			}
			else if(eredmeny.charAt(0) == 'H'){
				return false;
			}
			else{
				kiiro("Nem valid valasz. Probald ujra.\n");
				kerdezIH(mihez);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (Boolean) null; // ha ide ér akkor okozzunk már legalább valami anomáliát, mert itt semmi keresnivalója sincs a függvények.
		
	}
	
	public static int kerdezEgesz(String mihez){//TODO REFACTOR
		kiiro(mihez);
		kiiro(" (egesz)\n");
		InputStreamReader isr = new InputStreamReader(System.in); // Lehet hogy ez az osztálynak kéne eleme legyen, hogy csak egyszer zongorázzuk végig?
		BufferedReader br = new BufferedReader ( isr );	 // Lehet hogy ez az osztálynak kéne eleme legyen, hogy csak egyszer zongorázzuk végig?
		try {
			String eredmeny = br.readLine();
			return Integer.parseInt(eredmeny);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (Integer) null; // ha ide ér akkor okozzunk már legalább valami anomáliát, mert itt semmi keresnivalója sincs a függvények.
		
	}
	
	public static int kerdezLovedek(String mihez) throws Exception{
		throw new Exception("kerdezLovedek is not implemented yet"); //TODO FIX?
		
	}
}
