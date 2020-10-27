package cmps252.HW4_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class FileParser {
	public static ArrayList<Customer> getCustomers(String fileName) throws FileNotFoundException {
		ArrayList<Customer> result = new ArrayList<Customer>();
		//File file = new File(fileName);
		//BufferedReader br = new BufferedReader(new FileReader(file)); 
		String currentDirectory = new File("").getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(currentDirectory + "/" + fileName));
		String entry = null;
		try {
			br.readLine();
			entry = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (entry != null) {
			String[] fields = entry.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for(int i = 0; i < fields.length; i++) {
				fields[i] = fields[i].replace("\"", "");
			}
			result.add(new Customer(fields[0],
									fields[1],
									fields[2],
									fields[3],
									fields[4],
									fields[5],
									fields[6],
									fields[7],
									fields[8],
									fields[9],
									fields[10],
									fields[11]));
			try {
				entry = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		return result;
	}
}
