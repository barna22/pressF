package proto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Tárolja a jégtábla adatait(szomszédok,
 * rajta álló játékosok,hószint, befagyott tárgy, iglu).
 * Lehet mozogni közöttük, felborul, ha sokan állnak rajta,
 * ki lehet ásni a tárgyat, ha nincs rajta hó.
 * (A hóval fedett lyuk egy 0 kapacitású jégtábla.)
 */
public class IceField implements Printable{
	private int snowLevel;
	private int capacity;
	private boolean hasIgloo = false;
	private Tent tent;
	private boolean capacityRevealed = false;
	private Item item;
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Player> playersInWater = new ArrayList<Player>();
	
	private Map<Integer, IceField> neighbours = new HashMap<Integer, IceField>();
	
	public IceField(int capacity, int snowLevel) {
		this.capacity = capacity;
		this.snowLevel = snowLevel;
	}
	/**
	 * Felborul a jégtábla, így minden rajta álló játékos vízbe esik.
	 */
	/*private void Capsize() {

		for (Entity entity : entities)
			entity.FallInWater(this);
		
	}*/
	
	/**
	 * Visszaadja a szomszédos jégtáblát a megadott irányba.
	 */
	public IceField GetNeighbour(int d) {
		return neighbours.get(d - 1);
	}
	
	/**
	 * Csökkenti a hóréteg vastagságát a megadott értékkel.
	 */
	public void RemoveSnow(int a) {
		//boolean visszatérési érték jelezni, hogy sikerült-e?
		if (snowLevel - a < 0)
			snowLevel = 0;
		else
			snowLevel -= a;
	}
	
	/**
	 * Növeli a hóréteget és meghívja az entitások
	 * CaughtByStorm metódusát, ha nincs a jégtáblán iglu vagy sátor.
	 */
	public void Storm() {
		snowLevel++;
		for(Entity entity : entities)
			entity.CaughtByStorm();
		
	}
	
	/**
	 * Iglut épít a jégtáblára.
	 */
	public void BuildIgloo() {
		//boolean visszatérési érték jelezni, hogy sikerült-e?
		hasIgloo = true;
	}
	
	/**
	 * Felveszi a játékost a rajta álló játékosok közé.
	 * Felborul ha, túl sokan állnak így már rajta.
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
	 * Végighívja a GetSaved(Icefield f)-et a vízben lévõ játékosokon.
	 * True-val tér vissza, ha legalább 1 játékos ki lett mentve.
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
	 * Kiveszi a playert a vízben lévõk, és az entitások listájából.
	 */
	public void Remove(Player player) {
		if (playersInWater.contains(player))
			playersInWater.remove(player);
		entities.remove(player);
	}
	
	/**
	 * Kiveszi az entitást a rajta tartózkodók listájából.
	 */
	public void Remove(Entity entity) {
		entities.remove(entity);
	}
	
	/**
	 * A kapott játékosnak kiássa a befagyott tárgyat.
	 * True-val tér vissza, ha sikerült.
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
	 * Beállítja kapott irányba levõ szomszédnak a kapott IceFieldet.
	 */
	public void AddNeighbour(int d, IceField f) {
		neighbours.put(d - 1, f);
	}
	
	/**
	 * Felfedi, hogy hányan férnek el a jégtáblán anélkül, hogy felborulna.
	 * Innentõl kezdve végig látszik.
	 */
	public void RevealCapacity() {
		capacityRevealed = true;
	}
	
	/**
	 * Visszaadja a fielden lévõ entitások számát.
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
	}
	
	public void RemoveTent() {
		this.tent = null;
	}
	
	public boolean HasStormProtection() {
		return (hasIgloo || tent != null);
	}
	
}
