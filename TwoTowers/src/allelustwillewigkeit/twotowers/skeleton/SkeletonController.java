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
	static final int CONSTANT1 = 4;
	static BufferedReader br;
	static {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
	}

	public static void nyilJobbra() {
		kiiro("--->");
	}

	public static void nyilBalra() {
		kiiro("<---");
	}

	public static void fuggvenyBelep(String fuggvenyNeve) {
		behuzas();
		nyilJobbra();
		kiiro(fuggvenyNeve);
		kiiro("\n");
		tabok += CONSTANT1;
	}

	public static void fuggvenyKilep(String fuggvenyNeve) {
		if (tabok > 0) {
			tabok -= CONSTANT1;
			behuzas();
			nyilBalra();
			kiiro("return from "+ fuggvenyNeve);
			kiiro("\n");

		} else {
			kiiro("Valaki úgy lépett ki, hogy nem lépett be!");
		}

	}

	private static void kiiro(String mit) { // Forrascsere esetere.
		System.out.print(mit);
	}

	private static void behuzas() {
		for (int i = 0; i < tabok; ++i) {
			kiiro(" ");
		}
	}

	private static void print(String mit) {
		behuzas();
		SkeletonController.kiiro(mit);
	}

	public static void println(String mit) {

		SkeletonController.print(mit);
		SkeletonController.kiiro("\n");
	}

	public static String readln() {
		try {
			behuzas();
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean kerdezIH(String mihez) { //TODO illenék exceptionöket dobálni, ahelyett hogy újrahívjuk a fgv-t.
		print(mihez);
		kiiro(" (I/H)\n");
		String eredmeny;
		eredmeny = readln();
		eredmeny = eredmeny.toUpperCase();
		if (eredmeny.charAt(0) == 'I') {
			return true;
		} else if (eredmeny.charAt(0) == 'H') {
			return false;
		} else {
			println("Nem valid valasz. Probald ujra.");
			kerdezIH(mihez);
		}
		return false;

	}

	public static int kerdezEgesz(String mihez) {
		print(mihez);
		kiiro(" (egesz)\n");
		String eredmeny = readln();
		return Integer.parseInt(eredmeny);
	}

	public static Lovedek kerdezLovedek(String mihez) {
		try {
			println(mihez);
			println("Adja meg milyen lovedekkel akar loni! Itt a lista:");
			println("1 - Lövedék");
			println("2 - Nyíl ");
			println("3 - Tűzgolyó");
			println("4 - Szikla");
			println("5 - Dárda");
			String valasz = readln();
			int valaszINT = Integer.parseInt(valasz);
			switch (valaszINT) {
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
		} catch (NumberFormatException e) {
			println("A válasz valahol 1-5 között rejlik, számmal írva!");
			kerdezLovedek(mihez);
		} catch (IllegalArgumentException e) {
			println("Számot adtál meg, de nem az adott tartományban!");
			kerdezLovedek(mihez);
		}
		return null;

	}
}
