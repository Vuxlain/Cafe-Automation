import java.io.BufferedReader;
import java.io.BufferedWriter;

public interface MenuIF {
	public void menuLog(String process);
	public void addItem(String item, int cost);
	public void deleteItem(BufferedReader rd, String item);
	public void updateItem(String oldString, String newString);
	public void printtxt(BufferedReader rd);
	public String readtxt(BufferedReader rd);
}
