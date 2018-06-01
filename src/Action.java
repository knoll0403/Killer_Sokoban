/**
 * <h1>Action osztaly</h1>
 * Enumeracio, az Accept es a Request fuggvenyek visszateresi erteke. 
 */
public enum Action {
	/**
	 * Az objekum nem mozog
	 */
	Stay,
	/**
	 * Az objektum lep egyet
	 */
	Step,
	/**
	 * Az objektum lep és a mozgast indito jatekos pontot kap
	 */
	Increase,
	/**
	 * Az objektum mozog es a mozgast indito jatekos pontot veszit
	 */
	Decrease,
	/**
	 * Az objektumot megprobaljuk megolni
	 */
	Kill
	
}
