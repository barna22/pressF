package proto;

import java.util.Map;

public class ConsoleApp{
	
<<<<<<< HEAD
	private Game game;
	public enum NameFormat{
		NAMEONLY,
		TYPEONLY,
		NAMEANDTYPE
	}
	
	private static NameFormat nameFormat = NameFormat.NAMEANDTYPE;
	
	public void SetNameFormat(NameFormat nameFormat) {
		ConsoleApp.nameFormat = nameFormat;
	}
	
=======
>>>>>>> 352fd8652048621f9793740c8df57cc57bbedeb1
	//Visszaadja az objektumhoz tartozó változó nevet
	public static String GetName(Object o) {
		return nameMap.get(o);
	}
	
	//Map a GetName-nek
	private static Map<Object, String> nameMap;
	
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