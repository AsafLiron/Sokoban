package model.data;


public class Destination extends GameObject {
	
	public Destination() {
		// TODO Auto-generated constructor stub
	}
	
	public Destination(Position2D pos) {
		this.pos=new Position2D(pos.getX(),pos.getY());
		this.setSolid(false);
		this.setType("Destination");
		this.setOn(false);
	}


	
	

}
