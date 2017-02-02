package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

import general.Level;
import model.data.Box;
import model.data.Destination;
import model.data.MyObjectLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;
import model.data.ObjectLevelSaver;
import model.data.PlayableCharacter;
import model.data.Space;
import model.data.TextLevelSaver;
import model.data.XmlLevelSaver;
import model.policy.MySokobanPolicy;

public class MyModel extends Observable implements Model {
	HashMap<String, String> exten;
	String name;
	MySokobanPolicy msp;
	Level l;

	@Override
	public void loadLevel(String[] arr) throws ClassNotFoundException, IOException {
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);

		exten = new HashMap<String,String>();
	    exten.put("xml", "1");
	    exten.put("object","2");
	    exten.put("txt", "3");
	    String scs=arr[0];
	    InputStream io = new FileInputStream(arr[0]);
	    scs=scs.substring(scs.indexOf(".")+1,scs.length());
		switch(exten.get(scs))
	    {
	    case("1"):
	    	this.l=new MyXMLLevelLoader().LoadLevel(io);
	    	break;
	    case("2"):
	    	this.l=new MyObjectLevelLoader().LoadLevel(io);
	    	break;
	    case("3"):
	    	this.l=new MyTextLevelLoader().LoadLevel(io);
	    	break;
	    default:
	    	System.out.println("Error");

	    }
	}
	


	@Override
	public void saveLevel() throws IOException {
		exten = new HashMap<String,String>();
	    exten.put("xml", "1");
	    exten.put("object","2");
	    exten.put("text", "3");
		System.out.println("Select Save Type");
		System.out.println("XML/Object/Text");
		Scanner sc = new Scanner(System.in);
		String scs=sc.next();
		scs.toLowerCase();
		System.out.println("Choose name to save the level");
		Scanner lc = new Scanner(System.in);
		name=lc.next();
		OutputStream os = new FileOutputStream(new File(name));
	    switch(exten.get(scs))
	    {
	    case("1"):
	    	new XmlLevelSaver().saveLevel(os, l);
	    	break;
	    case("2"):
	    	new ObjectLevelSaver().saveLevel(os, l);
	    	break;
	    case("3"):
	    	new TextLevelSaver().saveLevel(os,l);
	    	break;
	    default:
	    	System.out.println("Error");

	    }
	}

	@Override
	public void exit() {
		System.out.println("Exiting The Game");
		System.exit(1);
		
	}

	@Override
	public Level getLevel() {
		return this.l;
	}

	@Override
	public void moveCommandUP() {
		PlayableCharacter pc= this.getChar();
		msp= new MySokobanPolicy(this.l);
		if(msp.moveLeft(pc)==false)
		{
			System.out.println("why");
			return;
		}
		if(this.l.getItems().get(pc.getPos().getY()-1).get(pc.getPos().getX()).getType().equals("Box"))
		{
			System.out.println("22222");
			Box b = new Box(this.l.getItems().get(pc.getPos().getY()-1).get(pc.getPos().getX()).getPos());
			movingIt(b,"Up");
		}
		else
		{
			System.out.println(this.l.getItems().get(pc.getPos().getY()-1).get(pc.getPos().getX()).getType());
		}
		movingIt(pc,"Up");
	}

	@Override
	public void moveCommandDown() {
		PlayableCharacter pc= this.getChar();
		msp= new MySokobanPolicy(this.l);
		if(msp.moveLeft(pc)==false)
			return;
		if(this.l.getItems().get(pc.getPos().getY()+1).get(pc.getPos().getX()).getType().equals("Box"))
		{
			Box b = new Box(this.l.getItems().get(pc.getPos().getY()+1).get(pc.getPos().getX()).getPos());
			movingIt(b,"Down");
		}
		movingIt(pc,"Down");

		
	}

	@Override
	public void moveCommandRight() {
		PlayableCharacter pc= this.getChar();
		msp= new MySokobanPolicy(this.l);
		if(msp.moveLeft(pc)==false)
			return;
		if(this.l.getItems().get(pc.getPos().getY()).get(pc.getPos().getX()+1).getType().equals("Box"))
		{
			Box b = new Box(this.l.getItems().get(pc.getPos().getY()).get(pc.getPos().getX()+1).getPos());
			movingIt(b,"Right");
		}
		movingIt(pc,"Right");
		
		
	}

	@Override
	public void moveCommandLeft() {
		PlayableCharacter pc= this.getChar();
		msp= new MySokobanPolicy(this.l);
		if(msp.moveLeft(pc)==false)
			return;
		if(this.l.getItems().get(pc.getPos().getY()).get(pc.getPos().getX()-1).getType().equals("Box"))
		{
			Box b = new Box(this.l.getItems().get(pc.getPos().getY()).get(pc.getPos().getX()-1).getPos());
			movingIt(b,"Left");
		}
		movingIt(pc,"Left");
		
	
	}

	@Override
	public PlayableCharacter getChar() {
		return this.l.getActors().get(0);
	}
	
	public void movingIt(Box o,String direction)
	{
		boolean finish=false;
		boolean onTarget=false;
		if(this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()).getType().equals("Destination"))
		{
			onTarget=true;
		}

		if(direction.equals("Up"))
		{
			if(this.l.getItems().get(o.getPos().getY()-1).get(o.getPos().getX()).getType().equals("Destination"))
			{
				finish=true;
			}

			this.l.getItems().get(o.getPos().getY()-1).set(o.getPos().getX(), o);
			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()-1).get(o.getPos().getX()).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()-1).get(o.getPos().getX()).getPos().setY(o.getPos().getY()-1);;
		}
		else if(direction.equals("Down"))
		{
			
			if(this.l.getItems().get(o.getPos().getY()+1).get(o.getPos().getX()).getType().equals("Destination"))
			{
				finish=true;
			}
			this.l.getItems().get(o.getPos().getY()+1).set(o.getPos().getX(), o);

			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()+1).get(o.getPos().getX()).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()+1).get(o.getPos().getX()).getPos().setY(o.getPos().getY()+1);;
		}
		else if(direction.equals("Right"))
		{
			if(this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).getType().equals("Destination"))
			{
				finish=true;
				
			}
			this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX()+1, o);
			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).getPos().setX(o.getPos().getX()+1);;
		}
		else//moving left case
		{
			if(this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()-1).getType().equals("Destination"))
			{
				finish=true;
				
			}
			this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), o);
			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()-1).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).getPos().setX(o.getPos().getX()-1);;
		}
	}

	public void movingIt(PlayableCharacter o,String direction)
	{
		boolean finish=false;
		boolean onTarget=false;
		if(this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()).getType().equals("Destination"))
		{
			onTarget=true;
		}
		if(direction.equals("Up"))
		{
			if(this.l.getItems().get(o.getPos().getY()-1).get(o.getPos().getX()).getType().equals("Destination"))
			{
				finish=true;
			}
			this.l.getItems().get(o.getPos().getY()-1).set(o.getPos().getX(), o);
			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()-1).get(o.getPos().getX()).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()-1).get(o.getPos().getX()).getPos().setY(o.getPos().getY()-1);
			this.l.getActors().get(0).getPos().setY(o.getPos().getY());
		}
		else if(direction.equals("Down"))
		{
			if(this.l.getItems().get(o.getPos().getY()+1).get(o.getPos().getX()).getType().equals("Destination"))
			{
				finish=true;
			}
			this.l.getItems().get(o.getPos().getY()+1).set(o.getPos().getX(), o);
			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()+1).get(o.getPos().getX()).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()+1).get(o.getPos().getX()).getPos().setY(o.getPos().getY()+1);
			this.l.getActors().get(0).getPos().setY(o.getPos().getY());
		}
		else if(direction.equals("Right"))
		{
			if(this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).getType().equals("Destination"))
			{
				finish=true;
				
			}
			this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX()+1, o);
			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).getPos().setX(o.getPos().getX()+1);
			this.l.getActors().get(0).getPos().setX(o.getPos().getX());

		}
		else//moving left case
		{
			if(this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()-1).getType().equals("Destination"))
			{
				finish=true;
				
			}
			this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX()-1, o);
			if(finish==true)
			{
				this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()-1).setOn(true);
			}
			if(onTarget==true)
			{
				Destination dest= new Destination(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), dest);
			}
			else
			{
				Space sp= new Space(o.getPos());
				this.l.getItems().get(o.getPos().getY()).set(o.getPos().getX(), sp);
			}
			this.l.getItems().get(o.getPos().getY()).get(o.getPos().getX()+1).getPos().setX(o.getPos().getX()-1);
			this.l.getActors().get(0).getPos().setX(o.getPos().getX());
		}
	}


	

}
