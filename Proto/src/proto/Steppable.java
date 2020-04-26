package proto;

/**
 *Azok az oszt�lyok val�s�tj�k meg, melyek a j�t�k
 *egy teljes k�r�nek v�g�n valamilyen m�veletet hajtanak v�gre.
 */
public interface Steppable {
	
	/**
	 * A k�r v�g�n v�grehajt�sra ker�l� m�velet.
	 */
	public abstract boolean Step();
}
