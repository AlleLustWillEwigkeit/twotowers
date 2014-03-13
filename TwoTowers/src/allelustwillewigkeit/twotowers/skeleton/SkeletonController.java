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
		if(tabok < 0) // csak a biztons�g kedv��rt, igaz�b�l nem t�l l�nyeges, a forciklus max nem futna le egyszer sem.
			tabok--;
	}
	private static void kiiro(String mit){ // Forr�scsere eset�re.
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
		InputStreamReader isr = new InputStreamReader(System.in); // Lehet hogy ez az oszt�lynak k�ne eleme legyen, hogy csak egyszer zongor�zzuk v�gig?
		BufferedReader br = new BufferedReader ( isr );	 // Lehet hogy ez az oszt�lynak k�ne eleme legyen, hogy csak egyszer zongor�zzuk v�gig?
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
		return (Boolean) null; // ha ide �r akkor okozzunk m�r legal�bb valami anom�li�t, mert itt semmi keresnival�ja sincs a f�ggv�nyek.
		
	}
	
	public static int kerdezEgesz(String mihez){//TODO REFACTOR
		kiiro(mihez);
		kiiro(" (egesz)\n");
		InputStreamReader isr = new InputStreamReader(System.in); // Lehet hogy ez az oszt�lynak k�ne eleme legyen, hogy csak egyszer zongor�zzuk v�gig?
		BufferedReader br = new BufferedReader ( isr );	 // Lehet hogy ez az oszt�lynak k�ne eleme legyen, hogy csak egyszer zongor�zzuk v�gig?
		try {
			String eredmeny = br.readLine();
			return Integer.parseInt(eredmeny);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (Integer) null; // ha ide �r akkor okozzunk m�r legal�bb valami anom�li�t, mert itt semmi keresnival�ja sincs a f�ggv�nyek.
		
	}
	
	public static int kerdezLovedek(String mihez) throws Exception{
		throw new Exception("kerdezLovedek is not implemented yet"); //TODO FIX?
		
	}
}
