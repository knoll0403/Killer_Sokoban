import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Controller osztaly</h1>
 * A kapott parancsokat ertelmezi és vegrehajta, valamint lefuttatja az automatikus teszteseteket.
 */
public class Controller
{
	/**
	 * Playereket tarolja
	 */
	private ArrayList<PlayerView> players;
	/**
	 * A Map-et tarolja
	 */
	private Map map;

	/**
	 * A GetPlayer fuggvenyben az aktualis player sorszama
	 */
	private int act = 0;

	/**
	 * Letrehozza a Controller osztalyt 
	 */
	public Controller() {
		players = new ArrayList<PlayerView>();
	}
	
	/**
	 * Map-et ad a Controller-hez
	 * @param m A Controller-hez adott Map
	 */
	public void AddMap(Map m)
	{
		map = m;
	}
	
	/**
	 * Player-t ad a Controllerhez
	 * @param p A Controller-hez adott Player
	 */
	public void AddPlayer(PlayerView p)
	{
		players.add(p);
	}

	/**
	 * Bejarja a players tombot es egyesevel visszaadja a benne levo PlayerView-kat
	 * @return A kovetkezo PlayerView
	 */
	public PlayerView GetPlayer()
	{
		if (act < players.size()) {
			return players.get(act++);
		}
		act = 0;
		return null;
	}

	/**
	 * Torli a jatekosokat es az act erteket is 0-ra allitja
	 */
	public void Clear()
	{
		act = 0;
		players.clear();
	}

	/**
	 * A jatekosokat mozgato fuggveny
	 * @param command A lenyomott billentyu kodja
	 * @return A jatekallapota
	 */
	public GameStatus Act(String command)
	{
		if	(command.equals("ESCAPE")) {
			return GameStatus.MainMenu;
		}
		if (players.get(0) != null) {
			players.get(0).PressedKey(command);
		}
		if (players.size() > 1 && players.get(1) != null) {
			players.get(1).PressedKey(command);
		}
		if (players.size() > 2 && players.get(2) != null) {
			players.get(2).PressedKey(command);
		}
		if (players.size() > 3 && players.get(3) != null) {
			players.get(3).PressedKey(command);
		}
		if (players.size() > 4 && players.get(4) != null) {
			players.get(4).PressedKey(command);
		}
		if (players.size() > 5 && players.get(5) != null) {
			players.get(5).PressedKey(command);
		}
		if (players.size() > 6 && players.get(6) != null) {
			players.get(6).PressedKey(command);
		}
		if (players.size() > 7 && players.get(7) != null) {
			players.get(7).PressedKey(command);
		}
		if (map.IsGameOver(this))
		{
			return GameStatus.Winner;
		}
		return GameStatus.Game;
	}

	/**
	 * Megkeresi a jatekban a legtobb pontot szerzett jatekost
	 * @return A legtobb pontot szerzett PlayerView
	 */
	public PlayerView getWinner()
	{
		PlayerView p = players.get(0);
		for (int i = 1; i < players.size(); i++)
		{
			if (p.GetPoint() < players.get(i).GetPoint())
			{
				p = players.get(i);
			}
		}
		return p;
	}
}