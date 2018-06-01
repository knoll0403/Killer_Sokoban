import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <h1>GUI osztaly</h1>
 * A main fuggvenyt tartalmazza
 */
public class GUI extends Application {
    /**
     * A jatek palyaja
     */
	private static Map map;
    /**
     * A jatek controllere
     */
	private static Controller controller;
    /**
     * Az ablak PrimaryStage-e
     */
	private static Stage primaryStage1;
    /**
     * Az ablakok Parentje
     */
	private static Parent main, play, game;
    /**
     * Az ablakok Sceneje
     */
	public static Scene mainMenu, playMenu, gameScene;
    /**
     * Az ImageView-kat tartalmazo lista
     */
	private static ObservableList imageViewList;
    /**
     * A map-ot kivalaszto ComboBox
     */
	public ComboBox mapSelect;
    /**
     * A jatekosok tulajdonsagainak bevitelere szolgalo mezok
     */
	public TextField playerName0;
	public Button up0Button, down0Button, left0Button, right0Button, honey0Button, oil0Button;
    public ComboBox strength0Box;
	public TextField playerName1;
	public CheckBox active1;
	public Button up1Button, down1Button, left1Button, right1Button, honey1Button, oil1Button;
    public ComboBox strength1Box;
	public TextField playerName2;
	public CheckBox active2;
	public Button up2Button, down2Button, left2Button, right2Button, honey2Button, oil2Button;
    public ComboBox strength2Box;
	public TextField playerName3;
	public CheckBox active3;
	public Button up3Button, down3Button, left3Button, right3Button, honey3Button, oil3Button;
    public ComboBox strength3Box;
	public TextField playerName4;
	public CheckBox active4;
	public Button up4Button, down4Button, left4Button, right4Button, honey4Button, oil4Button;
    public ComboBox strength4Box;
	public TextField playerName5;
	public CheckBox active5;
	public Button up5Button, down5Button, left5Button, right5Button, honey5Button, oil5Button;
    public ComboBox strength5Box;
	public TextField playerName6;
	public CheckBox active6;
	public Button up6Button, down6Button, left6Button, right6Button, honey6Button, oil6Button;
    public ComboBox strength6Box;
	public TextField playerName7;
	public CheckBox active7;
	public Button up7Button, down7Button, left7Button, right7Button, honey7Button, oil7Button;
    public ComboBox strength7Box;
    /**
     * A jatekosok eredmenyeit kiiro Label-ek
     */
    public static Label result0, result1, result2, result3, result4, result5, result6, result7;
    /**
     * Ide irjuk ki a gyoztes nevet
     */
    public static Label winnerLabel;

    /**
     * A Play gombot kezelo Handle
     */
	public void playButtonHandle() {
        primaryStage1.setScene(playMenu);
		primaryStage1.show();
    }

    /**
     * A Quit gombot kezelo Handle
     */
	public void quitButtonHandle() {
		primaryStage1.close();
	}

    /**
     * A Back gombot kezelo Handle
     */
    public void backButtonHandle() {
		primaryStage1.setScene(mainMenu);
		primaryStage1.show();
	}

