import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TargetView extends Target {

	/**
	 * A kepek amiket kirajzolhat
	 */
	private Image activeImage, defaultImage, honey, oil;
	
	/**
	 * Az ImageView amit a csapoajto hasznal
	 */
	private ImageView view;
	
	/**
	 * Az ImageView amit a csapoajton allo dolog hasznal
	 */
	private ImageView topView;
	
	/**
	 * Az ImageView amit a csapoajton allo dolog hasznal
	 */
	public TargetView(Image image, Image h, Image o, ImageView view, ImageView topView)
	{
		this.defaultImage = image;
		this.honey = h;
		this.oil = o;
		this.view = view;
		this.topView = topView;
		this.activeImage = defaultImage;
		view.setImage(image);
	}
	
	/**
	 * Felhelyezi a parameterkent kapott dolgot
	 * @param thing a dolog amit fel akarunk helyezni
	 */
	@Override
	public void SetThing(Thing thing) {
		super.SetThing(thing);
		thing.Draw(topView);
	}
	
	/**
	 * Meghivja az ososztaly fuggvenyet, majd frissiti a nezetet
	 * @param thing az atadando dolog
	 * @param d a mozgas iranya
	 * @param force a belepes ereje
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
	 * Meghivja az ososztaly fuggvenyet, majd frissiti a nezetet
	 * @param d a mozgas iranya
	 * @param force a kilepes ereje
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
	 * beallitja a hasznalando kepet
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
