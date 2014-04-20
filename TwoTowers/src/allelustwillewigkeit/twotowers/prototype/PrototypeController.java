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
						System.out.println("Érvénytelen parancs!");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
				System.out.println("A két út összelinkelődött" + egyesID + "->"
						+ kettesID);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void vegzetHegyeLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelVegzetHegye(motor);
				System.out.println("A végzet hegyének lerakása sikerült"
						+ palyaElemID + "-ra");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void startLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelStart();
				System.out.println("A start lerakása sikerült" + palyaElemID
						+ "-re");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void utLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelUt();
				System.out.println("Az út lerakása sikerült " + palyaElemID
						+ "-re");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");

	}

	private static void epitesiTeruletLerak(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
				pe.legyelEpitesiTerulet();
				System.out.println("Építési terület létrejött " + palyaElemID
						+ "-on");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaElemOsszekapcsol(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int egyesID = Integer.parseInt(cmd[1]);
				int kettesID = Integer.parseInt(cmd[2]);
				PalyaElem pe1 = palya.lekerPalyaElemIDvel(egyesID);
				PalyaElem pe2 = palya.lekerPalyaElemIDvel(kettesID);
				pe1.addSzomszed(pe2);
				System.out.println("A két pályaelem összelinkelődött" + egyesID
						+ "->" + kettesID);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaElemKeszit(String[] cmd) {
		if (palyaszerkeszt) {
			try {
				int palyaElemID = Integer.parseInt(cmd[1]);
				PalyaElem pe = new PalyaElem(palyaElemID);
				palya.hozzaAdPalyahoz(pe);
				System.out.println("A pályaelem elkészült" + palyaElemID
						+ "-vel");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else
			System.out.println("Nincs aktiválva a pályaszereksztő mód!");
	}

	private static void palyaSzerkeszt(String[] cmd) {
		try {
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
			System.out.println("A reset sikerült.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
					System.out.println("Még folyik a mérkőzés!");
					break;
				case 1337:
					System.out.println("Győzelem!");
					break;
				case -666:
					System.out.println("Vereség");
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
				System.out.println("Érvénytelen paraméter!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void elkodosit(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			Torony t = e.lekerTorony();
			t.elkodosit();
			System.out.println("A torony elködösítése sikeres" + palyaElemID
					+ "-en.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void lekerHanyEllensegVanMeg(String[] cmd) {
		try {
			System.out.println("Ennyi ellenség van még:"
					+ ellen.lekerHanyEllensegVanMeg());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {
		try {
			int ertek = Integer.parseInt(cmd[1]);
			ellen.allitHanyEllensegVanMeg(ertek);
			System.out.println(ertek
					+ "-re beállítva a hátralevő ellenségek száma");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void tick(String[] cmd) {
		try {
			int tmp;
			int hanyszor = tmp = Integer.parseInt(cmd[1]);
			while (--hanyszor != 0) {
				motor.tick();
			}
			System.out.println(tmp + "lépés megtörtént");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void kilistazMap() {

		System.out.println("a palya:");
		Ut u;
		EpitesiTerulet e;
		for (PalyaElem tmp : palya.lekerlista()) {
			System.out.print("palyaelemid:" + tmp.lekerID());
			try {
				u = tmp.lekerUt();
				System.out.print(" ut");
				if (u.vanAkadalyRajta()) {
					System.out.print(" akadállyal");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			try {
				e = tmp.lekerEpitesiTerulet();
				System.out.print(" epitesi terulet");
				if (e.vanToronyRajta()) {
					System.out.print(" toronnyal");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
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
				System.out.println(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void elfIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			for (int i = 0; i < darab; i++) {
				Elf e = new Elf(START_IDE_VALAHOGY, ellen, szint);
				ellen.inditEllenseg(e);
				System.out.println(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void hobbitIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			for (int i = 0; i < darab; i++) {
				Hobbit h = new Hobbit(START_IDE_VALAHOGY, ellen, szint);
				ellen.inditEllenseg(h);
				System.out.println(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void emberIndit(String[] cmd) {
		try {
			int szint = Integer.parseInt(cmd[1]);
			int darab = Integer.parseInt(cmd[2]);
			for (int i = 0; i < darab; i++) {
				Ember e = new Ember(START_IDE_VALAHOGY, ellen, szint);
				ellen.inditEllenseg(e);
				System.out.println(darab + "ellenség elkészült!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void hullamIndit(String[] cmd) {
		// TODO
		try {
			int szint = Integer.parseInt(cmd[1]);
			int kezdoID = Integer.parseInt(cmd[2]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
				System.out.println("Érvénytelen paraméter");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void varazskoListaz() {
		try {
			System.out.println("varazskovek:");
			EpitesiTerulet e;
			for (PalyaElem tmp : palya.lekerlista()) {
				System.out.print("palyaelemid:" + tmp.lekerID());
				e = tmp.lekerEpitesiTerulet();
				Torony t = e.lekerTorony();
				for (Varazsko v : t.lekerVarazskovek()) {
					System.out.print("toronyid: " + tmp.lekerID()
							+ " varazskoid: " + v.lekerid() + " duration: "
							+ v.lekerDuration());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
			System.out.println("A " + varazskoDictID
					+ "-VarazskoDictID varázskő lerakása sikeres" + v.lekerid()
					+ "VarazskoID-vel.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void akadalyLerak(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			Ut u = pe.lekerUt();
			u.lerakAkadaly();
			System.out.println("Az akadály lerakása sikeres " + palyaElemID
					+ "-re");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void toronyLerak(String[] cmd) {
		try {
			int palyaElemID = Integer.parseInt(cmd[1]);
			PalyaElem pe = palya.lekerPalyaElemIDvel(palyaElemID);
			EpitesiTerulet e = pe.lekerEpitesiTerulet();
			e.lerakTornyot();
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
		}
	}

	private static void betoltUtasitasok(String[] cmd) {
		// TODO
		try {
			String utvonal = cmd[1];
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void kilistazEllensegek() {
		try {
			System.out.println("ellensegek:");
			for (Ellenseg tmp : ellen.lekerLista()) {
				System.out.println("ellensegid " + tmp.lekerid()
						+ ", ellenseghp" + tmp.eleteroLeker() + ", utid"
						+ tmp.lekerut() + ", speed" + tmp.lekersebesseg());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void kilistaztornyok() {
		try {
			System.out.println("tornyok:");
			EpitesiTerulet e;
			for (PalyaElem tmp : palya.lekerlista()) {
				System.out.print("palyaelemid:" + tmp.lekerID());
				e = tmp.lekerEpitesiTerulet();
				System.out.print(" epitesi terulet");
				if (e.vanToronyRajta()) {
					System.out.print(" toronnyal");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void kilistazutak() {
		try {
			System.out.println("utak:");
			Ut u;
			for (PalyaElem tmp : palya.lekerlista()) {
				System.out.print("palyaelemid:" + tmp.lekerID());
				u = tmp.lekerUt();
				System.out.print(" ut");
				if (u.vanAkadalyRajta()) {
					System.out.print(" akadállyal");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
