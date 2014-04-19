package allelustwillewigkeit.twotowers.prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import allelustwillewigkeit.twotowers.model.*;

public class PrototypeController {
	static final int MAXVARAZSERO = 1000;
	static boolean palyaszerkeszt;
	static Palya palya;
	static Jatekmotor motor;
	static Ellensegek ellen;
	static Program program;
	static JosagosSzaruman szaruman;

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String s = new String();
		while (true) {
			s = br.readLine();
			String[] cmd = s.split(" ");
			if (cmd != null && cmd.length != 0) {
				switch (cmd[0]) {
				case "BetoltUtasitasok":
					betoltUtasitasok(cmd);
					break;

				case "FajlbaIR":
					fajlbaIr(cmd);
					break;

				case "ToronyLerak":
					toronyLerak(cmd);
					break;

				case "AkadalyLerak":
					akadalyLerak(cmd);
					break;

				case "VarazskoLerak":
					varazskoLerak(cmd);
					break;

				case "VarazskoListaz":
					varazskoListaz(cmd);
					break;

				case "HullamOSszetetelRandom":
					hullamOsszetetelRandom(cmd);
					break;

				case "HullamIndit":
					hullamIndit(cmd);
					break;

				case "EmberIndit":
					emberIndit(cmd);
					break;

				case "HobbitIndit":
					hobbitIndit(cmd);
					break;

				case "TundeIndit":
					tundeIndit(cmd);
					break;

				case "TorpIndit":
					torpIndit(cmd);
					break;

				case "KilistazMap":
					kilistazMap(cmd);
					break;

				case "Tick":
					tick(cmd);
					break;

				case "AllitHanyEllensegVanMeg":
					allitHanyEllensegVanMeg(cmd);
					break;

				case "LekerHanyEllensegVanMeg":
					lekerHanyEllensegVanMeg(cmd);
					break;

				case "Elkodosit":
					elkodosit(cmd);
					break;

				case "Show":
					show(cmd);
					break;

				case "Reset":
					reset(cmd);
					break;

				case "PalyaSzerkeszt":
					palyaSzerkeszt(cmd);
					break;

				case "PalyaElemKeszit":
					palyaElemKeszit(cmd);
					break;

				// case "PalyaElemOsszekapcsol":
				// palyaElemOsszekapcsol(cmd);
				// break;

				case "EpitesiTeruletLerak":
					epitesiTeruletLerak(cmd);
					break;

				case "UtLerak":
					utLerak(cmd);
					break;

				case "StartLerak":
					startLerak(cmd);
					break;

				case "VegzetHegyeLerak":
					vegzetHegyeLerak(cmd);
					break;

				case "UtOsszekapcsol":
					utOsszekapcsol(cmd);
					break;

				}
			}
		}
	}

	private static void utOsszekapcsol(String[] cmd) {
		int egyesID = Integer.parseInt(cmd[1]);
		int kettesID = Integer.parseInt(cmd[2]);
		PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
		PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
		pe1.lekerUt().beallitKovUt(pe2.lekerUt());
		System.out.println("A két út összelinkelődött" + egyesID + "->"
				+ kettesID);
	}

	private static void vegzetHegyeLerak(String[] cmd) {
		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		pe.legyelVegzetHegye(motor);
		System.out.println("A végzet hegyének lerakása sikerült" + palyaElemID
				+ "-ra");
	}

	private static void startLerak(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		pe.legyelStart();
		System.out.println("A start lerakása sikerült" + palyaElemID + "-re");
	}

	private static void utLerak(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		pe.legyelUt();
		System.out.println("Az út lerakása sikerült " + palyaElemID + "-re");
	}

	private static void epitesiTeruletLerak(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
		pe.legyelEpitesiTerulet();
		System.out.println("Építési terület létrejött " + palyaElemID + "-on");
	}

	// private static void palyaElemOsszekapcsol(String[] cmd) {
	//
	// int palyaElemID1 = Integer.parseInt(cmd[1]);
	// int palyaElemID2 = Integer.parseInt(cmd[2]);
	// }

	private static void palyaElemKeszit(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = new PalyaElem(palyaElemID);
		palya.hozzaAdPalyahoz(pe);
		System.out.println("A pályaelem elkészült" + palyaElemID + "-vel");
	}

	private static void palyaSzerkeszt(String[] cmd) {

		String muvelet = cmd[1];
		switch (muvelet) {
		case "kezd":
			palyaszerkeszt = true;
			System.out.println("A pályaszerkesztés megkezdődött.");
			break;
		case "veg":
			palyaszerkeszt = false;
			System.out.println("A pályaszerkesztés befejeződött.");
			break;
		default:
			System.out.println("Érvénytelen paraméter");
			break;
		}
	}

	private static void reset(String[] cmd) {
		palya = new Palya();
		szaruman = new JosagosSzaruman(MAXVARAZSERO);
		program = new Program();
		motor = new Jatekmotor(ellen, szaruman, palya, program);
		ellen = new Ellensegek(motor, 0);
		System.out.println("A reset sikerült.");
	}

	private static void show(String[] cmd) {

		String muvelet = cmd[1];
	}

	private static void elkodosit(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		PalyaElem pe = new PalyaElem(palyaElemID);
		pe.lekerEpitesiTerulet().lekerTorony().elkodosit();
		System.out.println("A torony elködösítése sikeres" + palyaElemID
				+ "-en.");
	}

	private static void lekerHanyEllensegVanMeg(String[] cmd) {

	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {

		int ertek = Integer.parseInt(cmd[1]);
	}

	private static void tick(String[] cmd) {

		int hanyszor = Integer.parseInt(cmd[1]);
	}

	private static void kilistazMap(String[] cmd) {

	}

	private static void torpIndit(String[] cmd) {

		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void tundeIndit(String[] cmd) {

		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void hobbitIndit(String[] cmd) {

		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void emberIndit(String[] cmd) {

		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void hullamIndit(String[] cmd) {

		int intSzint = Integer.parseInt(cmd[1]);
		int kezdoID = Integer.parseInt(cmd[2]);
	}

	private static void hullamOsszetetelRandom(String[] cmd) {

		String muvelet = cmd[1];
	}

	private static void varazskoListaz(String[] cmd) {

	}

	private static void varazskoLerak(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		int varazskoDictID = Integer.parseInt(cmd[2]);
		int varazskoID = Integer.parseInt(cmd[3]);

	}

	private static void akadalyLerak(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		int akadalyID = Integer.parseInt(cmd[2]);

	}

	private static void toronyLerak(String[] cmd) {

		int palyaElemID = Integer.parseInt(cmd[1]);
		int toronyID = Integer.parseInt(cmd[2]);

	}

	private static void fajlbaIr(String[] cmd) {

		String muvelet = cmd[1];
		String utvonal = null;
		if (cmd.length == 3) {
			utvonal = cmd[2];
		}
	}

	private static void betoltUtasitasok(String[] cmd) {

		String utvonal = cmd[1];
	}

}
