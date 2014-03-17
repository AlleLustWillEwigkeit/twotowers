package allelustwillewigkeit.twotowers.skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import allelustwillewigkeit.twotowers.model.Darda;
import allelustwillewigkeit.twotowers.model.Lovedek;
import allelustwillewigkeit.twotowers.model.Nyil;
import allelustwillewigkeit.twotowers.model.Szikla;
import allelustwillewigkeit.twotowers.model.Tuzgolyo;

public class SkeletonController {
	private static int tabok = 0;
	static InputStreamReader isr;
	static BufferedReader br;
	static{
		isr = new InputStreamReader(System.in);
		br  = new BufferedReader(isr);
	}
	public static void tabNo(){
		tabok++;
	}
	public static void tabCsokken(){
		if(tabok > 0) 
			tabok--;
	}
	private static void kiiro(String mit){ // Forrascsere esetere.
		System.out.print(mit);
	}
	
	private static void tabber(){
		SkeletonController.kiiro("|");
		for(int i=0; i < tabok; i++){
			SkeletonController.kiiro("-");
		}
		SkeletonController.kiiro(">");
	}
	
	private static void print(String mit){
		tabber();
		SkeletonController.kiiro(mit);
	}
	public static void println(String mit){
		SkeletonController.print(mit);
		SkeletonController.kiiro("\n");
	}
	
	public static String readln(){
		try {
			tabber();
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static boolean kerdezIH(String mihez){
		print(mihez);
		kiiro(" (I/H)\n");
			String eredmeny = readln();
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
			return false;
		
	}
	
	public static int kerdezEgesz(String mihez){
		print(mihez);
		kiiro(" (egesz)\n");
		String eredmeny = readln();
		return Integer.parseInt(eredmeny);
	}
	
	public static Lovedek kerdezLovedek(String mihez) {
		//throw new Exception("kerdezLovedek is not implemented yet"); //TODO FIX?
		try{
			println(mihez);
			println("Adja meg milyen lovedekkel akar loni! Itt a lista:");
			println("1 - Lövedék");
			println("2 - Nyíl ");
			println("3 - Tűzgolyó");
			println("4 - Szikla");
			println("5 - Dárda");
			String valasz = readln();
			int buzivagyok = Integer.parseInt(valasz);
			
			
			
			switch(buzivagyok){
				case 1:
					return new Lovedek();		
				case 2:
					return new Nyil();	
				case 3:
					return new Tuzgolyo();
				case 4:
					return new Szikla();
				case 5:
					return new Darda();
				default:
					throw new IllegalArgumentException();
			}

		}catch(NumberFormatException e){
			println("A válasz valahol 1-5 között rejlik, számmal írva!");
			kerdezLovedek(mihez);
		}catch(IllegalArgumentException e){
			println("Számot adtál meg, de nem az adott tartományban!");
			kerdezLovedek(mihez);
		}
		return null;
	
	}
}
