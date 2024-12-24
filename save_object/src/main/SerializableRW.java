package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableRW {

	public static void saveObj(String filename, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));) {
			oos.writeObject(obj);
			System.out.println("保存しました");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("保存失敗");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("保存失敗");
		}

	}

	public static Object readObj(String filename) {
		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(filename))) {
			return oos.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
