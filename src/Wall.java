/**
 * <h1>Wall osztaly</h1>
 * A jatekban a falat reprezentalo osztaly
 * Megakadalyozza hogy ra lehessen lepni, vagy ra lehessen tolni egy ladat. 
 */
public class Wall extends Floor {
	
	/**
	 * Kill-lel ter vissza
	 */
	@Override
	public Action Accept(Thing thing, Direction direction, double force)
	{
		return Action.Kill;
	}
	
	/**
	 * Ures fuggveny, soha nem hivodik meg
	 */
	@Override
	public Action Request(Direction direction, double force)
	{
		return null;
	}

	/**
	 * False-szal ter vissza
	 */
	@Override
	public boolean IsThingPushable()
	{
		return false;
	}

	/**
	 * False-szal ter vissza
	 */
	@Override
	public boolean IsThingMovable()
	{
		return false;
	}
}