    /**
     * A Start gombot kezelo Handle
     * Torli az ImageView-kat, letrehozza a jatekosokat es a palyat,
     * valamint a billentyuzet esemenyeit tovabbitja a Controller-be
     */
    public void startButtonHandle() throws IOException {
	    ImageView view;
	    for (int i = 0; i < 468; i++)
        {
            view = (ImageView) imageViewList.get(i);
            view.setImage(null);
        }
        primaryStage1.setScene(gameScene);
		primaryStage1.show();

		Image image = new Image("file:textures/worker0.png");
        PlayerView p0 = new PlayerView(playerName0.getText(), image, (int) strength0Box.getValue(), result0);
        p0.SetUp(up0Button.getText());
        p0.SetDown(down0Button.getText());
        p0.SetLeft(left0Button.getText());
        p0.SetRight(right0Button.getText());
        p0.SetHoney(honey0Button.getText());
        p0.SetOil(oil0Button.getText());
        controller.AddPlayer(p0);

	    if(active1.isSelected())
        {
            image = new Image("file:textures/worker1.png");
            PlayerView p1 = new PlayerView(playerName1.getText(), image, (int) strength1Box.getValue(), result1);
            p1.SetUp(up1Button.getText());
            p1.SetDown(down1Button.getText());
            p1.SetLeft(left1Button.getText());
            p1.SetRight(right1Button.getText());
            p1.SetHoney(honey1Button.getText());
            p1.SetOil(oil1Button.getText());
            controller.AddPlayer(p1);
        }

        if(active2.isSelected())
        {
            image = new Image("file:textures/worker2.png");
            PlayerView p2 = new PlayerView(playerName2.getText(), image, (int) strength2Box.getValue(), result2);
            p2.SetUp(up2Button.getText());
            p2.SetDown(down2Button.getText());
            p2.SetLeft(left2Button.getText());
            p2.SetRight(right2Button.getText());
            p2.SetHoney(honey2Button.getText());
            p2.SetOil(oil2Button.getText());
            controller.AddPlayer(p2);
        }

        if(active3.isSelected())
        {
            image = new Image("file:textures/worker3.png");
            PlayerView p3 = new PlayerView(playerName3.getText(), image, (int) strength3Box.getValue(), result3);
            p3.SetUp(up3Button.getText());
            p3.SetDown(down3Button.getText());
            p3.SetLeft(left3Button.getText());
            p3.SetRight(right3Button.getText());
            p3.SetHoney(honey3Button.getText());
            p3.SetOil(oil3Button.getText());
            controller.AddPlayer(p3);
        }

        if(active4.isSelected())
        {
            image = new Image("file:textures/worker4.png");
            PlayerView p4 = new PlayerView(playerName4.getText(), image, (int) strength4Box.getValue(), result4);
            p4.SetUp(up4Button.getText());
            p4.SetDown(down4Button.getText());
            p4.SetLeft(left4Button.getText());
            p4.SetRight(right4Button.getText());
            p4.SetHoney(honey4Button.getText());
            p4.SetOil(oil4Button.getText());
            controller.AddPlayer(p4);
        }

        if(active5.isSelected())
        {
            image = new Image("file:textures/worker5.png");
            PlayerView p5 = new PlayerView(playerName5.getText(), image, (int) strength5Box.getValue(), result5);
            p5.SetUp(up5Button.getText());
            p5.SetDown(down5Button.getText());
            p5.SetLeft(left5Button.getText());
            p5.SetRight(right5Button.getText());
            p5.SetHoney(honey5Button.getText());
            p5.SetOil(oil5Button.getText());
            controller.AddPlayer(p5);
        }

        if(active6.isSelected())
        {
            image = new Image("file:textures/worker6.png");
            PlayerView p6 = new PlayerView(playerName6.getText(), image, (int) strength6Box.getValue(), result6);
            p6.SetUp(up6Button.getText());
            p6.SetDown(down6Button.getText());
            p6.SetLeft(left6Button.getText());
            p6.SetRight(right6Button.getText());
            p6.SetHoney(honey6Button.getText());
            p6.SetOil(oil6Button.getText());
            controller.AddPlayer(p6);
        }

        if(active7.isSelected())
        {
            image = new Image("file:textures/worker7.png");
            PlayerView p7 = new PlayerView(playerName7.getText(), image, (int) strength7Box.getValue(), result7);
            p7.SetUp(up7Button.getText());
            p7.SetDown(down7Button.getText());
            p7.SetLeft(left7Button.getText());
            p7.SetRight(right7Button.getText());
            p7.SetHoney(honey7Button.getText());
            p7.SetOil(oil7Button.getText());
            controller.AddPlayer(p7);
        }

        map = new Map();
        controller.AddMap(map);
        String path = "maps/" + (String) mapSelect.getValue() + ".map";
        map.Load(controller, path);

        gameScene.setOnKeyPressed(event ->{
            GameStatus ret = controller.Act(event.getCode().toString().toUpperCase());

            if (ret == GameStatus.Winner)
            {
                PlayerView winner = controller.getWinner();
                primaryStage1.setScene(mainMenu);
                primaryStage1.show();
                winnerLabel.setText("Congratulations " + winner.name + "!\nYou won!");
                controller.Clear();
            }

            if (ret == GameStatus.MainMenu)
            {
                primaryStage1.setScene(mainMenu);
                primaryStage1.show();
                winnerLabel.setText("");
                controller.Clear();
            }
        });
	}

