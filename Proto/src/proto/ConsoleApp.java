package proto;

import java.util.HashMap;
import java.util.Map;

public class ConsoleApp{
	
	public enum NameFormat{
		NAMEONLY,
		TYPEONLY,
		NAMEANDTYPE
	}
	
	private static NameFormat nameFormat = NameFormat.NAMEANDTYPE;
	
	public void SetNameFormat(NameFormat nameFormat) {
		ConsoleApp.nameFormat = nameFormat;
	}
	
	//Visszaadja az objektumhoz tartozó változó nevet
	public static String GetName(Object o) {
		String name;
		switch(nameFormat) {
		case NAMEONLY:
			name = nameMap.get(o);
			break;
		case TYPEONLY:
			name = o.getClass().getSimpleName();
			break;
		case NAMEANDTYPE:
			name = o.getClass().getSimpleName() + " " + nameMap.get(o);
			break;
		default:
			name = o.getClass().getSimpleName() + " " + nameMap.get(o);
		}
		return name;
	}
	
	//Map a GetName-nek
	private static Map<Object, String> nameMap;
	
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
	
	public void Info() {
		
	}
	
	public void SetRandom() {
		
	}
	
	public void Dig() {
		
	}
	
	public void PickUpItem() {
		
	}
	
	public void Save() {
		
	}
	
	public void AddItem() {
		
	}
}