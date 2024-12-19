package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableWrite {

	public static void main(String[] args) {
		Human human = new Human("John", 15);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("human.obj"));) {
			oos.writeObject(human);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
