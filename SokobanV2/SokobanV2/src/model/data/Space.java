package model.data;


public class Space extends GameObject {
	
	public Space() {
		// TODO Auto-generated constructor stub
	}
	
	public Space(Position2D pos) {
		this.setPos(pos);
		this.setType("Space");
		this.setSolid(false);
		this.setOn(false);
	}
	
	public Space(int x,int y) {
		this.setPos(x, y);
		this.getPos().setY(y);
		this.setType("Space");
		this.setSolid(false);
		this.setOn(false);
	}

}
