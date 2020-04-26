package proto;

/**
 *Azok az osztályok valósítják meg, melyek a játék
 *egy teljes körének végén valamilyen mûveletet hajtanak végre.
 */
public interface Steppable {
	
	/**
	 * A kör végén végrehajtásra kerülõ mûvelet.
	 */
	public abstract boolean Step();
}
