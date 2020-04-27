package proto;

import java.util.ArrayList;


public abstract class Player extends Entity {
	protected int temperature;
	protected boolean isInWater;
	protected int remainingActions;
	protected boolean hasDivingGear;
	protected ArrayList<Item> items = new ArrayList<Item>();
	protected Game game;
	
	/**
	 * Megváltoztatja a játékos hőmérsékletét.
	 */
	public void ChangeTemperature(int dif) {
		temperature += dif;
		if(temperature <= 0) {
			game.Over(false);
		}
	}
	
	public void CaughtByStorm() {
		if(!field.HasStormProtection()) {
			temperature -= 1;
		}
		if(temperature <= 0) {
			game.Over(false);
		}
	}
	
	public void Die() {
		game.Over(false);
	}
	
	
	/**
	 * A játékost megmentik, amennyiben vízben van.
	 * Ha nem volt vízben, akkor visszatér hamis értékkel.
	 * Ha vízben volt, akkor átkerül a paraméterként kapott fieldre.
	 */
	public boolean GetSaved(IceField f) {
		if(isInWater == false) {
			return false;
		}
		f.Accept(this);
		game.PlayerSaved();
		field.Remove(this); //úgy írtam a field Remove-ját, hogy itt ne kelljen még külön a vízben lévők közül is kiszedni
		field = f;
		return true;
	}
	
	/**
	 * Absztrakt metódus a képesség használatára.
	 */
	public abstract void UseAbility(int d);
	
	/**
	 * A játékos átlép egy másik mezőre.
	 * Ha kimenne a pályáról, a program jelzi, hogy ezt nem teheti.
	 */
	public void Move(int d) {
		IceField newfield = field.GetNeighbour(d);
		if(newfield == null) {
			System.out.println("Can't go outside the map!");
			return;
		}
		field.Remove(this);
		field = newfield;
		field.Accept(this);
		remainingActions -= 1;
		if(remainingActions <= 0) {
			game.NextPlayer();
		}
	}
	
	/**
	 * A játékos egy item-et használ.
	 */
	public void UseItem(Item i) {
		remainingActions -= 1;
		if(remainingActions == 0) {
			game.NextPlayer();
		}
		i.Use(this);
	}
	
	/**
	 * A játékos felvesz egy item-et a mezőről, ahol van.
	 */
	public void PickUpItem() {
		if(field.TakeItem(this)) {
			remainingActions -= 1;
			if(remainingActions <= 0) {
				game.NextPlayer();
			}
		}
	}
	
	/**
	 * A játékos leszed egy hóréteget a mezejéről.
	 */
	public void Dig() {
		field.RemoveSnow(1);
		remainingActions -= 1;
		if(remainingActions == 0) {
			game.NextPlayer();
		}
	}
	
	/**
	 * Egy item bekerül a játékos eszköztárába.
	 * Ha már van nála, akkor ezt egy false értékkel jelzi.
	 */
	public boolean AddItem(Item i) {
		for(Item j : items) {
			if(j.IsTheSame(i))
				return false;
		}
		items.add(i);
		return true;
	}
	
	public boolean RemoveItem(Item i) {
		return items.remove(i);
	}
	
	public void PrintInfo() {
		System.out.println("Field: " + ConsoleApp.GetName(field));
		System.out.println("Temperature : " + temperature);
		System.out.println("Isinwater: " + isInWater);
		System.out.println("Remainingactions: " + remainingActions);
		System.out.println("Hasdivingear: " + hasDivingGear);
		for(Item i : items) {
			System.out.println("Item" + items.indexOf(i) + ": " + ConsoleApp.GetName(i));
		}
	}
	
	/**
	 * Beállítja a játékos hátralevő akcióinak számát.
	 */
	public void SetRemainingActions(int a) {
		remainingActions = a;
	}
	
	/**
	 * A játékos beleesik a vízbe.
	 * Ezt a játéknak is jelzi a játékos.
	 */
	public void FallInWater(IceField field) {
		isInWater = true;
		game.PlayerFellInWater();
	}
	
	public void SetItemForInit(Item i) {
		items.add(i);
	}
	
	/**
	 * Get függvény a field mezőhöz.
	 */
	public IceField GetField() {
		return field;
	}
	
	public int GetTemp() {
		return temperature;
	}
	
	public boolean GetIsInWater() {
		return isInWater;
	}
	
	public int GetRemaningActions() {
		return remainingActions;
	}
	
	public boolean GetHasDivingGear() {
		return hasDivingGear;
	}
	
	public void SetGame(Game g) {
		game = g;
	}
	
	public void SetTemperature(int value) {
		temperature = value;
	}

	/**
	 * Beállítja a hasDivingGear attribútum értékét.
	 */
	public void SetHasDivingGear(boolean value) {
		hasDivingGear = value;
	}

	public void DisplayItems() {
		for(Item i : items) {
			System.out.println("Item" + items.indexOf(i) + ": " + ConsoleApp.GetName(i));
		}
	}
}