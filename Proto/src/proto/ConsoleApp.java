package proto;

import java.util.HashMap;
import java.util.Map;

public class ConsoleApp{

	private Game game;
	private static boolean random = true;

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

	public static boolean GetRandom() {
		return random;
	}
	
	//Map a GetName-nek
	private static Map<Object, String> nameMap = new HashMap<Object, String>();
	private static Map<String, Object> objectMap = new HashMap<String, Object>();

	public void Init() {
		game = new Game();
	}

	public void CreateField(String name, String snow, String capacity) {
		
		IceField field = new IceField(Integer.parseInt(capacity), Integer.parseInt(snow));
		put(field, name);
		game.AddField(field);
	}

	public void SetNeighbour(String fieldName1, String dir1, String fieldName2, String dir2) {
		IceField f1 = (IceField)objectMap.get(fieldName1);
		IceField f2 = (IceField)objectMap.get(fieldName2);
		f1.AddNeighbour(Integer.parseInt(dir1), f2);
		f2.AddNeighbour(Integer.parseInt(dir2), f1);
	}

	public void CreateEntity(String name, String type, String field) {
		IceField fi = (IceField)GetObject(field);
		Entity entity;
		switch(type) {
			default://medve
				entity = new IceBear();
				fi.Accept((IceBear)entity);
				game.AddBear((IceBear)entity);
				break;
			case "researcher":
				entity = new Researcher();
				fi.Accept((Researcher)entity);
				game.AddPlayer((Researcher)entity);
				break;
			case "eskimo":
				entity = new Eskimo();
				fi.Accept((Eskimo)entity);
				game.AddPlayer((Eskimo)entity);
				break;
		}
		put(entity, name);
		entity.SetField(fi);
	}

	public void CreateItem(String type, String field, String name) {
		Item item;
		IceField fi = (IceField)GetObject(field);
		switch(type) {
			default://breakableShovel
				item = new BreakableShovel();
				break;
			case "divinggear":
				item = new DivingGear();
				break;
			case "flaregunpart":
				FlareGunPart flaregun = new FlareGunPart();
				flaregun.SetGame(game);
				item = flaregun;
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
		fi.SetItem(item);
		put(item, name);
	}

	public void UseItem(String item) {
		Item it = (Item)GetObject(item);
		game.GetActivePlayer().UseItem(it);
	}

	public void UseAbility(String dir) {
		game.GetActivePlayer().UseAbility(Integer.parseInt(dir));
	}

	public void Move(String d) {
		Player player = game.GetActivePlayer();
		player.Move(Integer.parseInt(d));
	}

	public void MoveBear(String name, String d) {
		IceBear bear = (IceBear)objectMap.get(name);
		bear.Move(Integer.parseInt(d));
	}

	public void PlaceIgloo(String name) {
		IceField field = (IceField)objectMap.get(name);
		field.BuildIgloo();
	}

	public void SetActivePlayer(String name) {
		Player player = (Player)objectMap.get(name);
		game.SetActivePlayer(player);
	}

	public void SetActions(String actions) {
		game.GetActivePlayer().SetRemainingActions(Integer.parseInt(actions));
	}

	public void SetTemp(String temperature) {
		game.GetActivePlayer().SetTemperature(Integer.parseInt(temperature));
	}

	public void Info(String name) {
		if(name.equals("game")) {
			game.PrintInfo();
		}else {
			Printable p = (Printable)objectMap.get(name);
			p.PrintInfo();
		}
		
	}

	public void SetRandom(String value) {
		if(value.equals("true")) {
			random = true;
		}
		if(value.equals("false")) {
			random = false;
		}
	}

	public void Dig() {
		game.GetActivePlayer().Dig();
	}

	public void PickUpItem() {
		game.GetActivePlayer().PickUpItem();
	}

	public void AddItem(String playerName, String type, String itemName) {
		Item newitem = new Item();
		Player p = (Player)objectMap.get(playerName);
		switch (type) {
		case "shovel":
			newitem = new Shovel();
			break;
		case "rope":
			newitem = new Rope();
			break;
		case "divinggear":
			newitem = new DivingGear();
			p.SetHasDivingGear(true);
			break;
		case "flaregunpart":
			FlareGunPart flaregun = new FlareGunPart();
			flaregun.SetGame(game);
			newitem = flaregun;
			break;
		case "food":
			newitem = new Food();
			break;
		case "tent":
			newitem = new Tent();
			break;
		case "breakableshovel":
			newitem = new BreakableShovel();
			break;
		}
		newitem.Equip(p);
		put(newitem, itemName);
	}
	public void Storm() {
		game.Storm();
	}
}
