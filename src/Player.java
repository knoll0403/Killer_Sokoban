/**
 * <h1>Player osztaly</h1>
 * A jatekban a jatekosokat reprezentalo osztaly.
 * Kommunikal az alatta levo mezovel hogy melyik iranyba szeretne menni,
 * tarolja a jatekos altal szerzett pontokat
 */
public abstract class Player extends Thing {
	/**
	 * A jatekos pontjai.
	 * A ladak helyretolasaval eggyel no, letolas eseten csokken eggyel
	 */
	private int points;
	/**
	 * A jatekos ereje
	 */
	private double strenght;
	
	/**
	 * Konstruktor
	 * @param s A jatekos ereje
	 */
	public Player(double s) {
		points = 0;
		strenght = s;
	}
	
	/**
	 * Noveli a jatekos pontszamat 
	 */
	public void AddPoint() {
		points++;
	}
	
	/** 
	 * Csokkenti a jatekos pontszamat
	 */
	public void DecPoint() {
		points--;
	}
	
	/** 
	 * Megprobal elmozdulni az adott iranyba.
	 * @param d Az elmozdulas iranya
	 * @return Igaz, ha sikerul a mozgas
	 */
	public boolean Move(Direction d) {
		Action action = floor.Request(d, strenght);
		switch(action) {
		case Increase:
			AddPoint();
			return true;
		case Decrease:
			DecPoint();
			return true;
		case Step:
			return true;
		default:
			return false;
		}
		
	}
	
	/**
	 * Ures fuggveny
	 */
	public void SetMove() {}

	/**
	 * Az objektum lekerul a palyarol, a floor attributum erteket null-ra allitja.
	 */
	@Override
	public void Die() {
		this.floor = null;
	}

	/**
	 * Parameterul megkapja, hogy a jatekos melyik mezore lep eppen ra, es ezt el is tarolja.
	 * @param floor Az uj mezo amin a jatekos all
	 */
	@Override
	public void Enter(Floor floor) {
		this.floor = floor;
	}

	/** 
	 * Visszaadja, hogy a jatekos nem tolhato
	 * @return false, mert a jatekost nem lehet tolni
	 */
	@Override
	public boolean IsPushable() {
		return false;
	}

	/** 
	 * Visszaadja a points valtozo erteket.
	 * @return A jatekos alltal szerzett pontok
	 */
	@Override
	public int GetPoint() {
		return points;
	}

	/**
	 * Megoli a jatekost
	 * @return true, mert a jatekost meg tudja olni
	 */
	@Override
	public boolean Kill() {
		this.Die();
		return true;
	}
	
	/**
	 * Az alatta levo mezore kenoanyagot helyez el
	 * @param sub Az elhelyezendo kenoanyag
	 */
	public void DropSubstance(Substance sub) {
		floor.SetStatus(sub);
	}

	/**
	 * Visszaadja, hogy a jatekos mozoghat-e
	 * @return  true, mert a jatekos mindig tud mozogni
	 */
	@Override
	public boolean IsMovable() {
		return true;
	}

	/**
	 * celmezore lepest jelzi
	 */
	@Override
	public void OnTarget() {}
}
