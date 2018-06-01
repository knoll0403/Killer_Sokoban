import java.util.HashMap;

/**
 * <h1>Floor osztaly</h1>
 * Egyszeru padloelem.
 * Felelossege nyilvantartani szomszedjait,
 * kommunikalni a rajta levo objektumokkal es a szomszedjaival.
 */
public class Floor {
	
	/**
	 * Padlon levo dolog
	 */
	protected Thing thing;
	/**
	 * Szomszed padloelemek
	 */
	protected HashMap<Direction, Floor> neighbors;
	/**
	 * Mezon levo kenoanyag
	 */
	protected Substance status;
	/**
	 * A mezo surlodasa
	 */
	protected double friction;
	
	/**
	 * Konstruktor
	 */
	public Floor() {
		neighbors = new HashMap<Direction, Floor>();
		status = Substance.Empty;
		friction = 0;
	}
	
	
	/**
	 *  Ha nincs rajta semmi, atveszi a parameterkent kapott objektumot, 
	 * kulonben az adott iranyba eso szomszedjanak meghivja az Accept fuggvenyet a rajta levo objektummal 
	 * es a megfelelo irannyal. 
	 * A kapott visszateresi ertektol fuggoen ha ez Step, Increase vagy Decrease, 
	 * akkor atveszi a parameterkent kapott objektumot, kulonben nem veszi at, 
	 * hanem visszaadja a kapott visszateresi erteket.
	 * @param thing A mezore lepo Thing
	 * @param direction Az irany amerre tovabb kell kerdezni a mozgast
	 * @param force A mozgast indito jatekos ereje
	 * @return A vegrehajtando Action
	 */
	public Action Accept(Thing thing, Direction direction, double force) {
		Action action = Action.Stay;
		if(this.thing == null){
			if(force >= 0) {
				this.thing = thing;
				thing.Enter(this);
				action = Action.Step;
			}
		}else {
			action = neighbors.get(direction).Accept(this.thing, direction, force - friction); //Accept tovabbhivasa
			if((action== Action.Step || action==Action.Increase || action==Action.Decrease) && force >= 0)
			{
				this.thing = thing;
				thing.Enter(this);
			}else if(action == Action.Kill && force >= 0) {
				if(this.thing.Kill() == true) {
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
	
	
	/**
	 *  Meghivja az adott iranyba eso szomszedjanak IsThingPushable fuggvenyet. 
	 * Ha ez true, akkor meghivjuk ugyanazon szomszed Accept fuggvenyet, visszater a kapott Actionnel, kiveve ha ez Kill, 
	 * ekkor Stayt ad vissza, valamint ha az IsThingPushable visszateresi erteke false.
	 * @param direction Az irany, amerre a mozgast inditja jatekos
	 * @param force A mozgast indito jatekos ereje
	 * @return A vegrehajtando Action
	 */
	public Action Request(Direction direction, double force) {
		if(neighbors.get(direction).IsThingPushable()) {
			Action action = neighbors.get(direction).Accept(this.thing, direction, force);
			if(action != Action.Kill && action != Action.Stay) {
				thing = null;
				return action;
			}
			else return Action.Stay;
		}
		else
			return Action.Stay;
	}
	
	/** 
	 * Meghivodik, ha egy objektum ralep. A specialis mezok itt vegzik el a feladatukat.
	 * @param mass A ra levo objektum tomege
	 */
	public void Push(double mass) {
		switch (status){
		case Oil:
			friction = 0.5 * mass;
			break;
		case Honey:
			friction = 1.5 * mass;
			break;
		case Empty:
			friction = mass;
			break;
		}
	}
	
	/**
	 * Meghívódik, ha az objektum lelep rola. A specialis mezok itt vegzik el a feladatukat.
	 */
	public void Release() {
		friction = 0;
	}
	
	/** 
	 * Visszaadja a rajta levo objektum IsPushable fuggvenyenek visszateresi erteket,
	 * ha nincs rajta objektum, igazzal ter vissza.
	 * @return Igaz, ha a rajta levo objektum tolhato
	 */
	public boolean IsThingPushable() {
		if (thing == null)
			return true;
		return thing.IsPushable();
		}
	
	/** 
	 * Visszaadja a rajta lévõ objektum IsMovable függvényének visszatérési értékét,
	 * ha nincs rajta objektum, igazzal tér vissza.
	 * @return Igaz, ha a rajta levo objektum mozgathato
	 */
	public boolean IsThingMovable() {
		if (thing == null)
			return true;
		return thing.IsMovable();
	}
	

	/** 
	 * Beallítja a parameterul kapott objektumot a kapott iranyu szomszedjanak.
	 * @param floor A szomszedos mezo
	 * @param direction Az szomszedos mezo iranya
	 */
	public void SetNeighbour(Floor floor, Direction direction) {
		neighbors.put(direction, floor);
		switch (direction){
        case Up:
            if(floor.GetNeighbour(Direction.Down) != this)
                floor.SetNeighbour(this, Direction.Down);
            break;
        case Down:
            if(floor.GetNeighbour(Direction.Up) != this)
                floor.SetNeighbour(this, Direction.Up);
            break;
        case Right:
            if(floor.GetNeighbour(Direction.Left) != this)
                floor.SetNeighbour(this, Direction.Left);
            break;
        case Left:
            if(floor.GetNeighbour(Direction.Right) != this)
                floor.SetNeighbour(this, Direction.Right);
            break;
		}
	}
	
	/**
	 * A mezore rakjuk a thing-et
	 * @param thing A mezore kerulo Thing
	 */
	public void SetThing(Thing thing) {
		this.thing = thing;
	}
	
	/** 
	 * Visszaadja a kapott iranyban levo szomszedjat.
	 * @param direction A mezo iranya
	 * @return Az adott iranyban levo szomszedos mezo
	 */
	public Floor GetNeighbour(Direction direction) {
		return neighbors.get(direction);
	}
	
	/**
	 * A mezore kenoanyagot helyez el
	 * @param sub A mezore kerulo parameter 
	 */
	public void SetStatus(Substance sub) {
		status = sub;
	}
}
