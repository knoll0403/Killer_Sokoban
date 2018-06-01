/**
 * <h1>Thing osztaly</h1>
 * Absztrakt osztaly, a Box es a Player kozos ose.
 * Ismeri az alatta levo Floort és kommunikal vele.
 */
public abstract class Thing implements DrawableThing {
	
	/**
	 * A mezo, amin az objektum all 
	 */
	protected Floor floor;
	
	/**
	 * Az objektum lekerul a palyarol, a floor attributum erteket null-ra allitja.
	 */
	public abstract void Die();
	
	/**
	 * Absztrakt metodus
	 */
	public abstract boolean Kill();
	
	/**
	 * Absztrakt metodus
	 */
	public abstract void Enter(Floor floor);
	
	/**
	 * Absztrakt metodus
	 */
	public abstract boolean IsPushable();
	
	/**
	 * Absztrakt metodus
	 */
	public abstract boolean IsMovable();

	/**
	 * Absztrakt metodus
	 */
	public abstract int GetPoint();
	
	/**
	 * Absztrakt metodus
	 */
	public abstract void SetMove();

	public abstract void OnTarget();
}
