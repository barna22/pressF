package proto;

import java.util.HashMap;
import java.util.Map;

public class ConsoleApp{

	private Game game;

	//Visszaadja az objektumhoz tartoz� v�ltoz� nevet
	public static String GetName(Object o) {
		return nameMap.get(o);
	}
	
	//Visszaadja a n�vhez tartoz� v�ltoz�t
	public static Object GetObject(String name) {
		return objectMap.get(name);
	}

	//elt�rolja a n�v objektum p�rost
	public static void put(Object o, String name) {
		nameMap.put(o, name);
		objectMap.put(name, o);
	}

	//Map a GetName-nek
	private static Map<Object, String> nameMap = new HashMap<Object, String>();
	private static Map<String, Object> objectMap = new HashMap<String, Object>();

	public void Init() {
		game = new Game();
	}

	public void CreateField(String name, int snow, int capacity) {
		IceField field = new IceField(capacity, snow);
		put(field, name);
		game.AddField(field);
	}

	public void SetNeighbour(IceField f1, int dir1, IceField f2, int dir2) {
		f1.AddNeighbour(dir1, f2);
		f2.AddNeighbour(dir2, f1);
	}

	public void CreateEntity(String name, String type, IceField field) {
		Entity entity;
		switch(type) {
			default://medve
				entity = new IceBear();
				game.AddBear((IceBear)entity);
				break;
			case "researcher":
				entity = new Researcher();
				game.AddPlayer((Researcher)entity);
				break;
			case "eskimo":
				entity = new Eskimo();
				game.AddPlayer((Eskimo)entity);
				break;
		}
		put(entity, name);
	}

	public void CreateItem(String name, String type, IceField field) {
		Item item;
		switch(type) {
			default://breakableShovel
				item = new BreakableShovel();
				break;
			case "divinggear":
				item = new DivingGear();
				break;
			case "flaregunpart":
				item = new FlareGunPart();
				break;
			case "food":
				item = new Food();
				break;
			case "rope":
				item = new Rope();
				break;
			case "shovel":
				item = new Shovel();
				break;
			case "tent":
				item = new Tent();
				break;
		}
		field.SetItem(item);
		put(item, name);
	}

	public void UseItem(Item item) {
		game.GetActivePlayer().UseItem(item);
	}

	public void UseAbility(int dir) {
		game.GetActivePlayer().UseAbility(dir);
	}

	public void Move(int d) {
		Player player = game.GetActivePlayer();
		player.Move(d);
	}

	public void MoveBear(String name, int d) {
		IceBear bear = (IceBear)objectMap.get(name);
		bear.Move(d);
	}

	public void PlaceIgloo(String name) {
		IceField field = (IceField)objectMap.get(name);
		field.BuildIgloo();
	}

	public void SetActivePlayer(String name) {
		Player player = (Player)objectMap.get(name);
		game.SetActivePlayer(player);
	}

	public void SetActions(int actions) {
		game.GetActivePlayer().SetRemainingActions(actions);
	}

	public void SetTemp(int temperature) {
		game.GetActivePlayer().SetTemperature(temperature);
	}

	public void Info(String name) {

	}

	public void SetRandom() {

	}

	public void Dig() {
		game.GetActivePlayer().Dig();
	}

	public void PickUpItem() {
		game.GetActivePlayer().PickUpItem();
	}

	public void Save() {

	}

	public void AddItem(String playername, String itemname) {
		Item newitem;
		switch (itemname) {
		case ""
		}
		p.AddItem(i);
	}
}
