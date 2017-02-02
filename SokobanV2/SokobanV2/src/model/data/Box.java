package model.data;


public class Box extends GameObject {
	
	public Box() {
		// TODO Auto-generated constructor stub
	}
	
	public Box(Position2D pos) {
		this.setPos(pos);
		this.setType("Box");
		this.setSolid(true);
		this.setOn(false);
	}

}
