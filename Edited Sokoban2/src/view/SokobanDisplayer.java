package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import general.Level;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class SokobanDisplayer extends Canvas{

	 Level l;


	public SokobanDisplayer() {
		// TODO Auto-generated constructor stub
	}

	public SokobanDisplayer(Level l) {

		this.l=l;
	}




	public void redraw() throws URISyntaxException
	{
		if(l!=null)
		{
			 Image wall=null,dest=null,player=null,space=null,box=null;

			double W = getWidth();
			double H = getHeight();
			double w=W/l.getWidth();
			double h=H/l.getHeight();

			GraphicsContext gc=getGraphicsContext2D();
			gc.setFill(Color.WHITE);

			try{
				wall = new Image(new FileInputStream("./resources/Items/Wall.jpg"));
				box = new Image(new FileInputStream("./resources/Items/Box.jpg"));
				dest = new Image(new FileInputStream("./resources/Items/Destination.jpg"));
				player = new Image(new FileInputStream("./resources/Items/Player.png"));
				space = new Image(new FileInputStream("./resources/Items/Space.jpg"));

			} catch(FileNotFoundException e){
				e.printStackTrace();
			}


			for(int i=0;i<l.getItems().size();i++)
				for(int j=0;j<l.getItems().get(i).size();j++)
				{
					String s=l.getItems().get(i).get(j).getType().toString();
					if(l.getItems().get(i).get(j)!=null)
					{
						if(l.getItems().get(i).get(j).getType().toString().equals("Wall"))
						{
							gc.drawImage(wall, j*w, i*h, w, h);
							System.out.println(j*w);//check
						}
						if(l.getItems().get(i).get(j).getType().equals("Box"))
							gc.drawImage(box, j*w, i*h , w, h);
						if(l.getItems().get(i).get(j).getType().equals("Space"))
							gc.drawImage(space, j*w, i*h , w, h);
						if(l.getItems().get(i).get(j).getType().equals("PlayableCharacter"))
							gc.drawImage(player, j*w, i*h , w, h);
						if(l.getItems().get(i).get(j).getType().equals("Destination"))
							gc.drawImage(dest, j*w, i*h , w, h);
					}
				}

		}
	}







	public void setLevel(Level l) {
		this.l = l;
	}

	public Level getLevel() {
		return this.l;
	}





}