    /**
     * Ha active akkor engedelyezi az elso jatekos beallitasat
     */
	public void active1Handle() {
		if (active1.isSelected())
		{
			playerName1.setDisable(false);
			down1Button.setDisable(false);
			up1Button.setDisable(false);
			left1Button.setDisable(false);
			right1Button.setDisable(false);
			honey1Button.setDisable(false);
			oil1Button.setDisable(false);
			strength1Box.setDisable(false);
		}
		else
		{
			playerName1.setDisable(true);
			down1Button.setDisable(true);
			up1Button.setDisable(true);
			left1Button.setDisable(true);
			right1Button.setDisable(true);
			honey1Button.setDisable(true);
			oil1Button.setDisable(true);
			strength1Box.setDisable(true);
		}
	}

    /**
     * Ha active akkor engedelyezi a masodik jatekos beallitasat
     */
	public void active2Handle() {
		if (active2.isSelected())
		{
			playerName2.setDisable(false);
			down2Button.setDisable(false);
			up2Button.setDisable(false);
			left2Button.setDisable(false);
			right2Button.setDisable(false);
			honey2Button.setDisable(false);
			oil2Button.setDisable(false);
			strength2Box.setDisable(false);
		}
		else
		{
			playerName2.setDisable(true);
			down2Button.setDisable(true);
			up2Button.setDisable(true);
			left2Button.setDisable(true);
			right2Button.setDisable(true);
			honey2Button.setDisable(true);
			oil2Button.setDisable(true);
			strength2Box.setDisable(true);
		}
	}

    /**
     * Ha active akkor engedelyezi a harmadik jatekos beallitasat
     */
	public void active3Handle() {
		if (active3.isSelected())
		{
			playerName3.setDisable(false);
			down3Button.setDisable(false);
			up3Button.setDisable(false);
			left3Button.setDisable(false);
			right3Button.setDisable(false);
			honey3Button.setDisable(false);
			oil3Button.setDisable(false);
			strength3Box.setDisable(false);
		}
		else
		{
			playerName3.setDisable(true);
			down3Button.setDisable(true);
			up3Button.setDisable(true);
			left3Button.setDisable(true);
			right3Button.setDisable(true);
			honey3Button.setDisable(true);
			oil3Button.setDisable(true);
			strength3Box.setDisable(true);
		}
	}

    /**
     * Ha active akkor engedelyezi a negyedik jatekos beallitasat
     */
    public void active4Handle() {
		if (active4.isSelected())
		{
			playerName4.setDisable(false);
			down4Button.setDisable(false);
			up4Button.setDisable(false);
			left4Button.setDisable(false);
			right4Button.setDisable(false);
			honey4Button.setDisable(false);
			oil4Button.setDisable(false);
			strength4Box.setDisable(false);
		}
		else
		{
			playerName4.setDisable(true);
			down4Button.setDisable(true);
			up4Button.setDisable(true);
			left4Button.setDisable(true);
			right4Button.setDisable(true);
			honey4Button.setDisable(true);
			oil4Button.setDisable(true);
			strength4Box.setDisable(true);
		}
	}

    /**
     * Ha active akkor engedelyezi az otodik jatekos beallitasat
     */
    public void active5Handle() {
		if (active5.isSelected())
		{
			playerName5.setDisable(false);
			down5Button.setDisable(false);
			up5Button.setDisable(false);
			left5Button.setDisable(false);
			right5Button.setDisable(false);
			honey5Button.setDisable(false);
			oil5Button.setDisable(false);
			strength5Box.setDisable(false);
		}
		else
		{
			playerName5.setDisable(true);
			down5Button.setDisable(true);
			up5Button.setDisable(true);
			left5Button.setDisable(true);
			right5Button.setDisable(true);
			honey5Button.setDisable(true);
			oil5Button.setDisable(true);
			strength5Box.setDisable(true);
		}
	}

