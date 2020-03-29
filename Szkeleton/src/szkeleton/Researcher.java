package szkeleton;


public class Researcher extends Player {
	
	/**
	 * A kutató használja a képességét, mellyel felderít egy szomszédos mezőt.
	 */
	public void UseAbility(Direction d) {
		MethodPrinter.Println(Skeleton.GetName(this) + ".UseAbility(d)");
		MethodPrinter.IncreaseIndentation();
		IceField researchedfield = field.GetNeighbour(d);
		researchedfield.RevealCapacity();
		MethodPrinter.DecreaseIndentation();
	}
}
