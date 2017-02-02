package model.policy;

import model.data.Level;
import model.data.PlayableCharacter;


public class MySokobanPolicy {
	Level l;
	
	public MySokobanPolicy() {
		// TODO Auto-generated constructor stub
	}
	
	public MySokobanPolicy(Level l) {
		this.l=l;
	}
	
	public Boolean moveUp(PlayableCharacter pc)
	{
		int x=pc.getPos().getX();
		int y=pc.getPos().getY();
		
		if(l.getItems().get(y-1).get(x).getSolid()==true)
			return false;
		
		if(l.getItems().get(y-1).get(x).getType().equals("Box"))
		{
			if(l.getItems().get(y-2).get(x).getSolid()==true)
				return false;
		}
		
		
		
		return true;
	}
	
	public Boolean moveDown(PlayableCharacter pc)
	{

		int x=pc.getPos().getX();
		int y=pc.getPos().getY();
		
		if(l.getItems().get(y+1).get(x).getSolid()==true)
			return false;
		
		if(l.getItems().get(y+1).get(x).getType().equals("Box"))
		{
			if(l.getItems().get(y+2).get(x).getSolid()==true)
				return false;
		}
		
		return true;
	}
	
	public Boolean moveRight(PlayableCharacter pc)
	{
		int x=pc.getPos().getX();
		int y=pc.getPos().getY();
		
		if(l.getItems().get(y).get(x+1).getSolid()==true)
			return false;
		
		if(l.getItems().get(y).get(x+1).getType().equals("Box"))
		{
			if(l.getItems().get(y).get(x+2).getSolid()==true)
				return false;
		}
		
		return true;
	}
	
	public Boolean moveLeft(PlayableCharacter pc)
	{
		int x=pc.getPos().getX();
		int y=pc.getPos().getY();
		
		if(l.getItems().get(y).get(x-1).getSolid()==true)
			return false;
		
		if(l.getItems().get(y).get(x-1).getType().equals("Box"))
		{
			if(l.getItems().get(y).get(x-2).getSolid()==true)
				return false;
		}
		
		return true;
	}
	

}
