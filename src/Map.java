import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/** 
 * <h1>Map osztaly</h1>
 * A palya elemeit tarolja
 */
public class Map {
	
	/** 
	 * A palyan levo jatekosok es ladak
	 */
	private ArrayList<Thing> things;
	/** 
	 * A palyaelemek
	 */
	private ArrayList<Floor> floors;
	/**
	 * A palya meretenek x koordinataja
	 */
	private int sizeX;
	/**
	 * A palya meretenek y koordinataja
	 */
	private int sizeY;
    /**
     * Kezdetben a palyan levo ladak szama
     */
	private int countBox = 0;
	/**
	 * Konstruktor
	 * Letrehoz egy ures Map-et
	 */
	public Map()
	{
		floors = new ArrayList<Floor>();
		things = new ArrayList<Thing>();
	}
	
	/**
	 * Az x,y koordinatan levo Floor getter fuggvenye
	 * @param x A mezo x koordinata
	 * @param y A mezo y koordinataja
	 * @return A koordinatan levo Floor
	 */
	private Floor GetFloor(int x, int y) {
		return floors.get(x + y * sizeX);
	}
	
	/**
	 * Betolti a palyat
	 * @param controller A palya controllere
	 * @param MapPath A palya leirasat tartalmazo fajl eleresi utja
	 * @return A palya beolvasasanak sikeressege
	 */
	public boolean Load(Controller controller, String MapPath) throws IOException {
		boolean canGetPlayer = true;
		if(floors != null)
			floors.clear();
		if(things != null)
			things.clear();
		FileInputStream fstream = new FileInputStream(MapPath);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String s = br.readLine();
		String[] ss = s.split(" ");
		sizeX = Integer.parseInt(ss[0]);
		sizeY = Integer.parseInt(ss[1]);

		Image image, image1, image2, image3;
		for(int y = 0; y < sizeY; y++)
		{
			s = br.readLine();
			ss = s.split(" ");
			for(int x = 0; x < sizeX; x++)
			{
				switch (ss[x]) {
					case "w":
						image = new Image("file:textures/wall.png");
						floors.add(new WallView(image, GUI.getFloorImageView(x, y)));
						break;
					case "f":
						image = new Image("file:textures/floor.png");
						image1 = new Image("file:textures/honey.png");
						image2 = new Image("file:textures/oil.png");
						floors.add(new FloorView(image, image1, image2, GUI.getFloorImageView(x, y), GUI.getThingImageView(x, y)));
						break;
					case "s":
						image = new Image("file:textures/switch.png");
						image1 = new Image("file:textures/switchHoney.png");
						image2 = new Image("file:textures/switchOil.png");
						floors.add(new SwitchView(image, image1, image2, GUI.getFloorImageView(x, y), GUI.getThingImageView(x, y)));
						break;
					case "t":
                        image = new Image("file:textures/target.png");
                        image1 = new Image("file:textures/targetHoney.png");
                        image2 = new Image("file:textures/targetOil.png");
						floors.add(new TargetView(image, image1, image2, GUI.getFloorImageView(x, y), GUI.getThingImageView(x, y)));
						break;
					case "h":
						image = new Image("file:textures/trapdoor.png");
						image1 = new Image("file:textures/hole.png");
                        image2 = new Image("file:textures/trapdoorHoney.png");
                        image3 = new Image("file:textures/trapdoorOil.png");
						floors.add(new TrapdoorView(image1, image, image2, image3, GUI.getFloorImageView(x, y), GUI.getThingImageView(x, y)));
						break;
					default:
						return false;
				}
			}
		}
			
		for (int j = 0; j < sizeY; j++)
			for (int i = 0; i < sizeX - 1; i++)
				GetFloor(i, j).SetNeighbour(GetFloor(i+1, j), Direction.Right);

		for (int i = 0; i < sizeX; i++)
			for (int j = 0; j < sizeY - 1; j++)
				GetFloor(i, j).SetNeighbour(GetFloor(i, j+1), Direction.Down);

		image = new Image("file:textures/box.png");
		while((s = br.readLine()) != null)
		{
			ss = s.split(" ");
			switch (ss[0]) {
			case "p":
				int posX = Integer.parseInt(ss[1]);
				int posY = Integer.parseInt(ss[2]);
				int strength = Integer.parseInt(ss[3]);
				if(canGetPlayer) {
				PlayerView p = controller.GetPlayer();
					if(p != null) {
						things.add(p);
						GetFloor(posX, posY).SetThing(p);
						p.Enter(GetFloor(posX, posY));
					}else {
						canGetPlayer = false;
					}
				}
				break;
			case "b":
				int posX1 = Integer.parseInt(ss[1]);
				int posY1 = Integer.parseInt(ss[2]);
				int mass = 1; //TODO
				BoxView b = new BoxView(image, mass);
				things.add(b);
				b.Enter(GetFloor(posX1, posY1));
				GetFloor(posX1, posY1).SetThing(b);
				countBox++;
				break;
			case "s":
				int posX2 = Integer.parseInt(ss[1]);
				int posY2 = Integer.parseInt(ss[2]);
				int posX3 = Integer.parseInt(ss[3]);
				int posY3 = Integer.parseInt(ss[4]);
				((Switch)GetFloor(posX2, posY2)).SetTrapdoor((Trapdoor)GetFloor(posX3, posY3));
				break;
			default:
				return false;
			}
		}
		
		in.close();
		return true;
	}
	
	/**
	 * Meghívja a things-ek SetPush függvényét,
	 * majd meghívja a things-ek GetPoint függvényét,
	 * ha az eredményül kapott pontok összege megegyezik a countBox-szal, akkor igaz értékkel tér vissza.
	 * @param controller az aktiv kontroller
	 * @return Igaz, ha vege van a jateknak
	 */
	public boolean IsGameOver(Controller controller) {
		int points = 0;
		for (int i = 0; i < things.size(); i++)
		{
			for (int j = 0; j < things.size(); j++)
			{
				things.get(j).SetMove();
			}
		}
		
		for (int i = 0; i < things.size(); i++)
		{
			points += things.get(i).GetPoint();
		}

		boolean allDead = true;
		PlayerView p;
		while ((p = controller.GetPlayer()) != null)
        {
            if (p.floor != null)
            {
                allDead = false;
            }
        }

		return points == countBox || allDead;
	}

}