    /**
     * Ha active akkor engedelyezi a hatodik jatekos beallitasat
     */
	public void active6Handle() {
		if (active6.isSelected())
		{
			playerName6.setDisable(false);
			down6Button.setDisable(false);
			up6Button.setDisable(false);
			left6Button.setDisable(false);
			right6Button.setDisable(false);
			honey6Button.setDisable(false);
			oil6Button.setDisable(false);
			strength6Box.setDisable(false);
		}
		else
		{
			playerName6.setDisable(true);
			down6Button.setDisable(true);
			up6Button.setDisable(true);
			left6Button.setDisable(true);
			right6Button.setDisable(true);
			honey6Button.setDisable(true);
			oil6Button.setDisable(true);
			strength6Box.setDisable(true);
		}
	}

    /**
     * Ha active akkor engedelyezi a hetedik jatekos beallitasat
     */
	public void active7Handle() {
        if (active7.isSelected()) {
            playerName7.setDisable(false);
            down7Button.setDisable(false);
            up7Button.setDisable(false);
            left7Button.setDisable(false);
            right7Button.setDisable(false);
            honey7Button.setDisable(false);
            oil7Button.setDisable(false);
            strength7Box.setDisable(false);
        } else {
            playerName7.setDisable(true);
            down7Button.setDisable(true);
            up7Button.setDisable(true);
            left7Button.setDisable(true);
            right7Button.setDisable(true);
            honey7Button.setDisable(true);
            oil7Button.setDisable(true);
            strength7Box.setDisable(true);
        }
    }

    /**
     * Az iranyitast beallito gombok esemenykezeloi
     */
    //////////////////////////////////// ButtonHandlerek ////////////////////////////////////

    /**
     * Igaz, hogyha a gomb most lett kivalasztva
     */
    private static boolean buttonSelected = false;

