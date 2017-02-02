package model.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import general.Level;

public class MyTextLevelLoader implements LevelLoader{
	String line;
	
	public MyTextLevelLoader() {
	}
	
	@Override
	public Level LoadLevel(InputStream io ) throws IOException
	{
		Level l = new Level();
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(io));
		int y=0;
		 line=in.readLine();
		
		while(line != null)
		{
			
			l.getItems().add(new ArrayList<GameObject>());
			for(int i=0; i<line.length();i++)
			{
				Position2D pos=null;
				switch(line.charAt(i))
				{
				case('#'):
					pos=new Position2D(i,y);
					l.getItems().get(y).add(new Wall(pos));
					break;
				case('o'):
					pos=new Position2D(i,y);
					l.getItems().get(y).add(new Destination(pos));
					break;
				case('A'):
					pos=new Position2D(i,y);
					System.out.print(i);
					System.out.println(y);
					l.getItems().get(y).add(new PlayableCharacter(pos));
					l.getActors().add(new PlayableCharacter(pos));
					break;
				case('%'):
					pos=new Position2D(i,y);
					l.getItems().get(y).add(new PlayableCharacter(pos));
					l.getActors().add(new PlayableCharacter(pos));
					l.getItems().get(y).get(i).setOn(true);
					//l.getItems().get(y).add(new Destination(pos));
					break;
				case(' '):
					pos=new Position2D(i,y);
					l.getItems().get(y).add(new Space(pos));
					break;
				case('@'):
					pos=new Position2D(i,y);
					l.getItems().get(y).add(new Box(pos));
					
					break;
				case('$'):
					pos=new Position2D(i,y);
					l.getItems().get(y).add(new Box(pos));
					//l.getItems().get(y).add(new Destination(pos));
					l.getItems().get(y).get(i).setOn(true);
					break;
				}
			}
			y++;
			line=in.readLine();
		}
		
		System.out.println("Load Successfully");
		return l;
	}
	

}