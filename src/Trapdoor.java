/**
 * <h1>Trapdoor osztaly</h1>
 * A rajta levo targyakat elnyeli, ha nyitva van.
 * Csukott allapotban Floor-kent viselkedik.
 * A palyan levo lyukakat nyitott TrapDoor-kent kezeljuk, ezert nincs ra kulon osztaly.
 */
public class Trapdoor extends Floor {
	/**
	 * Igaz, hogyha a csapoajto eppen nyitva van.
	 */
	protected boolean isOpen;
	
	/**
	 * Konstruktor
	 * Alapbol nyitva van
	 */
	public Trapdoor()
	{
		isOpen = true;
	}
	
	/**
	 * Az isOpen attributumot false-ra allitja,
	 * ezzel bezarja a csapoajtot.
	 */
	public void Close() 
	{
		isOpen = false;
	}
	
	/**
	 * Az isOpen attributumot true-ra allitja,
	 * ezzel kinyitja a csapoajtot.
	 */
	public void Open()
	{
		isOpen = true;
		if(thing != null) thing.Die();
		this.thing = null;
	}
	
	/**
	 * Ha zarva van, akkor ha nincs rajta semmi, atveszi a parameterkent kapott objektumot,
	 * kulonben az adott iranyba eso szomszedjanak meghivja az Accept fuggvenyet a rajta levo objektummal es a megfelelo irannyal.
	 * A kapott visszateresi ertektol fuggoen ha ez Step, Increase vagy Decrease, akkor atveszi a parameterkent kapott objektumot,
	 * kulonben nem veszi at, hanem visszaadja a kapott visszateresi erteket.
	 * Ha nyitva van, akkor a parameterul kapott objektumnak meghivja a Die fuggvenyet es Steppel ter vissza.
	 */
	@Override
	public Action Accept(Thing thing, Direction direction, double force) {
		Action action = Action.Stay;
		if(this.thing == null){
			if(force >= 0) {
				this.thing = thing;
				thing.Enter(this);
				action = Action.Step;
				if(isOpen) {	
					thing.Die();
					this.thing = null;
				}
			}
		}else {
			action = neighbors.get(direction).Accept(this.thing, direction, force - friction);
			if((action== Action.Step || action==Action.Increase || action==Action.Decrease) && force >= 0){
				this.thing = thing;
				thing.Enter(this);
			}else if(action == Action.Kill) {
				if(this.thing.Kill() == true && force >= 0) {
					this.thing = thing;
					thing.Enter(this);
					action = Action.Step;
				}else {
					action = Action.Kill;
				}
			}
		}
		return action;
	}
	
}
