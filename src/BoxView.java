import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * <h1>BoxIO osztaly</h1>
 * A Box osztaly Input-Output osztalya.
 * A Box-szal kapcsolatos uzenetek kiirasaert felel.
 */
public class BoxView extends Box
{

	/**
	 * A ladahoz tartozo kep
	 */
	private Image image;
	
	/**
	 * Konstruktor
	 * @param image A lada kepe
	 * @param mass A lada sulya
	 */
	public BoxView(Image image, double mass) {
		super(mass);
		this.image = image;
	}

	/**
	 * Kirajzolja a Box-ot
	 * @param view Ide rajzolodik ki a Box
	 */
	@Override
	public void Draw(ImageView view) {
		view.setImage(image);
	}
}
