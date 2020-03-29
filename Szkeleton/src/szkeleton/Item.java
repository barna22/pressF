package szkeleton;


/*
 * A használható tárgyak heterogén kollekciója.
 */
public class Item {
	/*
	 * A kapott játékos használja a tárgyat. True-val tér vissza, ha
	 * sikerült.
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(p) + ")");
		return false;
	}
	
	/*
	 * A kapott player felveszi a tárgyat. Ha sikerül True-val tér
	 * vissza.
	 */
	public boolean Equip(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Equip(" + Skeleton.GetName(p) + ")");
		boolean result;
		MethodPrinter.IncreaseIndentation();
		result =  p.AddItem(this);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	/*
	 * False-al tér vissza. A leszármazottaknak van egy ugyan
	 * ilyen nevû függvényük, amiben magukból vesznek át egy példányt paraméterként és
	 * azok true-val térnek vissza. Így meg lehet nézni, hogy a kapott item ugyanolyan fajtae, mint ez.
	 */
	public boolean IsTheSame(Item i) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(i) + ")");
		return false;
	}
}
