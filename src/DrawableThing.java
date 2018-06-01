import javafx.scene.image.ImageView;

/**
 * Rajzolhato osztalyok kozos interface-e
 */
public interface DrawableThing {
	/**
	 * A kirajzolast vegzo Draw fuggveny
	 * @param view A mezo amire a kirajzolast kell vegezni
	 */
	void Draw(ImageView view);
}
