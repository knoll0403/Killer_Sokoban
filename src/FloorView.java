import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Floor-ok View osztalya
 */
public class FloorView extends Floor {

	/**
	 * A Floor-okhoz tartozo Image-ek
	 */
	private Image activeImage, defaultImage, honey, oil;
	/**
	 * A mezo ImageView osztalya
	 */
	private ImageView view;
	/**
	 * A mezo felett levo ImageView osztaly
	 */
	private ImageView topView;

	/**
	 * Az osztaly konstruktora
	 * @param image A Floor default Image-e
	 * @param h A Floor mezes Image-e
	 * @param o A Floor olajos Image-e
	 * @param view A Floor mezo ImageView osztalya
	 * @param topView A Floor mezo feletti ImageView osztaly
	 */
	public FloorView(Image image, Image h, Image o, ImageView view, ImageView topView)
	{
		this.defaultImage = image;
		this.honey = h;
		this.oil = o;
		this.view = view;
		this.topView = topView;
		this.activeImage = defaultImage;
		view.setImage(activeImage);
	}

	/**
	 * Meghivja az ose SetThing fuggvenyet,
	 * kirajzolja a topView-ra a kapott thing-et.
	 * @param thing A mezore kerulo Thing
	 */
	@Override
	public void SetThing(Thing thing) {
		super.SetThing(thing);
		thing.Draw(topView);
	}

	/**
	 * Meghivja az ose Accept fuggvenyet,
	 * es elvegzi a kiralyzolast.
	 * @param thing A mezore lepo Thing
	 * @param d Az irany amerre a kerest tovabbithatja
	 * @param force A mozgast indito jatekos ereje
	 * @return Az elvegzendo Action
	 */
	@Override
	public Action Accept(Thing thing, Direction d, double force)
	{
		Action re = super.Accept(thing, d, force);
		view.setImage(activeImage);
		if(this.thing != null) {
			this.thing.Draw(topView);
		}else {
			topView.setImage(null);
		}
		return re;
	}

	/**
	 * Meghivja az ose Request fuggvenyet,
	 * es elvegzi a kirajzolast.
	 * @param d Az irany amely fele a hivast inditania kell
	 * @param force A mozgast indito jatekos ereje
	 * @return Az elvegzendo Action
	 */
	@Override
	public Action Request(Direction d, double force)
	{
		Action re = super.Request(d, force);
		view.setImage(activeImage);
		if(this.thing != null) {
			this.thing.Draw(topView);
		}else {
			topView.setImage(null);
		}
		return re;
	}

	/**
	 * Meghivja az ose SetStatus fuggvenyet,
	 * elvegzi a kirajzolast.
	 * @param sub A mezore kerulo parameter
	 */
	@Override
	public void SetStatus(Substance sub) {
		super.SetStatus(sub);
		switch (sub) {
			case Honey:
				this.activeImage = this.honey;
				break;
			case Oil:
				this.activeImage = this.oil;
				break;
			case Empty:
				this.activeImage = this.defaultImage;
			default:
				break;
		}
		view.setImage(activeImage);
	}
	
}
