package boot;

import java.io.IOException;
import java.util.Scanner;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		MyView v=new MyView();
		MyModel m=new MyModel();
		String scs;
		MyController c = new MyController(m,v);
		v.addObserver(c);
		m.addObserver(c);
		m.loadLevel();
		while(true)
		{
			v.displayLevel(m.getLevel());
			System.out.println("1/2/3/4");
			Scanner sc = new Scanner(System.in);
			scs=sc.next();
			if(scs.equals("1"))
			m.moveCommandUP();
			if(scs.equals("2"))
				m.moveCommandDown();
			if(scs.equals("3"))
				m.moveCommandRight();
			if(scs.equals("4"))
				m.moveCommandLeft();
			if(scs.equals("5"))
				m.saveLevel();
		}
		
	}

}
