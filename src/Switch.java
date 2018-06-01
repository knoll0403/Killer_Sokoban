/**
 * <h1>Switch osztaly</h1>
 * A jatekban a kapcsolot reprezentalo osztaly. 
 * Feladata hozza tartozo csapoajto kinyitasa es becsukasa attol fuggoen, hogy van-e rajta lada.
 */
public class Switch extends Floor {
	/**
	 * A gombhoz tartozo csapoajto
	 */
	private Trapdoor trapdoor;
	
	/**
	 * Meghivja a trapdoor Open fuggvenyet,
	 * es az osenek a Push fuggvenyet a parameterul kapott tomeggel.
	 * @param mass A ralepo thing tomege
	 */
	@Override
	public void Push(double mass)
	{
		super.Push(mass);
		trapdoor.Open();
	}
	
	/**
	 * Meghivja a trapdoor Close fuggvenyet,
	 * es az osenek a Release fuggvenyet.
	 */
	@Override
	public void Release()
	{
		super.Release();
		trapdoor.Close();
	}
	
	/**
	 * A parameterul kapott trapdoor-t eltarolja, és becsukja.
	 */
	public void SetTrapdoor(Trapdoor trapdoor) {
		this.trapdoor = trapdoor;
		trapdoor.Close();
	}
	
}

