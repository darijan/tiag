package sound;

import java.util.ArrayList;

public class Dzwieki {
	
	private ArrayList<Dzwiek> sounds;
	
	public static int Chodzenie = 0;
	public static int PrzesuwanieSkrzyni = 1;
	public static int ZebranieKlucza = 2;
	public static int Zwyciestwo = 3;
	public static int Zapadka = 4;
	
	public Dzwieki() {
		sounds=new ArrayList<Dzwiek>();
		sounds.add(new Dzwiek("dzw/krok1.wav", "dzw/krok2.wav"));		//0
		sounds.add(new Dzwiek());										//1
		sounds.add(new Dzwiek("dzw/klucz1.wav", "dzw/klucz2.wav"));		//2
		sounds.add(new Dzwiek("dzw/fanfary1.wav", "dzw/fanfary2.wav"));	//3
		sounds.add(new Dzwiek("dzw/zapadka.wav"));						//4
		
	}
	
	
	public void graj(int dzwiek)
	{
		sounds.get(dzwiek).graj();
	}
}
