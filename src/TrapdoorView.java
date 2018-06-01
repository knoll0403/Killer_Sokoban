import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TrapdoorView extends Trapdoor {

	/**
	 * A kepek amiket kirajzolhat
	 */
	private Image activeImage, openImage, closedImage, honey, oil;
	
	/**
	 * Az ImageView amit a csapoajto hasznal
	 */
	private ImageView view;
	
	/**
	 * Az ImageView amit a csapoajton allo dolog hasznal
	 */
	private ImageView topView;
	
	/**
	 * konstruktor
	 */
	public TrapdoorView(Image openImage, Image closedImage, Image h, Image o, ImageView view, ImageView topView)
	{
		this.openImage = openImage;
		this.closedImage = closedImage;
		this.honey = h;
		this.oil = o;
		this.view = view;
		this.topView = topView;
		this.activeImage = closedImage;
		view.setImage(openImage);
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
		if(isOpen) {
			view.setImage(openImage);
		}else {
			view.setImage(activeImage);
		}
		
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
		if(isOpen) {
			view.setImage(openImage);
		}else {
			view.setImage(activeImage);
		}
		
		if(this.thing != null) {
			this.thing.Draw(topView);
		}else {
			topView.setImage(null);
		}
		return re;
	}
	
	/**
	 * Meghivja az ososztaly fuggvenyet, majd frissiti a nezetet
	 */
	@Override
	public void Close() {
		super.Close();
		view.setImage(activeImage);
	}
	
	/**
	 * Meghivja az ososztaly fuggvenyet, majd frissiti a nezetet
	 */
	@Override
	public void Open(){
		super.Open();
		view.setImage(openImage);
		topView.setImage(null);
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
				this.activeImage = this.openImage;
			default:
				break;
		}
		view.setImage(activeImage);
	}
}
