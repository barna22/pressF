package szkeleton;

import java.util.ArrayList;


public abstract class Player {
	//private int temperature;
	//private boolean isInWater;
	//private int remainingActions;
	//private boolean hasDivingGear;
	protected ArrayList<Item> items = new ArrayList<Item>();
	protected IceField field;
	protected Game game;
	
	/**
	 * Megváltoztatja a játékos hőmérsékletét.
	 */
	public void ChangeTemperature(int dif) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".ChangeTemperature(" + dif + ")");
		boolean isdead = MethodPrinter.AskQuestion("Meghalt a játékos?");
		if(isdead) {
			MethodPrinter.IncreaseIndentation();
			game.Over(false);
			MethodPrinter.DecreaseIndentation();
		}
	}
	
	
	/**
	 * A játékost megmentik, amennyiben vízben van.
	 * Ha nem volt vízben, akkor visszatér hamis értékkel.
	 * Ha vízben volt, akkor átkerül a paraméterként kapott fieldre.
	 */
	public boolean GetSaved(IceField f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".GetSaved(" + Skeleton.GetName(f) + ")");
		MethodPrinter.IncreaseIndentation();
		boolean isinwater = MethodPrinter.AskQuestion("Vízben van a játékos?");
		if(isinwater == false) {
			return false;
		}
		f.Accept(this);
		game.PlayerSaved();
		field.Remove(this);
		field = f;
		MethodPrinter.DecreaseIndentation();
		return true;
	}
	
	/**
	 * Absztrakt metódus a képesség használatára.
	 */
	public abstract void UseAbility(Direction d);
	
	/**
	 * A játékos átlép egy másik mezőre.
	 * Ha kimenne a pályáról, a program jelzi, hogy ezt nem teheti.
	 */
	public void Move(Direction d) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".UseAbility(d)");
		MethodPrinter.IncreaseIndentation();
		IceField newfield = field.GetNeighbour(d);
		if(newfield == null) {
			System.out.println("Nem lehet kimenni a pályáról!");
			return;
		}
		field.Remove(this);
		field = newfield;
		field.Accept(this);
		boolean lastaction = MethodPrinter.AskQuestion("Ez volt a játékos utolsó akciója?");
		if(lastaction) {
			game.NextPlayer();
		}
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * A játékos egy item-et használ.
	 */
	public void UseItem(Item i) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".UseItem(" + Skeleton.GetName(i) + ")");
		MethodPrinter.IncreaseIndentation();
		if(i.Use(this)) {
			boolean lastaction = MethodPrinter.AskQuestion("Ez volt a játékos utolsó akciója?");
		if(lastaction) {
			game.NextPlayer();
		}
		}
		
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * A játékos felvesz egy item-et a mezőről, ahol van.
	 */
	public void PickUpItem() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".PickUpItem()");
		MethodPrinter.IncreaseIndentation();
		if(field.TakeItem(this)) {
			boolean lastaction = MethodPrinter.AskQuestion("Ez volt a játékos utolsó akciója?");
			if(lastaction) {
				game.NextPlayer();
			}
		}
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * A játékos leszed egy hóréteget a mezejéről.
	 */
	public void Dig() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Dig()");
		MethodPrinter.IncreaseIndentation();
		field.RemoveSnow(1);
		boolean lastaction = MethodPrinter.AskQuestion("Ez volt a játékos utolsó akciója?");
		if(lastaction) {
			game.NextPlayer();
		}
		MethodPrinter.DecreaseIndentation();
	}
	
	/**
	 * Egy item bekerül a játékos eszköztárába.
	 * Ha már van nála, akkor ezt egy false értékkel jelzi.
	 */
	public boolean AddItem(Item i) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".AddItem(" + Skeleton.GetName(i) + ")");
		MethodPrinter.IncreaseIndentation();
		for(Item j : items) {
			if(j.IsTheSame(i))
				return false;
		}
		items.add(i);
		MethodPrinter.DecreaseIndentation();
		return true;
	}
	
	/**
	 * Beállítja a játékos hátralevő akcióinak számát.
	 */
	public void SetRemainingActions(int a) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".SetRemainingActions(" + a + ")");
	}
	
	/**
	 * A játékos beleesik a vízbe.
	 * Ezt a játéknak is jelzi a játékos.
	 */
	public void FallInWater() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".FallInWater()");
		MethodPrinter.IncreaseIndentation();
		game.PlayerFellInWater();
		MethodPrinter.DecreaseIndentation();
	}
	
	public void SetItemForInit(Item i) {
		items.add(i);
	}
	
	/**
	 * Get függvény a field mezőhöz.
	 */
	public IceField GetField() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".GetField()");
		return field;
	}
	
	public void SetField(IceField f) {
		field = f;
	}
	
	public void SetGame(Game g) {
		game = g;
	}

	/**
	 * Beállítja a hasDivingGear attribútum értékét.
	 */
	public void SetHasDivingGear() {
		MethodPrinter.Println(Skeleton.GetName(this) + ".SetHasDivingGear()");
	}
}