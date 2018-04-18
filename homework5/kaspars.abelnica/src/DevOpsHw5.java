import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DevOpsHw5 {

	public static void main(String[] args) {
		try {
			//File load
			File fin = new File("app.properties");
			FileInputStream fileInput = new FileInputStream(fin);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			
			//property change
			properties.setProperty("version", "1.1");
			properties.setProperty("name", "HW5");
			
			//property print to new file
			File fout = new File("hw5.properties");
			FileOutputStream fileOutput = new FileOutputStream(fout);
			properties.store(fileOutput, null);
			fileOutput.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
