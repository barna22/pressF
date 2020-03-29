package szkeleton;

public class Eskimo extends Player {
	
	/**
	 * Az eszkim� haszn�lja a k�pess�g�t, mellyel �p�t egy iglut.
	 */
	public void UseAbility(Direction d) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".UseAbility(d)");
		MethodPrinter.IncreaseIndentation();
		field.BuildIgloo();
		MethodPrinter.DecreaseIndentation();
	}
}