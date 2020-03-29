package szkeleton;


/*
 * Ezekbõl kell összegyûjteni mindhármat és használni egy helyen állva a játék megnyeréséhez.
 */
public class FlareGunPart extends Item {
	private Game game;
	
	/*
	 * Szól a Game-nek, hogy ellenõrizze a gyõzelem feltételeit. False-al tér vissza, ha nem teljesültek.
	 */
	public boolean Use(Player p) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".Use(" + Skeleton.GetName(p) + ")");
		MethodPrinter.IncreaseIndentation();
		IceField f = p.GetField();
		boolean result = game.CheckWinCondition(f);
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
	
	public void SetGameForInit(Game g) {
		game = g;
	}
}
