package proto;

import java.util.Map;

public class ConsoleApp{
	
	private Game game;
	
	//Visszaadja az objektumhoz tartozó változó nevet
	public static String GetName(Object o) {
		return nameMap.get(o);
	}
	
	//Map a GetName-nek
	private static Map<Object, String> nameMap;
	
	public void Init() {
		game = new Game();
	}
	
	public void CreateField(String name, int snow, int capacity) {
		IceField field = new IceField(capacity, snow);
		nameMap.put(field, name);
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
		nameMap.put(entity, name);
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
		nameMap.put(item, name);
	}
	
	public void UseItem(Item item) {
		game.GetActivePlayer().UseItem(item);
	}
	
	public void UseAbility(int dir) {
		game.GetActivePlayer().UseAbility(dir);
	}
	//----
	public void Move() {
		
	}
	
	public void MoveBear() {
		
	}
	
	public void PlaceIgloo() {
		
	}
	
	public void SetActivePlayer() {
		
	}
	
	public void SetActions() {
		
	}
	
	public void SetTemp() {
		
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