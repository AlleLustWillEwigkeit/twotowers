package allelustwillewigkeit.twotowers.prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.Environment;

import allelustwillewigkeit.twotowers.model.*;

public class PrototypeController {
	private static final int MAXVARAZSERO = 1000;
	private static boolean palyaszerkeszt = false;
	private static Palya palya;
	private static Jatekmotor motor;
	private static Ellensegek ellen;
	private static Program program;
	private static JosagosSzaruman szaruman;
	private static boolean random = false;
	private static boolean fileba = false;

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String s = new String();
		try {
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
						varazskoListaz();
						break;

					case "HullamRandom":
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

					case "ElfIndit":
						elfIndit(cmd);
						break;

					case "TorpIndit":
						torpIndit(cmd);
						break;

					case "KilistazMap":
						kilistazMap();
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

					case "PalyaElemOsszekapcsol":
						palyaElemOsszekapcsol(cmd);
						break;

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
					default:
						kiir("Érvénytelen parancs!");
					}
				}
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void utOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				int kettesID = Integer.parseInt(cmd[2]);
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				pe1.addSzomszed(pe2); // FIXME ha nem kell
				pe1.lekerUt().beallitKovUt(pe2.lekerUt());
				kiir("A két út összelinkelődött" + egyesID + "->" + kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void vegzetHegyeLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelVegzetHegye(motor);
				kiir("A végzet hegyének lerakása sikerült" + palyaElemID
						+ "-ra");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void startLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelStart();
				kiir("A start lerakása sikerült" + palyaElemID + "-re");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void utLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelUt();
				kiir("Az út lerakása sikerült " + palyaElemID + "-re");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void epitesiTeruletLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelEpitesiTerulet();
				kiir("Építési terület létrejött " + palyaElemID + "-on");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaElemOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				int kettesID = Integer.parseInt(cmd[2]);
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				pe1.addSzomszed(pe2);
				kiir("A két pályaelem összelinkelődött" + egyesID + "->"
						+ kettesID);
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaElemKeszit(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = new PalyaElem(palyaElemID);
				palya.hozzaAdPalyahoz(pe);
				kiir("A pályaelem elkészült" + palyaElemID + "-vel");
			} catch (Exception e) {
				kiir(e.getMessage());
			}
		} else
			kiir("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaSzerkeszt(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "kezd":
				palyaszerkeszt = true;
				kiir("A pályaszerkesztés megkezdődött.");
				break;
			case "veg":
				palyaszerkeszt = false;
				kiir("A pályaszerkesztés befejeződött.");
				break;
			default:
				kiir("Érvénytelen paraméter");
				break;
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void reset(String[] cmd) {
		try {
			palya = new Palya();
			szaruman = new JosagosSzaruman(MAXVARAZSERO);
			program = new Program();
			motor = new Jatekmotor(ellen, szaruman, palya, program);
			ellen = new Ellensegek(motor, 0);
			palyaszerkeszt = false;
			random = false;
			fileba = false;
			kiir("A reset sikerült.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void show(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "map":
				kilistazMap();
				break;
			case "ellensegek":
				kilistazEllensegek();
				break;
			case "allapot":
				switch (motor.lekerallapot()) {
				case 0:
					kiir("Még folyik a mérkőzés!");
					break;
				case 1337:
					kiir("Győzelem!");
					break;
				case -666:
					kiir("Vereség");
					break;
				default:
					System.out
							.println("FAILSAFE: Gáz van, ilyet nem kéne látnod!");
				}
			case "varazskovek":
				varazskoListaz();
				break;
			case "tornyok":
				kilistaztornyok();
				break;
			case "utak":
				kilistazutak();
				break;
			default:
				kiir("Érvénytelen paraméter!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}

	}

	private static void elkodosit(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			Torony t = e.lekerTorony();
			t.elkodosit();
			kiir("A torony elködösítése sikeres" + palyaElemID + "-en.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void lekerHanyEllensegVanMeg(String[] cmd) {
		try {
			kiir("Ennyi ellenség van még:" + ellen.lekerHanyEllensegVanMeg());
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {
		try {
			int ertek = Integer.parseInt(cmd[1]);
			ellen.allitHanyEllensegVanMeg(ertek);
			kiir(ertek + "-re beállítva a hátralevő ellenségek száma");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void tick(String[] cmd) {
		try {
			int tmp;
			int hanyszor = tmp = Integer.parseInt(cmd[1]);
			while (--hanyszor != 0) {
				motor.tick();
			}
			kiir(tmp + "lépés megtörtént");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistazMap() {

		kiir("a palya:");
		Ut u;
		EpitesiTerulet e;
		for (PalyaElem tmp : palya.lekerlista()) {
			kiir("palyaelemid:" + tmp.lekerID());
			try {
				u = tmp.lekerUt();
				kiir(" ut");
				if (u.vanAkadalyRajta()) {
					kiir(" akadállyal");
				}
			} catch (Exception ex) {
				kiir(ex.getMessage());
			}
			try {
				e = tmp.lekerEpitesiTerulet();
				kiir(" epitesi terulet");
				if (e.vanToronyRajta()) {
					kiir(" toronnyal");
				}
			} catch (Exception ex) {
				kiir(ex.getMessage());
			}
		}

	}

	private static void torpIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			for (int i = 0; i < darab; i++) {
				Torp t = new Torp(START_IDE_VALAHOGY, ellen, szint);
				ellen.inditEllenseg(t);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void elfIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			for (int i = 0; i < darab; i++) {
				Elf e = new Elf(START_IDE_VALAHOGY, ellen, szint);
				ellen.inditEllenseg(e);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void hobbitIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			for (int i = 0; i < darab; i++) {
				Hobbit h = new Hobbit(START_IDE_VALAHOGY, ellen, szint);
				ellen.inditEllenseg(h);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void emberIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			for (int i = 0; i < darab; i++) {
				Ember e = new Ember(START_IDE_VALAHOGY, ellen, szint);
				ellen.inditEllenseg(e);
				kiir(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void hullamIndit(String[] cmd) {
		// TODO
		try {
			int szint = Integer.parseInt(cmd[1]);
			int kezdoID = Integer.parseInt(cmd[2]);
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void hullamOsszetetelRandom(String[] cmd) {
		try {
			String muvelet = cmd[1];
			switch (muvelet) {
			case "ki":
				random = false;
				break;
			case "be":
				random = true;
				break;
			default:
				kiir("Érvénytelen paraméter");
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void varazskoListaz() {
		try {
			kiir("varazskovek:");
			EpitesiTerulet e;
			for (PalyaElem tmp : palya.lekerlista()) {
				kiir("palyaelemid:" + tmp.lekerID());
				e = tmp.lekerEpitesiTerulet();
				Torony t = e.lekerTorony();
				for (Varazsko v : t.lekerVarazskovek()) {
					kiir("toronyid: " + tmp.lekerID() + " varazskoid: "
							+ v.lekerid() + " duration: " + v.lekerDuration());
				}
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void varazskoLerak(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			int varazskoDictID = Integer.parseInt(cmd[2]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			Torony t = e.lekerTorony();
			Varazsko v = new Varazsko(varazskoDictID);
			t.felkovez(v);
			kiir("A " + varazskoDictID
					+ "-VarazskoDictID varázskő lerakása sikeres" + v.lekerid()
					+ "VarazskoID-vel.");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void akadalyLerak(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			Ut u = pe.lekerUt();
			u.lerakAkadaly();
			kiir("Az akadály lerakása sikeres " + palyaElemID + "-re");
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void toronyLerak(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			e.lerakTornyot();
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void fajlbaIr(String[] cmd) {
		// TODO
		try {
			String muvelet = cmd[1];
			String utvonal = null;
			if (cmd.length == 3) {
				utvonal = cmd[2];
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void betoltUtasitasok(String[] cmd) {
		// TODO
		try {
			String utvonal = cmd[1];
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistazEllensegek() {
		try {
			kiir("ellensegek:");
			for (Ellenseg tmp : ellen.lekerLista()) {
				kiir("ellensegid " + tmp.lekerid() + ", ellenseghp"
						+ tmp.eleteroLeker() + ", utid" + tmp.lekerut()
						+ ", speed" + tmp.lekersebesseg());
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistaztornyok() {
		try {
			kiir("tornyok:");
			EpitesiTerulet e;
			for (PalyaElem tmp : palya.lekerlista()) {
				kiir("palyaelemid:" + tmp.lekerID());
				e = tmp.lekerEpitesiTerulet();
				kiir(" epitesi terulet");
				if (e.vanToronyRajta()) {
					kiir(" toronnyal");
				}
			}

		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kilistazutak() {
		try {
			kiir("utak:");
			Ut u;
			for (PalyaElem tmp : palya.lekerlista()) {
				kiir("palyaelemid:" + tmp.lekerID());
				u = tmp.lekerUt();
				kiir(" ut");
				if (u.vanAkadalyRajta()) {
					kiir(" akadállyal");
				}
			}
		} catch (Exception e) {
			kiir(e.getMessage());
		}
	}

	private static void kiir(String _str) {
		System.out.print(_str);
		System.out.println();
		if (fileba) {
			// TODO fileba is kivezet
		}
	}
}
