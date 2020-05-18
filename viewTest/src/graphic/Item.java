package graphic;


/*
 * A használható tárgyak heterogén kollekciója.
 */
public class Item {
	/*
	 * A kapott játékos használja a tárgyat. True-val tér vissza, ha
	 * sikerült.
	 */
	protected ItemView view;
	
	public boolean Use(Player p) {
		return false;
	}
	
	/*
	 * A kapott player felveszi a tárgyat. Ha sikerül True-val tér
	 * vissza.
	 */
	public boolean Equip(Player p) {
		return p.AddItem(this);
	}
	
	/*
	 * False-al tér vissza. A leszármazottaknak van egy ugyan
	 * ilyen nevû függvényük, amiben magukból vesznek át egy példányt paraméterként és
	 * azok true-val térnek vissza. Így meg lehet nézni, hogy a kapott item ugyanolyan fajtae, mint ez.
	 */
	public boolean IsTheSame(Item i) {
		return false;
	}
	
	public ItemView GetView() {
		return view;
	}
	
	public void SetView(ItemView iv) {
		view = iv;
	}
}
