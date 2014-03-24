package allelustwillewigkeit.twotowers.skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import allelustwillewigkeit.twotowers.model.Akadaly;
import allelustwillewigkeit.twotowers.model.Darda;
import allelustwillewigkeit.twotowers.model.Ellenseg;
import allelustwillewigkeit.twotowers.model.Ellensegek;
import allelustwillewigkeit.twotowers.model.Ember;
import allelustwillewigkeit.twotowers.model.EpitesiTerulet;
import allelustwillewigkeit.twotowers.model.Hobbit;
import allelustwillewigkeit.twotowers.model.Jatekmotor;
import allelustwillewigkeit.twotowers.model.JosagosSzaruman;
import allelustwillewigkeit.twotowers.model.Lovedek;
import allelustwillewigkeit.twotowers.model.Nyil;
import allelustwillewigkeit.twotowers.model.PalyaElem;
import allelustwillewigkeit.twotowers.model.Start;
import allelustwillewigkeit.twotowers.model.Szikla;
import allelustwillewigkeit.twotowers.model.Torony;
import allelustwillewigkeit.twotowers.model.Torp;
import allelustwillewigkeit.twotowers.model.Tuzgolyo;
import allelustwillewigkeit.twotowers.model.Tunde;
import allelustwillewigkeit.twotowers.model.Ut;
import allelustwillewigkeit.twotowers.model.Varazsko;
import allelustwillewigkeit.twotowers.model.VegzetHegye;

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

	public static void tabNo() {
		behuzas();
		nyilJobbra();

		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[2];

		kiiro(e.getClassName() + "::" + e.getMethodName() + "\n");
		tabok += CONSTANT1;
	}

	public static void tabCsokken() {
		if (tabok > 0) {
			tabok -= CONSTANT1;
			behuzas();
			nyilBalra();

			StackTraceElement[] stacktrace = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stacktrace[2];

			kiiro("return from " + e.getClassName() + "::" + e.getMethodName()
					+ "\n");

		} else {
			kiiro("Valaki ugy lepett ki, hogy nem lepett be!");
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

	public static boolean kerdezIH(String mihez) {
		try {
			print(mihez);
			kiiro(" (I/H)\n");
			String eredmeny;
			eredmeny = readln().toUpperCase();
			switch (eredmeny.charAt(0)) {
			case 'I':
				return true;
			case 'H':
				return false;
			default:
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			println("Nem valid valasz. Probald ujra.");
			return kerdezIH(mihez);
		}

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
			println("1 - Lovedek");
			println("2 - Nyil ");
			println("3 - Tuzgolyo");
			println("4 - Szikla");
			println("5 - Darda");
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
			println("A valasz valahol 1-5 kozott rejlik, szammal irva!");
			return kerdezLovedek(mihez);
		} catch (IllegalArgumentException e) {
			println("Szamot adtal meg, de nem az adott tartomanyban!");
			return kerdezLovedek(mihez);
		}

	}

	public static Ellenseg kerdezEllenseg(String mihez, Ut ut, Ellensegek el) {
		try {
			println(mihez);
			println("Adja meg milyen ellensegre akar loni! Itt a lista:");
			println("1 - Ember");
			println("2 - Tunde ");
			println("3 - Torp");
			println("4 - Hobbit");
			String valasz = readln();
			int valaszINT = Integer.parseInt(valasz);
			switch (valaszINT) {
			case 1:
				return new Ember(ut, el);
			case 2:
				return new Tunde(ut, el);
			case 3:
				return new Torp(ut, el);
			case 4:
				return new Hobbit(ut, el);
			default:
				throw new IllegalArgumentException();
			}
		} catch (NumberFormatException e) {
			println("A valasz valahol 1-2 kozott rejlik, szammal irva!");
			return kerdezEllenseg(mihez, ut, el);
		} catch (IllegalArgumentException e) {
			println("Szamot adtal meg, de nem az adott tartomanyban!");
			return kerdezEllenseg(mihez, ut, el);
		}

	}

	public static void mainMenu() {
		boolean doexit = false;
		while (!doexit) {
			println("Kerem a lejatszando use-case szamat! A lehetosegek:");
			println("0. Kilepes a skeleton programbol");
			println("1. Lepes");
			println("2. Loves");
			println("3. Akadaly lerakasa");
			println("4. Torony lerakas");
			println("5. Varazsko lerakas");
			println("6. Gyozelem");
			println("7. Vereseg");
			try {
				switch (Integer.parseInt(SkeletonController.readln())) {
					case 1:
						UCLepes();
						break;
					case 2:
						UCLoves();
						break;
					case 3:
						UCAkadalyLerak();
						break;
					case 4:
						UCToronyLerak();
						break;
					case 5:
						UCVarazskoLerak();
						break;
					case 6:
						UCGyozelem();
						break;
					case 7:
						UCVereseg();
						break;
					case 0:
						doexit = true;
						break;
					default:
						System.out.println("ervenytelen bemenet.");
						break;
				}
			} catch (NumberFormatException e) {
				println("A valasz valahol 1-7 kozott rejlik, szammal irva!");
			} catch (IllegalArgumentException e) {
				println("Szamot adtal meg, de nem az adott tartomanyban!");
			}
		}

	}

	public static void UCLepes() {
		Jatekmotor jm = new Jatekmotor(null);
		Ut u1 = new Ut();
		Ut u2 = new Ut();
		u1.beallitKovUt(u2);
		u2.beallitKovUt(u1);
		Start st = new Start();
		st.beallitKovUt(u1);

		Ellensegek e = new Ellensegek(jm, st);
		e.inditEllenseg(3);
		System.out.println("Inicializalas vege, kezdodik a szekvenciadiagram");
		e.mindLep();
	}

	public static void UCLoves() {
		// Jatekmotor jm = new Jatekmotor();
		Ut u = new Ut();
		Torony t = new Torony();
		Varazsko v = new Varazsko();
		Lovedek l = kerdezLovedek("");

		v.lovedek.add(l);
		t.varazsko.add(v);
		u.torony.add(t);
		Ellenseg e = kerdezEllenseg("", u, null);
		System.out.println("Inicializalas vege, kezdodik a szekvenciadiagram");
		u.raLep(e);
	}

	public static void UCToronyLerak() {
		Jatekmotor jm = new Jatekmotor(null);
		PalyaElem pe = new PalyaElem();
		EpitesiTerulet e = new EpitesiTerulet();
		pe.epitesiTerulet = e;
		System.out.println("Inicializalas vege, kezdodik a szekvenciadiagram");
		jm.lerakTornyot(pe);
	}

	public static void UCAkadalyLerak() {
		Jatekmotor jm = new Jatekmotor(null);
		PalyaElem pe = new PalyaElem();
		Ut u = new Ut();
		pe.ut = u;
		System.out.println("Inicializalas vege, kezdodik a szekvenciadiagram");
		jm.lerakAkadaly(pe);
	}

	public static void UCVarazskoLerak() {
		Jatekmotor jm = new Jatekmotor(new JosagosSzaruman());
		PalyaElem pe = new PalyaElem();

		EpitesiTerulet e = new EpitesiTerulet();
		e.torony = new Torony();
		pe.epitesiTerulet = e;

		Ut u = new Ut();
		u.akadaly = new Akadaly(u);
		pe.ut = u;
		System.out.println("Inicializalas vege, kezdodik a szekvenciadiagram");
		jm.felkovez(pe);
	}

	public static void UCGyozelem() {
		Jatekmotor jm = new Jatekmotor(null);
		Start st = new Start();
		Ellensegek ellen = new Ellensegek(jm, st);
		Ellenseg e = new Ember(st, ellen);
		ellen.ellenseg.add(e);
		System.out.println("Inicializalas vege, kezdodik a szekvenciadiagram");
		ellen.egyEllensegMeghalt(e);
	}

	public static void UCVereseg() {
		Jatekmotor jm = new Jatekmotor(null);
		VegzetHegye vh = new VegzetHegye(jm);
		Ellensegek ellen = new Ellensegek(jm, null);
		Ellenseg e = new Ember(null, ellen);
		System.out.println("Inicializalas vege, kezdodik a szekvenciadiagram");
		vh.raLep(e);
	}

}
