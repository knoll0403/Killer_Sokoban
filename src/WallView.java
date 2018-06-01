import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WallView extends Wall {

	private Image image;
	private ImageView view;
	private ImageView topView;
	
	/**
	 * konstruktor
	 * @param image a fal kepe
	 * @param view a fal altal hasznalt ImageView
	 */
	public WallView(Image image, ImageView view)
	{
		this.image = image;
		this.view = view;
		view.setImage(image);
	}
}