    /**
     * A(z) up0 gomb esemenykezeloje
     */
	public void up0ButtonHandle() {
	    buttonSelected = true;
		up0Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up0Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left0 gomb esemenykezeloje
     */
	public void left0ButtonHandle() {
        buttonSelected = true;
        left0Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left0Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down0 gomb esemenykezeloje
     */
	public void down0ButtonHandle() {
        buttonSelected = true;
        down0Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down0Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right0 gomb esemenykezeloje
     */
	public void right0ButtonHandle() {
        buttonSelected = true;
        right0Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right0Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey0 gomb esemenykezeloje
     */
	public void honey0ButtonHandle() {
        buttonSelected = true;
        honey0Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey0Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) oil0 gomb esemenykezeloje
     */
    public void oil0ButtonHandle() {
        buttonSelected = true;
        oil0Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil0Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) up1 gomb esemenykezeloje
     */
    public void up1ButtonHandle() {
        buttonSelected = true;
        up1Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up1Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left1 gomb esemenykezeloje
     */
	public void left1ButtonHandle() {
        buttonSelected = true;
        left1Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left1Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down1 gomb esemenykezeloje
     */
	public void down1ButtonHandle() {
        buttonSelected = true;
        down1Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down1Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right1 gomb esemenykezeloje
     */
	public void right1ButtonHandle() {
        buttonSelected = true;
        right1Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right1Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey1 gomb esemenykezeloje
     */
	public void honey1ButtonHandle() {
        buttonSelected = true;
        honey1Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey1Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) oil1 gomb esemenykezeloje
     */
	public void oil1ButtonHandle() {
        buttonSelected = true;
        oil1Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil1Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) up2 gomb esemenykezeloje
     */
    public void up2ButtonHandle() {
        buttonSelected = true;
        up2Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up2Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left2 gomb esemenykezeloje
     */
    public void left2ButtonHandle() {
        buttonSelected = true;
        left2Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left2Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down2 gomb esemenykezeloje
     */
	public void down2ButtonHandle() {
        buttonSelected = true;
        down2Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down2Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right2 gomb esemenykezeloje
     */
	public void right2ButtonHandle() {
        buttonSelected = true;
        right2Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right2Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey2 gomb esemenykezeloje
     */
	public void honey2ButtonHandle() {
        buttonSelected = true;
        honey2Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey2Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) oil2 gomb esemenykezeloje
     */
	public void oil2ButtonHandle() {
        buttonSelected = true;
        oil2Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil2Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) up3 gomb esemenykezeloje
     */
    public void up3ButtonHandle() {
        buttonSelected = true;
        up3Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up3Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left3 gomb esemenykezeloje
     */
	public void left3ButtonHandle() {
        buttonSelected = true;
        left3Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left3Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down3 gomb esemenykezeloje
     */
	public void down3ButtonHandle() {
        buttonSelected = true;
        down3Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down3Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right3 gomb esemenykezeloje
     */
	public void right3ButtonHandle() {
        buttonSelected = true;
        right3Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right3Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey3 gomb esemenykezeloje
     */
	public void honey3ButtonHandle() {
        buttonSelected = true;
        honey3Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey3Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) oil3 gomb esemenykezeloje
     */
	public void oil3ButtonHandle() {
        buttonSelected = true;
        oil3Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil3Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) up4 gomb esemenykezeloje
     */
	public void up4ButtonHandle() {
        buttonSelected = true;
        up4Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up4Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left4 gomb esemenykezeloje
     */
	public void left4ButtonHandle() {
        buttonSelected = true;
        left4Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left4Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down4 gomb esemenykezeloje
     */
	public void down4ButtonHandle() {
        buttonSelected = true;
        down4Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down4Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right4 gomb esemenykezeloje
     */
	public void right4ButtonHandle() {
        buttonSelected = true;
        right4Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right4Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey4 gomb esemenykezeloje
     */
	public void honey4ButtonHandle() {
        buttonSelected = true;
        honey4Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey4Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) oil4 gomb esemenykezeloje
     */
    public void oil4ButtonHandle() {
        buttonSelected = true;
        oil4Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil4Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) up5 gomb esemenykezeloje
     */
	public void up5ButtonHandle() {
        buttonSelected = true;
        up5Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up5Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left5 gomb esemenykezeloje
     */
	public void left5ButtonHandle() {
        buttonSelected = true;
        left5Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left5Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down5 gomb esemenykezeloje
     */
	public void down5ButtonHandle() {
        buttonSelected = true;
        down5Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down5Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right5 gomb esemenykezeloje
     */
	public void right5ButtonHandle() {
        buttonSelected = true;
        right5Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right5Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey5 gomb esemenykezeloje
     */
	public void honey5ButtonHandle() {
        buttonSelected = true;
        honey5Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey5Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) oil5 gomb esemenykezeloje
     */
	public void oil5ButtonHandle() {
        buttonSelected = true;
        oil5Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil5Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) up6 gomb esemenykezeloje
     */
	public void up6ButtonHandle() {
        buttonSelected = true;
        up6Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up6Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left6 gomb esemenykezeloje
     */
	public void left6ButtonHandle() {
        buttonSelected = true;
        left6Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left6Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down6 gomb esemenykezeloje
     */
	public void down6ButtonHandle() {
        buttonSelected = true;
        down6Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down6Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right6 gomb esemenykezeloje
     */
	public void right6ButtonHandle() {
        buttonSelected = true;
        right6Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right6Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey6 gomb esemenykezeloje
     */
	public void honey6ButtonHandle() {
        buttonSelected = true;
        honey6Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey6Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}


    /**
     * A(z) oil6 gomb esemenykezeloje
     */
	public void oil6ButtonHandle() {
        buttonSelected = true;
        oil6Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil6Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) up7 gomb esemenykezeloje
     */
	public void up7ButtonHandle() {
        buttonSelected = true;
        up7Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                up7Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) left7 gomb esemenykezeloje
     */
	public void left7ButtonHandle() {
        buttonSelected = true;
        left7Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                left7Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) down7 gomb esemenykezeloje
     */
	public void down7ButtonHandle() {
        buttonSelected = true;
        down7Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                down7Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) right7 gomb esemenykezeloje
     */
	public void right7ButtonHandle() {
        buttonSelected = true;
        right7Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                right7Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) honey7 gomb esemenykezeloje
     */
	public void honey7ButtonHandle() {
        buttonSelected = true;
        honey7Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                honey7Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * A(z) oil7 gomb esemenykezeloje
     */
	public void oil7ButtonHandle() {
        buttonSelected = true;
        oil7Button.setOnKeyPressed(event ->
        {
            if(buttonSelected)
            {
                oil7Button.setText(event.getCode().toString().toUpperCase());
                buttonSelected = false;
            }
        });
	}

    /**
     * Visszaadja a Floor szintu ImageView-t
     * @param x az x koordinata
     * @param y az y koordinata
     * @return az ImageView
     */
	public static ImageView getFloorImageView(int x, int y)
    {
        return (ImageView) imageViewList.get(18*y + x);
    }

    /**
     * Visszaadja a Thing szintu ImageView-t
     * @param x az x koordinata
     * @param y az y koordinata
     * @return az ImageView
     */
    public static ImageView getThingImageView(int x, int y)
    {
        return (ImageView) imageViewList.get(18*y + x + 234);
    }

	////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A program main fuggvenye
     * @param args Argumentumok
     */
	public static void main(String[] args)
	{
		launch(args);
	}

    /**
     * Az application osztaly start fuggvenye
     * @param primaryStage PrimaryStage
     * @throws Exception Hat ez kell
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    controller = new Controller();
		primaryStage1 = primaryStage;
		primaryStage1.setResizable(false);
		
		main = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		mainMenu = new Scene(main, 640, 480);
		ObservableList list = main.getChildrenUnmodifiable();
		winnerLabel = (Label) list.get(2);
		
		play = FXMLLoader.load(getClass().getResource("PlayMenu.fxml"));
		playMenu = new Scene(play, 640, 480);
		list = play.getChildrenUnmodifiable();
		HBox box = (HBox) list.get(1);
		list = box.getChildrenUnmodifiable();
		ComboBox maps = (ComboBox) list.get(0);
        maps.setItems(FXCollections.observableArrayList(
                new String("BridgeWar"), new String("ItsaTrap"), new String("MediumRandomPlusE"), new String("Loss")));
        maps.setValue("BridgeWar");
        list = play.getChildrenUnmodifiable();
        VBox vBox = (VBox) list.get(3);
        list = vBox.getChildrenUnmodifiable();
        box = (HBox) list.get(1);
        ObservableList line = box.getChildrenUnmodifiable();
        ComboBox strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);
        box = (HBox) list.get(2);
        line = box.getChildrenUnmodifiable();
        strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);
        box = (HBox) list.get(3);
        line = box.getChildrenUnmodifiable();
        strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);
        box = (HBox) list.get(4);
        line = box.getChildrenUnmodifiable();
        strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);
        box = (HBox) list.get(5);
        line = box.getChildrenUnmodifiable();
        strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);
        box = (HBox) list.get(6);
        line = box.getChildrenUnmodifiable();
        strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);
        box = (HBox) list.get(7);
        line = box.getChildrenUnmodifiable();
        strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);
        box = (HBox) list.get(8);
        line = box.getChildrenUnmodifiable();
        strength = (ComboBox) line.get(9);
        strength.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        strength.setValue(1);

        game = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
		gameScene = new Scene(game, 640, 480);
		list = game.getChildrenUnmodifiable();
		box = (HBox) list.get(1);
		list = box.getChildrenUnmodifiable();
        GridPane palya = (GridPane) list.get(1);
		imageViewList = palya.getChildrenUnmodifiable();
		list = game.getChildrenUnmodifiable();
		box = (HBox) list.get(0);
		list = box.getChildrenUnmodifiable();
        result0 = (Label) list.get(0);
        result1 = (Label) list.get(1);
        result2 = (Label) list.get(2);
        result3 = (Label) list.get(3);
        result4 = (Label) list.get(4);
        result5 = (Label) list.get(5);
        result6 = (Label) list.get(6);
        result7 = (Label) list.get(7);

        primaryStage1.setTitle("Killer Sokoban");
		primaryStage1.setScene(mainMenu);
		primaryStage1.show();
	}

}
