package model.data;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import general.Level;

public class TextLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(OutputStream os, Level l) throws IOException {
		PrintStream printStream = new PrintStream(os);
		
		for(ArrayList<GameObject> arr : l.getItems())
		{
			for(GameObject obj : arr)
			{
				
				if(obj.getOn()==false)
				{
					switch(obj.getType())
					{
					case "Wall":
						printStream.print('#');
						break;
					case "Destination":
						printStream.print('o');
						break;
					case "Space":
						printStream.print(' ');
						break;
					case "PlayableCharacter":
						printStream.print('A');
						break;
					case "Box":
						printStream.print('@');
						break;
					}
				}
				else
				{
					switch(obj.getType())
					{
					case "PlayableCharacter":
						printStream.print('%');
						break;
					case "Box":
						printStream.print('$');
						break;
						
					}
				}
			}
			printStream.println();
		}
		printStream.close();
		System.out.println("Saved Successfully");
	}

}
