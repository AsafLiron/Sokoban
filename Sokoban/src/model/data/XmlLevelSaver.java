package model.data;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

import general.Level;

public class XmlLevelSaver implements LevelSaver {
	
	public XmlLevelSaver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveLevel(OutputStream os, Level l) {
		XMLEncoder xmle = new XMLEncoder(new BufferedOutputStream(os));
		xmle.writeObject(l);
		xmle.close();
		System.out.println("Saved Successfully");

		
	}
	



}
