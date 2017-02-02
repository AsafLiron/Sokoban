package model.data;

import java.io.Serializable;

public class Position2D implements Serializable{
	int x;
	int y;
	
	public Position2D() {
		// TODO Auto-generated constructor stub
	}
	
	public Position2D(int x,int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Position2D(Position2D pos) {
		this.setX(pos.getX());
		this.setY(pos.getY());
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Boolean onEach(Position2D pos)
	{
		if((this.getX()==pos.getX()) || (this.getY()==pos.getY()))
			return true;
		
		return false;
	}

}
