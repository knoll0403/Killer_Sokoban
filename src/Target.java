//A ra tolt ladaert visszateresi ertekeken keresztul pontot kuld a megfelelo jatekosnak,
//a rola ladat letolo jatekostol pontot vesz el.
/**
 * <h1>Target osztaly</h1>
 * A ra tolt ladaert visszateresi ertekeken keresztul pontot kuld a megfelelo jatekosnak,
 * a rola ladat letolo jatekostol pontot vesz el.
 */
public class Target extends Floor {
	/**
	 * A korben a jatekosnak kiosztott pont.
	 */
	private int points;
	
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
	@Override
	public Action Accept(Thing thing, Direction direction, double force) {
		Action action = Action.Step;
		if(this.thing == null){
			if(force >= 0) {
				this.thing = thing;
				thing.Enter(this);
			}
		}else {
			action = neighbors.get(direction).Accept(this.thing, direction, force - friction);
			if((action== Action.Step || action==Action.Increase || action==Action.Decrease) && force >= 0){
				if(action == Action.Decrease) points--;
				if(action == Action.Increase) points++;
				
				this.thing = thing;
				thing.Enter(this);
			}else if(action == Action.Kill && force >= 0) {
				if(this.thing.Kill() == true) {
					this.thing = thing;
					thing.Enter(this);
					points = 0;
					return action = Action.Step;
				}else {
					points = 0;
					return action = Action.Kill;
				}
			}
		}
		if (action != Action.Kill) {
			if (points == 0) return action = Action.Step;
			if (points > 0) action = Action.Increase;
			if (points < 0) action = Action.Decrease;
		}
		points = 0;
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
		Action action = Action.Stay;
		if(neighbors.get(direction).IsThingPushable()) {
			action = neighbors.get(direction).Accept(this.thing, direction, force);
			if(action != Action.Kill && action != Action.Stay) {
				thing = null;
				if(action == Action.Decrease) points--;
				if(action == Action.Increase) points++;
			}
			else action = Action.Stay;
		}
		if(points > 0) action = Action.Increase;
		if(points < 0) action = Action.Decrease;
		points = 0;
		return action;
	}
	
	/** 
	 * A points erteket noveli,
	 * es az osenek meghivja a Push fuggvenyet, a parameterul kapott tomeggel.
	 * @param mass mezore lepo Thing tomege
	 */
	@Override
	public void Push(double mass)
	{
		super.Push(mass);
		this.thing.OnTarget();
		points++;
	}
	
	/**
	 * A points erteket csokkenti,
	 * es meghivja az osenek a Release fuggvenyet. 
	 */
	@Override
	public void Release()
	{
		super.Release();
		this.thing.OnTarget();
		points--;
	}
	
	
}
