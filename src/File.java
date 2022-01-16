import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File {
    public boolean saveFile(String name, Jahrbuch object) {
		try{
			FileOutputStream fileOut = new FileOutputStream(String.format("src/%s.ser", name));
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			out.close();
			fileOut.close();
			System.out.println(String.format("Serialized data is saved in /src/%s.ser", name));
			return true;
      } catch (IOException i) {
         i.printStackTrace();
		 return false;
      }
	}

    public Jahrbuch readFile(String path) {
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Jahrbuch object = (Jahrbuch) in.readObject();
			in.close();
			fileIn.close();
			return object;
		 } catch (IOException i) {
			i.printStackTrace();
			return null;
		 } catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return null;
		 }
		
	}
}
