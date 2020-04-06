package proto;

/**
 * Jégtáblák közötti mozgásra képes entitás
 */
public abstract class Entity {
	
	protected IceField field;

	/**
	 * Az entitást vihar éri.
	 */
	public abstract void CaughtByStorm();
	
	
	/**
	 * Az entitás vízbe esik.
	 */
	public abstract void FallInWater();
	
	
	/**
	 * Az entitás másik entitással találkozik.
	 */
	public void Meet(Entity entity) {

	}
	
	

	/**
	 * Az entitás átlép egy másik mezõre.
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

		MethodPrinter.DecreaseIndentation();
	}
}
