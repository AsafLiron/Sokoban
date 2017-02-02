package model.data;

public abstract class Character extends GameObject {
	int str;
	boolean flag;
	
	public Character() {
		str=1;
	}
	
	public Character(Position2D pos) {
		this.setPos(pos);
		this.setOn(false);
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}
	
	

}
