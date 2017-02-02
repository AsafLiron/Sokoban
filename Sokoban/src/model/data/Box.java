package model.data;

public class Box extends GameObject {
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

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
