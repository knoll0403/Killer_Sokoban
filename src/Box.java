/**
 * <h1>Box osztaly</h1>
 * A jatekban a ladat reprezentalo osztaly.
 * Kommunikal az alatta levo padloval.
 */
public abstract class Box extends Thing {
	
	/**
	 * Igaz, ha a lada mar nem mozgathato
	 */
	private boolean cantMove;
	/**
	 * A lada tomege
	 */
	private double mass;
	/**
	 * Igaz, ha a lada celmezon van.
	 */
	public boolean onTarget = false;
	/**
	 * Letrehozza a ladat
	 * @param m A lada tomege
	 */
	public Box(double m) {
		mass = m;
	}

	/**
	 * Az objektum lekerul a palyarol, a floor attributum erteket null-ra allitja.
	 */
	@Override
	public void Die() {
		this.floor = null;
		cantMove = true;
	}
	
	/**
	 * Meghivja a regi floor Release fuggvenyet, majd meghivja az uj floor Push fuggvenyet
	 * @param floor Az lada uj mezoje
	 */
	@Override
	public void Enter(Floor floor) {
		if(this.floor != null)
			this.floor.Release();
		this.floor = floor;
		this.floor.Push(mass);
	}

	/**
	 * Lekerdezi, hogy a lada mozgathato-e
	 * @return Igaz, ha a lada mozgathato meg
	 */
	@Override
	public boolean IsPushable() {
		return !cantMove;
	}

	/**
	 * Lekerdezi, hogy a lada eltarolt-e pontot
	 * 0, ha a lada meg mozgathato
	 * 1, ha a lada mar nem mozgathato, vagy nincs a palyan
	 * @return 0 vagy 1 a fenti leiras szerint
	 */
	@Override
	public int GetPoint() {
		if(cantMove == true && !onTarget) {
			return 1;
		}else {
			return 0;
		}
	}

	/**
	 * Beallitja a cantMove parameter erteket, attol fuggoen, hogy a szomszedos mezokon allo Thing-ek mozgathatoak-e
	 */
	@Override
	public void SetMove() {
		if (this.floor == null) {
			cantMove = true;
			return;
		}
		if ((this.floor.GetNeighbour(Direction.Up).IsThingMovable() == false && this.floor.GetNeighbour(Direction.Right).IsThingMovable() == false) ||
				(this.floor.GetNeighbour(Direction.Up).IsThingMovable() == false && this.floor.GetNeighbour(Direction.Left).IsThingMovable() == false) ||
				(this.floor.GetNeighbour(Direction.Down).IsThingMovable() == false && this.floor.GetNeighbour(Direction.Right).IsThingMovable() == false) ||
				(this.floor.GetNeighbour(Direction.Down).IsThingMovable() == false && this.floor.GetNeighbour(Direction.Left).IsThingMovable() == false))
		{
			cantMove = true;
		}
	}

	/**
	 * Lekerdezheto, hogy a lada meg mozoghat-e
	 * @return Igaz, ha a lada meg mozoghat
	 */
	@Override
	public boolean IsMovable() {
		return !cantMove;
	}

	/**
	 * A ladat nem lehet megolni, ezert nem csinal semmit
	 * @return false, mert nem sikerult a muvelet
	 */
	@Override
	public boolean Kill() {
		return false;
	}

	/**
	 * Megvaltoztatja az onTarget erteket
	 */
	@Override
	public void OnTarget() {
		onTarget = !onTarget;
	}
}
