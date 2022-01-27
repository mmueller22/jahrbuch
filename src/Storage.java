import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Storage {
    public boolean saveFile(Jahrbuch object) {
		try{
			FileOutputStream fileOut = new FileOutputStream(String.format("tmp/session %s.ser", getTime()));
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			out.close();
			fileOut.close();
			System.out.println(String.format("Serialized data is saved in %s", chooseFile("tmp")));
			return true;
      } catch (IOException i) {
         	i.printStackTrace();
		 	return false;
      }
	}

    public Jahrbuch readFile(String directory) {
		try {
			FileInputStream fileIn = new FileInputStream(chooseFile(directory));
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Jahrbuch object = (Jahrbuch) in.readObject();
			in.close();
			fileIn.close();
			return object;
		 } catch (IOException i) {
			i.printStackTrace();
			return null;
		 } catch (ClassNotFoundException c) {
			System.out.println("Jahrbuch class not found");
			c.printStackTrace();
			return null;
		 }
		
	}

	public boolean fileAvailable(String directory){
			File newFile = new File(chooseFile(directory));
			if (newFile.isFile()) {
				return true;
			} else {
				return false;
			}
	}

	private String chooseFile(String directory){
		String[] allfiles = new File(directory).list();
		if (allfiles.length > 1) {
			return directory + allfiles[allfiles.length-1];
		} else {
			return directory;
		}
	}

	private String getTime(){
		LocalDateTime dateAndTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		return dateAndTime.format(dateTimeFormatter);
	}
}