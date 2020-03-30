package szkeleton;

public class Eskimo extends Player {
	
	/**
	 * Az eszkimó használja a képességét, mellyel épít egy iglut.
	 */
	public void UseAbility(Direction d) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".UseAbility(d)");
		MethodPrinter.IncreaseIndentation();
		field.BuildIgloo();
		boolean lastaction = MethodPrinter.AskQuestion("Ez volt a játékos utolsó akciója?");
		if(lastaction) {
			game.NextPlayer();
		}
		MethodPrinter.DecreaseIndentation();
	}
}