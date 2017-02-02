package view;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Observable;
import java.util.ResourceBundle;

import general.Level;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import view.SokobanDisplayer;

public class MainWindowController extends Observable implements Initializable,View{

    SokobanDisplayer sokoDisplayer;

    private boolean play;
	private Media startMp3=new Media(new File("./resources./Music./SokobanMusic.mp3").toURI().toString());
	private MediaPlayer player=new MediaPlayer(startMp3);


	public MainWindowController() {

		sokoDisplayer = new SokobanDisplayer();
		play=false;
	}

	public void start() {
		if (sokoDisplayer.getLevel() == null) {
			play=false;
			return;
		}
		play=true;
		String command = "Display";
		LinkedList<String> params = new LinkedList<String>();
		params.add(command);
		params.add("level");
		this.setChanged();
		this.notifyObservers(params);

		sokoDisplayer.requestFocus();

		sokoDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override

			public void handle(KeyEvent event) {

				String direction = "";

				if (event.getCode() == KeyCode.UP) {
					direction = "up";

				} else if (event.getCode() == KeyCode.DOWN) {
					direction = "down";

				} else if (event.getCode() == KeyCode.LEFT) {

					direction = "left";

				} else if (event.getCode() == KeyCode.RIGHT) {
					direction = "right";

				}

				String command = "move";
				LinkedList<String> params = new LinkedList<String>();
				params.add(command);
				params.add(direction);

				setChanged();
				notifyObservers(params);

			}
		});

	}

	public void loadingLevel() {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("open maze");
		chooser.setInitialDirectory(new File("./res./levels"));
		File ch = chooser.showOpenDialog(null);
		if (ch != null) {
			LinkedList<String> params = new LinkedList<String>();
			params.add("load");
			params.add(ch.getAbsolutePath());
			setChanged();
			notifyObservers(params);
		}
		player.play();



	}

	public void savingLevel() {

		if(sokoDisplayer.getLevel()!=null)
		{
			FileChooser cs = new FileChooser();
			cs.setTitle("save maze");
			cs.setInitialDirectory(new File("./resources./save"));
			File c = cs.showSaveDialog(null);
			if (c != null) {
				LinkedList<String> params = new LinkedList<String>();
				params.add("save");
				params.add(c.getAbsolutePath());
				setChanged();
				notifyObservers(params);
			}

		}


	}




	public void stopmusic(){
		player.pause();
	}

	/*public void stop() {
		player.stop();
		Platform.exit();

	}*/
	public void closingLevel(){
		LinkedList<String> params = new LinkedList<String>();
		params.add("Exit");
		setChanged();
		notifyObservers(params);
	}


	@Override
	public void displayLevel(Level l) throws URISyntaxException {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


	/*
	@FXML
	SokobanDisplayer sokoDisplayer;
	Level l;
	File level_on;
	DisplayLevel dl;
	String [] str;

	public MainWindowController() {
		sokoDisplayer = new SokobanDisplayer();
		sokoDisplayer.setL(null);
		str=new String[3];
	}

	@FXML
	public void loadingLevel()
	{
		FileChooser fc = new FileChooser();
		fc.setTitle("Open a level");
		fc.setInitialDirectory(new File("./resources"));
		fc.getExtensionFilters().addAll(
		         new ExtensionFilter("Text Files", "*.txt"),
		         new ExtensionFilter("XML Files", "*.xml"),
		         new ExtensionFilter("Object Files", "*.obj"));


		level_on = fc.showOpenDialog(null);


		if(level_on!=null)
		{
			str[0]=level_on.toPath().toString();
			str[1]="Load";
			setChanged();
			notifyObservers((Object)str);
		}

	}

	public void savingLevel() throws URISyntaxException
	{
		FileChooser fc = new FileChooser();
		fc.setTitle("Open a level");
		fc.setInitialDirectory(new File("./resources"));
		fc.getExtensionFilters().addAll(
		         new ExtensionFilter("Text Files", "*.txt"),
		         new ExtensionFilter("XML Files", "*.xml"),
		         new ExtensionFilter("Object Files", "*.obj"));


		level_on = fc.showOpenDialog(null);
		if(level_on!=null)
		{
			setChanged();
			notifyObservers((Object)"Save");

			sokoDisplayer.redraw();
		}
	}

	public void ExitApp()
	{

		setChanged();
		notifyObservers((Object)"Exit");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sokoDisplayer.setL(l);

	}

	@Override
	public void displayLevel(Level l) throws URISyntaxException {

		sokoDisplayer= new SokobanDisplayer(l);
		sokoDisplayer.setL(l);
		sokoDisplayer.redraw();
	}

	public SokobanDisplayer getSokoDisplayer() {
		return sokoDisplayer;
	}

	public void setSokoDisplayer(SokobanDisplayer sokoDisplayer) {
		this.sokoDisplayer = sokoDisplayer;
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

	public File getLevel_on() {
		return level_on;
	}

	public void setLevel_on(File level_on) {
		this.level_on = level_on;
	}

	public DisplayLevel getDl() {
		return dl;
	}

	public void setDl(DisplayLevel dl) {
		this.dl = dl;
	}

	public String[] getStr() {
		return str;
	}

	public void setStr(String[] str) {
		this.str = str;
	}*/




}
