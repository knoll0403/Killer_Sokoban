import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerView extends Player {

	/**
	 * a jatekos neve
	 */
	public String name;
	
	/**
	 * a munkas kepe
	 */
	private Image image;
	
	/**
	 * a mozgast szabalyozo billentyuk karakterkódja
	 */
	private String Up, Down, Left, Right, Honey, Oil;
	
	/**
	 * a pont kijelzesere alkalmas Label
	 */
	private Label label;

	/**
	 * konstruktor
	 */
	public PlayerView(String n, Image image, double strenght, Label l) {
		super(strenght);
		this.name = n;
		this.image = image;
		this.label = l;
		label.setText(this.toString());
	}
	
	/**
	 * a felfele mozgast vezerlo billenytyu beallitasa
	 * @param s a billentyu kodja
	 */
	public void SetUp(String s)
	{
		Up = s;
	}
	
	/**
	 * a lefele mozgast vezerlo billenytyu beallitasa
	 * @param s a billentyu kodja
	 */
	public void SetDown(String s)
	{
		Down = s;
	}
	
	/**
	 * a jobbra mozgast vezerlo billenytyu beallitasa
	 * @param s a billentyu kodja
	 */
	public void SetRight(String s)
	{
		Right = s;
	}
	
	/**
	 * a balra mozgast vezerlo billenytyu beallitasa
	 * @param s a billentyu kodja
	 */
	public void SetLeft(String s)
	{
		Left = s;
	}
	
	/**
	 * a mez lerakasat vezerlo billenytyu beallitasa
	 * @param s a billentyu kodja
	 */
	public void SetHoney(String s)
	{
		Honey = s;
	}
	
	/**
	 * az olaj lerakasat vezerlo billenytyu beallitasa
	 * @param s a billentyu kodja
	 */
	public void SetOil(String s)
	{
		Oil = s;
	}

	/**
	 * kirajzolja a jatekos kepet
	 * @param view az ImageView amire rajzol
	 */
	@Override
	public void Draw(ImageView view) {
		view.setImage(image);
	}

	/**
	 * noveli a pontszamot  es frissiti a feliratot
	 */
	@Override
	public void AddPoint()
	{
		super.AddPoint();
		label.setText(this.toString());
	}

	/**
	 * csokkenti a pontszamot  es frissiti a feliratot
	 */
	@Override
	public void DecPoint()
	{
		super.DecPoint();
		label.setText(this.toString());
	}

	/**
	 * kezeli a billenytyu esemenyeket
	 * @param key a lenyomott billenytyu kodja
	 */
	public void PressedKey(String key) {
		if(floor != null) {
			if(key.equals(Up)) {
				Move(Direction.Up);
			}else if(key.equals(Down)) {
				Move(Direction.Down);
			}else if(key.equals(Left)) {
				Move(Direction.Left);
			}else if(key.equals(Right)) {
				Move(Direction.Right);
			}else if(key.equals(Honey)) {
				DropSubstance(Substance.Honey);
			}else if(key.equals(Oil)) {
				DropSubstance(Substance.Oil);
			}
		}
	}

	/**
	 * visszaadja a nevet es a pontot a kiiasnak megfelelo formatumban
	 */
	public String toString() {
		return this.name + ": " + this.GetPoint();
	}
}
