package allelustwillewigkeit.twotowers.prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrototypeController {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (ir);
		String s = new String();
		while(true){
			s = br.readLine();
			String[] cmd = s.split(" ");
			if(cmd != null && cmd.length != 0){
				switch(cmd[0]){
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
					
				}
			}
		}
	}

	private static void utOsszekapcsol(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int utID = Integer.parseInt(cmd[2]);
		
	}

	private static void vegzetHegyeLerak(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int utID = Integer.parseInt(cmd[2]);
	}

	private static void startLerak(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int utID = Integer.parseInt(cmd[2]);
	}

	private static void utLerak(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int utID = Integer.parseInt(cmd[2]);
	}

	private static void epitesiTeruletLerak(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int epitesiTeruletID = Integer.parseInt(cmd[2]);
	}

	private static void palyaElemOsszekapcsol(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID1 = Integer.parseInt(cmd[1]);
		int palyaElemID2 = Integer.parseInt(cmd[2]);
	}

	private static void palyaElemKeszit(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
	}

	private static void palyaSzerkeszt(String[] cmd) {
		// TODO Auto-generated method stub
		String muvelet = cmd[1];
	}

	private static void reset(String[] cmd) {
		// TODO Auto-generated method stub
		
	}

	private static void show(String[] cmd) {
		// TODO Auto-generated method stub
		String muvelet = cmd[1];
	}

	private static void elkodosit(String[] cmd) {
		// TODO Auto-generated method stub
		int toronyID = Integer.parseInt(cmd[1]);
	}

	private static void lekerHanyEllensegVanMeg(String[] cmd) {
		// TODO Auto-generated method stub
		
	}

	private static void allitHanyEllensegVanMeg(String[] cmd) {
		// TODO Auto-generated method stub
		int ertek = Integer.parseInt(cmd[1]);
	}

	private static void tick(String[] cmd) {
		// TODO Auto-generated method stub
		int hanyszor = Integer.parseInt(cmd[1]);
	}

	private static void kilistazMap(String[] cmd) {
		// TODO Auto-generated method stub
		
	}

	private static void torpIndit(String[] cmd) {
		// TODO Auto-generated method stub
		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void tundeIndit(String[] cmd) {
		// TODO Auto-generated method stub
		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void hobbitIndit(String[] cmd) {
		// TODO Auto-generated method stub
		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void emberIndit(String[] cmd) {
		// TODO Auto-generated method stub
		int intSzint = Integer.parseInt(cmd[1]);
		int intDarab = Integer.parseInt(cmd[2]);
	}

	private static void hullamIndit(String[] cmd) {
		// TODO Auto-generated method stub
		int intSzint = Integer.parseInt(cmd[1]);
		int kezdoID = Integer.parseInt(cmd[2]);
	}

	private static void hullamOsszetetelRandom(String[] cmd) {
		// TODO Auto-generated method stub
		String muvelet = cmd[1];
	}

	private static void varazskoListaz(String[] cmd) {
		// TODO Auto-generated method stub
		
	}

	private static void varazskoLerak(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int varazskoDictID = Integer.parseInt(cmd[2]);
		int varazskoID = Integer.parseInt(cmd[3]);
		
	}

	private static void akadalyLerak(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int akadalyID = Integer.parseInt(cmd[2]);
		
	}

	private static void toronyLerak(String[] cmd) {
		// TODO Auto-generated method stub
		int palyaElemID = Integer.parseInt(cmd[1]);
		int toronyID = Integer.parseInt(cmd[2]);
		
	}

	private static void fajlbaIr(String[] cmd) {
		// TODO Auto-generated method stub
		String muvelet = cmd[1];
		String utvonal = null;
		if(cmd.length == 3){
			 utvonal = cmd[2];
		}
	}

	private static void betoltUtasitasok(String[] cmd) {
		// TODO Auto-generated method stub
		String utvonal = cmd[1];
	}

}
