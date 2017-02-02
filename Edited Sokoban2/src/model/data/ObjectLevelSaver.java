package model.data;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import general.Level;

public class ObjectLevelSaver implements LevelSaver {
	
	public ObjectLevelSaver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveLevel(OutputStream os, Level l) throws IOException {
		ObjectOutputStream oos= new ObjectOutputStream(new BufferedOutputStream(os));
		oos.writeObject(l);
		
		oos.flush();
		oos.close();
		System.out.println("Saved Successfully");
		

	}

}
