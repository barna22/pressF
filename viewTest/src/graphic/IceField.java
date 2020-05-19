package graphic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tárolja a jégtábla adatait(szomszédok, rajta álló játékosok,hószint,
 * befagyott tárgy, iglu). Lehet mozogni közöttük, felborul, ha sokan állnak
 * rajta, ki lehet ásni a tárgyat, ha nincs rajta hó. (A hóval fedett lyuk egy 0
 * kapacitású jégtábla.)
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

	private List<Updatable> updatables = new ArrayList<Updatable>();

	private Map<Direction, IceField> neighbours = new HashMap<Direction, IceField>();

	public void UpdateViews() {
		for (Updatable updatable : updatables)
			updatable.Update();
	}

	public IceField(int capacity, int snowLevel) {
		this.capacity = capacity;
		this.snowLevel = snowLevel;
	}

	/**
	 * Visszaadja a szomszédos jégtáblát a megadott irányba.
	 */
	public IceField GetNeighbour(Direction d) {
		return neighbours.get(d);
	}

	/**
	 * Csökkenti a hóréteg vastagságát a megadott értékkel.
	 */
	public boolean RemoveSnow(int a) {
		if (snowLevel == 0)
			return false;
		if (snowLevel - a < 0)
			snowLevel = 0;
		else
			snowLevel -= a;
		UpdateViews();
		return true;
	}

	/**
	 * Növeli a hóréteget és meghívja az entitások CaughtByStorm metódusát, ha nincs
	 * a jégtáblán iglu vagy sátor.
	 */
	public void Storm() {
		snowLevel++;
		for (Entity entity : entities)
			entity.CaughtByStorm();
		UpdateViews();
		// Animáció

	}

	/**
	 * Iglut épít a jégtáblára.
	 */
	public boolean BuildIgloo() {
		if (hasIgloo == true)
			return false;
		hasIgloo = true;
		UpdateViews();
		return true;
	}

	/**
	 * Felveszi a játékost a rajta álló entitások közé. Felborul ha, túl sokan
	 * állnak így már rajta.
	 */
	public void Accept(Player incomingPlayer) {
		if (entities.size() >= capacity) {
			hasIgloo = false;
			tent = null;
			snowLevel = 0;
			for (Entity entity : entities)
				entity.FallInWater(this);
			incomingPlayer.FallInWater(this);
		}
		if (!hasIgloo)
			for (Entity entity : entities)
				entity.Meet(incomingPlayer);

		entities.add(incomingPlayer);
		UpdateViews();
	}

	/**
	 * Hozzáadja a játékost a vízben lévõk listájához.
	 */
	public void FellInWater(Player p) {
		playersInWater.add(p);
	}

	/**
	 * Felveszi a játékost a rajta álló entitások közé. Felborul ha, túl sokan
	 * állnak így már rajta.
	 */
	public void Accept(IceBear incomingIceBear) {
		if (entities.size() >= capacity) {
			hasIgloo = false;
			tent = null;
			for (Entity entity : entities)
				entity.FallInWater(this);
			incomingIceBear.FallInWater(this);
		}

		entities.add(incomingIceBear);
		UpdateViews();

		if (!hasIgloo)
			for (Entity entity : entities)
				entity.Meet(incomingIceBear);
	}

	/**
	 * Felveszi az entitást a rajta álló entitások közé. Inicializáláshoz kell.
	 */
	public void AddEntityForInit(Entity entity) {
		entities.add(entity);
	}

	/**
	 * Végighívja a GetSaved(Icefield f)-et a vízben lévõ játékosokon. True-val tér
	 * vissza, ha legalább 1 játékos ki lett mentve.
	 */
	public boolean Save(IceField f) {
		boolean success = false;
		for (int i = 0; i < playersInWater.size(); i++) {
			if (playersInWater.get(i).GetSaved(f)) {
				success = true;
				i--;
			}
		}
		if (success)
			UpdateViews();
		return success;
	}

	/**
	 * Kiveszi a playert a vízben lévõk, és az entitások listájából.
	 */
	public void Remove(Player player) {
		if (playersInWater.contains(player))
			playersInWater.remove(player);
		entities.remove(player);
		UpdateViews();
	}

	/**
	 * Kiveszi az entitást a rajta tartózkodók listájából.
	 */
	public void Remove(Entity entity) {
		entities.remove(entity);
		UpdateViews();
	}

	/**
	 * A kapott játékosnak odaadja a befagyott tárgyat. True-val tér vissza, ha
	 * sikerült.
	 */
	public boolean TakeItem(Player p) {
		if (snowLevel > 0 || item == null)
			return false;

		boolean success = item.Equip(p);
		if (success) {
			item = null;
			UpdateViews();
		}

		return success;
	}

	/**
	 * Beállítja kapott irányba levõ szomszédnak a kapott IceFieldet.
	 */
	public void AddNeighbour(Direction d, IceField f) {
		neighbours.put(d, f);
	}

	/**
	 * Felfedi, hogy hányan férnek el a jégtáblán anélkül, hogy felborulna. Innentõl
	 * kezdve végig látszik.
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
		UpdateViews();
	}

	public void RemoveTent() {
		this.tent = null;
	}

	public boolean HasIgloo() {
		return hasIgloo;
	}

	public boolean HasTent() {
		return tent != null;
	}

	public List<Entity> GetEntities() {
		return entities;
	}

	public List<Player> GetPlayersInWater() {
		return playersInWater;
	}

	public ArrayList<IceField> getNeighbours() {
		ArrayList<IceField> fields = new ArrayList<IceField>();
		for (Direction key : neighbours.keySet()) {
			fields.add(neighbours.get(key));
		}
		return fields;
	}

	public void addFieldView(Updatable fieldView) {
		updatables.add(fieldView);
	}

	public void removeFieldView(Updatable fieldView) {
		updatables.remove(fieldView);
	}

	public boolean isCapacityRevealed() {
		return capacityRevealed;
	}

	public int getSnowLevel() {
		return snowLevel;
	}
}
