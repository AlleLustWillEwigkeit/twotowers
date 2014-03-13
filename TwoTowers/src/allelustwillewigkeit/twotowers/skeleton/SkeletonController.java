package allelustwillewigkeit.twotowers.skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		if(tabok > 0) // csak a biztonság kedvéért, igazából nem túl lényeges, a forciklus max nem futna le egyszer sem.
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
	
	public static String readln(){
		try {
//			kiiro("\n");
			for(int i=0; i!= tabok; i++){
				SkeletonController.kiiro("\t");
			}
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static boolean kerdezIH(String mihez){//TODO REFACTOR
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
	
	public static int kerdezEgesz(String mihez){//TODO REFACTOR
		print(mihez);
		kiiro(" (egesz)\n");
		String eredmeny = readln();
		return Integer.parseInt(eredmeny);
	}
	
	public static int kerdezLovedek(String mihez) throws Exception{
		throw new Exception("kerdezLovedek is not implemented yet"); //TODO FIX?
		
	}
}
