package proto;

import java.util.HashMap;
import java.util.Map;

public class ConsoleApp{
	
	private Game game;

	//Visszaadja az objektumhoz tartozó változó nevet
	public static String GetName(Object o) {
		return nameMap.get(o);
	}
	
	//Visszaadja a névhez tartozó változót
	public static Object GetObject(String name) {
		return objectMap.get(name);
	}
	
	//eltárolja a név objektum párost
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
	
	public void ReadCommand() {
		
	}
	
	public void CreateField() {
		
	}
	
	public void SetNeighbour() {
		
	}
	
	public void CreateEntity() {
		
	}
	
	public void CreateItem() {
		
	}
	
	public void UseItem() {
		
	}
	
	public void UseAbility() {
		
	}
	
	public void Move(int d) {
		Player player = game.GetActivePlayer();
		player.Move(d);
	}
	
	public void MoveBear(String name, int d) {
		IceBear bear = nameMap
		bear.Move(d);
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