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
public class IceField{
	private int snowLevel;
	private int capacity;
	private boolean hasIgloo = false;
	private Tent tent;
	private boolean capacityRevealed = false;
	private Item item;
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Player> playersInWater = new ArrayList<Player>();
	
	private FieldView fieldView;
	
	private Map<Integer, IceField> neighbours = new HashMap<Integer, IceField>();
	
	public IceField(int capacity, int snowLevel) {
		this.capacity = capacity;
		this.snowLevel = snowLevel;
	}
	
	/**
	 * Visszaadja a szomsz�dos j�gt�bl�t a megadott ir�nyba.
	 */
	public IceField GetNeighbour(int d) {
		return neighbours.get(d - 1);
	}
	
	/**
	 * Cs�kkenti a h�r�teg vastags�g�t a megadott �rt�kkel.
	 */
	public boolean RemoveSnow(int a) {
		if (snowLevel == 0)
			return false;
		if (snowLevel - a < 0)
			snowLevel = 0;
		else
			snowLevel -= a;
		fieldView.draw();
		return true;
	}
	
	/**
	 * N�veli a h�r�teget �s megh�vja az entit�sok
	 * CaughtByStorm met�dus�t, ha nincs a j�gt�bl�n iglu vagy s�tor.
	 */
	public void Storm() {
		snowLevel++;
		for(Entity entity : entities)
			entity.CaughtByStorm();
		//Anim�ci�
		
	}
	
	/**
	 * Iglut �p�t a j�gt�bl�ra.
	 */
	public boolean BuildIgloo() {
		if (hasIgloo == true)
			return false;
		hasIgloo = true;
		fieldView.draw();
		return true;
	}
	
	/**
	 * Felveszi a j�t�kost a rajta �ll� entit�sok k�z�.
	 * Felborul ha, t�l sokan �llnak �gy m�r rajta.
	 */
	public void Accept(Player incomingPlayer) {
		if (entities.size() >= capacity){
			//Capsize();
			hasIgloo = false;
			tent = null;
			for (Entity entity : entities)
				entity.FallInWater(this);
			incomingPlayer.FallInWater(this);
			playersInWater.add(incomingPlayer);
		}
		if (!hasIgloo)
			for (Entity entity : entities)
				entity.Meet(incomingPlayer);
		
		entities.add(incomingPlayer);
		//fieldView.draw();
	}
	/**
	 * Felveszi a j�t�kost a rajta �ll� entit�sok k�z�.
	 * Felborul ha, t�l sokan �llnak �gy m�r rajta.
	 */
	public void Accept(IceBear incomingIceBear) {
		if (entities.size() >= capacity){
			//Capsize();
			hasIgloo = false;
			tent = null;
			for (Entity entity : entities)
				entity.FallInWater(this);
			incomingIceBear.FallInWater(this);
		}
		if (!hasIgloo)
			for (Entity entity : entities)
				entity.Meet(incomingIceBear);
		
		entities.add(incomingIceBear);
		//fieldView.draw();
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
		if (success)
			fieldView.draw();
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
	public void AddNeighbour(int d, IceField f) {
		neighbours.put(d - 1, f);
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
	public Item GetItem() {
		return item;
	}
	public int GetCapacity() {
		return capacity;
	}
	
	public void SetCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void SetSnowLevel(int snowLevel) {
		this.snowLevel = snowLevel;
	}
	public int GetNumberOfNeighbours() {
		return neighbours.size();
	}
	
	public void SetTent(Tent tent) {
		this.tent = tent;
		fieldView.draw();
	}
	
	public void RemoveTent() {
		this.tent = null;
	}
	
	public boolean HasStormProtection() {
		return (hasIgloo || tent != null);
	}
	

	public ArrayList<IceField> getNeighbours(){
		ArrayList<IceField> fields = new ArrayList<IceField>();
		for (int key: neighbours.keySet()) {
		    fields.add(neighbours.get(key));
		}
		return fields;
	}

	public void addFieldView(FieldView fieldView) {
		this.fieldView = fieldView;
	}
}
