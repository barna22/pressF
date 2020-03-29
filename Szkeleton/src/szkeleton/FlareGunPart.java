package szkeleton;


/*
 * Ezekbõl kell összegyûlyteni mindhármat és használni egy helyen állva a játék megnyeréséhez.
 */
public class FlareGunPart extends Item {
	private Game game;
	
	/*
	 * Megnézi, hogy teljesülnek-e a gyõzelem feltételei és jelez a
	 * Game-nek, ha igen. True-val tér vissza, ha sikerült használni.
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Use(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		IceField f = p.GetField();
		boolean result = false;
		if(game.IsEveryoneHere(f))
			result = f.CountGunParts(this);
		MethodPrinter.DecreaseIndentation();
		return result;
	}
	
	/*
	 * True-val tér vissza.
	 */
	public boolean IsTheSame(FlareGunPart f) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".IsTheSame(" + Skeleton.GetName(f) + ")");
		return true;
	}
	
	/*
	 * Ugyanazt csinálja, mint az Item, csak meghívj a game-n egy FlareGunPartFound()
	 * nevû metódust, ami csökkenti a hátralévõ gunpartok számát eggyel.
	 */
	public boolean Equip(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Equip(" + Skeleton.GetName(p) + ")");
		boolean result;
		MethodPrinter.IncreaseIndentation();
		result =  p.AddItem(this);
		if(result)
			game.FlareGunPartFound();
		MethodPrinter.DecreaseIndentation();
		return result;
	}
}
