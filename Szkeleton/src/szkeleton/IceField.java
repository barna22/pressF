package szkeleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * T�rolja a j�gt�bla adatait(szomsz�dok,
 * rajta �ll� j�t�kosok,h�szint, befagyott t�rgy, iglu).
 * Lehet mozogni k�z�tt�k, felborul, ha sokan �llnak rajta,
 * ki lehet �sni a t�rgyat, ha nincs rajta h�.
 * (A h�val fedett lyuk egy 0 kapacit�s� j�gt�bla.)
 */
public class IceField {
	//private int snowLevel;
	//private int capacity;
	//private boolean hasIgloo;
	//private boolean capacityRevealed
	private Item item;
	private List<Player> players = new ArrayList<Player>();
	private Map<Direction, IceField> neighbours = new HashMap<Direction, IceField>();
	
	/**
	 * Felborul a j�gt�bla, �gy minden rajta �ll� j�t�kos v�zbe esik.
	 */
	private void Capsize() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Capsize()");
		MethodPrinter.IncreaseIndentation();
		
		for (Player player : players)
			player.FallInWater();
			//Hi�nyz� met�dus a playerb�l.
		
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * Visszaadja a szomsz�dos j�gt�bl�t a megadott ir�nyba.
	 */
	public IceField GetNeighbour(Direction d) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".GetNeighbour(d)");
		
		return neighbours.get(d);
	}
	
	/**
	 * Cs�kkenti a h�r�teg vastags�g�t a megadott �rt�kkel.
	 */
	public void RemoveSnow(int a) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".RemoveSnow(" + a + ")");
	}
	
	/**
	 * N�veli a h�r�teget �s cs�kkenti a rajtalev� j�t�kosok testh�j�t,
	 * ha nincs a j�gt�bl�n iglu.
	 */
	public void Storm() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Storm()");
		MethodPrinter.IncreaseIndentation();
		
		if(!MethodPrinter.AskQuestion("Van a mez�n iglu?"))
			for(Player player : players)
				player.ChangeTemperature(-1);
		
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * Iglut �p�t a j�gt�bl�ra.
	 */
	public void BuildIgloo() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".BuildIgloo()");
	}
	
	/**
	 * Felveszi a j�t�kost a rajta �ll� j�t�kosok k�z�.
	 * Felborul ha, t�l sokan �llnak �gy m�r rajta.
	 */
	public void Accept(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Accept(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		
		players.add(p);
		if(MethodPrinter.AskQuestion("T�l sokan �llnak a j�gt�bl�n?"))
			Capsize();
		
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * V�gigh�vja a GetSaved(Icefield f)-et a rajta �ll� j�t�kosokon.
	 * True-val t�r vissza, ha legal�bb 1 j�t�kos ki lett mentve.
	 */
	public boolean Save(IceField f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Save(" + Skeleton.GetName(f) + ")");
		MethodPrinter.IncreaseIndentation();
		
		boolean success = false;
		for (int i = 0; i < players.size(); i++) {
			if(players.get(i).GetSaved(f)) {
				success = true;
				i--;
			}
		}
		MethodPrinter.DecreaseIndentation();
		
		return success;
	}
	
	/**
	 * Kiveszi a j�t�kost a rajta �ll�k list�j�b�l.
	 */
	public void Remove(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Remove(" + Skeleton.GetName(p) + ")");
		
		players.remove(p);
	}
	
	/**
	 * A kapott j�t�kosnak ki�ssa a befagyott t�rgyat.
	 * True-val t�r vissza, ha siker�lt.
	 */
	public boolean TakeItem(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".TakeItem(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		
		if(MethodPrinter.AskQuestion("Van h� a mez�n?"))
			return false;
		
		boolean success = item.Equip(p);
		if(success)
			item = null;
		
		MethodPrinter.DecreaseIndentation();
		
		return success;
	}
	
	/**
	 * Be�ll�tja kapott ir�nyba lev� szomsz�dnak a kapott IceFieldet.
	 */
	public void AddNeighbour(Direction d, IceField f) {
		//MethodPrinter.Println(Skeleton.GetName(this) + ".AddNeighbour(d, " + Skeleton.GetName(f) + ")");
		
		neighbours.put(d, f);
	}
	
	/**
	 * Felfedi, hogy h�nyan f�rnek el a j�gt�bl�n an�lk�l, hogy felborulna.
	 * Innent�l kezdve v�gig l�tszik.
	 */
	public void RevealCapacity() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".RevealCapacity()");
	}
	
	/**
	 * Visszaadja a fielden l�v� j�t�kosok sz�m�t.
	 */
	public int GetNumberOfPlayers() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".GetNumberOfPlayers()");
		return players.size();
	}
	
	public void SetItem(Item item) {
		//MethodPrinter.Println(Skeleton.GetName(this) + ".SetItem("  + Skeleton.GetName(item) + ")");
		this.item = item;
	}
	
	/**
	 * Csak a skeletonba kell inicializ�l�shoz, v�gleges programban nem lesz.
	 */
	public void AddPlayerForInit(Player player) {
		this.players.add(player);
		player.SetField(this);
	}
}
