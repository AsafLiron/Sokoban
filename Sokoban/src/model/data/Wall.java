package model.data;

public class Wall extends GameObject {
	
	public Wall() {
		// TODO Auto-generated constructor stub
	}
	
	public Wall(Position2D pos) {
		this.setPos(pos);
		this.setSolid(true);
		this.setType("Wall");
		this.setOn(false);
	}
	
	public Wall(Wall w) {
		this.setPos(w.getPos());
		this.setSolid(false);
		this.setType("Wall");
		this.setOn(false);
	}

}
