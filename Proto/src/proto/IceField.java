package proto;

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
	private int snowLevel;
	private int capacity;
	private boolean hasIgloo = false;
	private Tent tent;
	private boolean capacityRevealed = false;
	private Item item;
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Player> playersInWater = new ArrayList<Player>();
	
	private Map<Direction, IceField> neighbours = new HashMap<Direction, IceField>();
	
	public IceField(int capacity, int snowLevel) {
		this.capacity = capacity;
		this.snowLevel = snowLevel;
	}
	
	/**
	 * Felborul a j�gt�bla, �gy minden rajta �ll� j�t�kos v�zbe esik.
	 */
	/*private void Capsize() {

		for (Entity entity : entities)
			entity.FallInWater(this);
		
	}*/
	
	/**
	 * Visszaadja a szomsz�dos j�gt�bl�t a megadott ir�nyba.
	 */
	public IceField GetNeighbour(Direction d) {
		return neighbours.get(d);
	}
	
	/**
	 * Cs�kkenti a h�r�teg vastags�g�t a megadott �rt�kkel.
	 */
	public void RemoveSnow(int a) {
		//boolean visszat�r�si �rt�k jelezni, hogy siker�lt-e?
		if (snowLevel - a < 0)
			snowLevel = 0;
		else
			snowLevel -= a;
	}
	
	/**
	 * N�veli a h�r�teget �s megh�vja az entit�sok
	 * CaughtByStorm met�dus�t, ha nincs a j�gt�bl�n iglu vagy s�tor.
	 */
	public void Storm() {
		snowLevel++;
		
		if(!hasIgloo && tent == null)
			for(Entity entity : entities)
				entity.CaughtByStorm();
		
	}
	
	/**
	 * Iglut �p�t a j�gt�bl�ra.
	 */
	public void BuildIgloo() {
		//boolean visszat�r�si �rt�k jelezni, hogy siker�lt-e?
		hasIgloo = true;
	}
	
	/**
	 * Felveszi a j�t�kost a rajta �ll� j�t�kosok k�z�.
	 * Felborul ha, t�l sokan �llnak �gy m�r rajta.
	 */
	public void Accept(Entity incomingEntity) {
		if (entities.size() >= capacity){
			//Capsize();
			hasIgloo = false;
			tent = null;
			for (Entity entity : entities)
				entity.FallInWater(this);
			incomingEntity.FallInWater(this);
		}
		if (!hasIgloo)
			for (Entity entity : entities)
				entity.Meet(incomingEntity);
		
		entities.add(incomingEntity);
	}
	
	/**
	 * V�gigh�vja a GetSaved(Icefield f)-et a v�zben l�v� j�t�kosokon.
	 * True-val t�r vissza, ha legal�bb 1 j�t�kos ki lett mentve.
	 */
	public boolean Save(IceField f) {
		boolean success = false;
		for (int i = 0; i < playersInWater.size(); i++) {
			if(playersInWater.get(i).GetSaved(f)) {
				success = true;
				i--;
			}
		}
		return success;
	}
	
	/**
	 * Kiveszi a playert a v�zben l�v�k, �s az entit�sok list�j�b�l.
	 */
	public void Remove(Player player) {
		if (playersInWater.contains(player))
			playersInWater.remove(player);
		entities.remove(player);
	}
	
	/**
	 * Kiveszi az entit�st a rajta tart�zkod�k list�j�b�l.
	 */
	public void Remove(Entity entity) {
		entities.remove(entity);
	}
	
	/**
	 * A kapott j�t�kosnak ki�ssa a befagyott t�rgyat.
	 * True-val t�r vissza, ha siker�lt.
	 */
	public boolean TakeItem(Player p) {
		if(snowLevel > 0)
			return false;
		
		boolean success = item.Equip(p);
		if(success)
			item = null;
		
		return success;
	}
	
	/**
	 * Be�ll�tja kapott ir�nyba lev� szomsz�dnak a kapott IceFieldet.
	 */
	public void AddNeighbour(Direction d, IceField f) {
		neighbours.put(d, f);
	}
	
	/**
	 * Felfedi, hogy h�nyan f�rnek el a j�gt�bl�n an�lk�l, hogy felborulna.
	 * Innent�l kezdve v�gig l�tszik.
	 */
	public void RevealCapacity() {
		capacityRevealed = true;
	}
	
	/**
	 * Visszaadja a fielden l�v� entit�sok sz�m�t.
	 */
	public int GetNumberOfEntities() {
		return entities.size();
	}
	
	public void SetItem(Item item) {
		this.item = item;
	}
	
	
}