package model.data;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import general.Level;

public class MyObjectLevelLoader implements LevelLoader{
	
	public MyObjectLevelLoader() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Level LoadLevel(InputStream io) throws ClassNotFoundException, IOException
	{
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(io));
		Level l = (Level) ois.readObject();
		ois.close();
		
		System.out.println("Load Successfully");
		
		return l;
	}




}
