import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
	int num;
	int amount;
	
	public Table(int num, int amount) {
		this.num = num;
		this.amount = amount;
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Customer\\Tables\\table"+num+".txt"));
			
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			BufferedWriter wt;
			try {
				wt = new BufferedWriter(new FileWriter("txtFiles\\Customer\\Tables\\table"+num+".txt"));

				wt.write("	Masa "+num+" Siparis Listesi");
				
				wt.close();
			}catch (IOException e1){
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public int deleteOrder(Boolean paid) {
		File file = new File("txtFiles\\Customer\\Tables\\table"+num+".txt");
		boolean temp = true;

		if(paid==temp) {
			file.delete();
			System.out.println("Siparis Odendi. Masa Numarasina Ait txt Silindi.");
			return 1;
		}
		else {
			System.out.println("Siparis Henuz Odenmedi.");
			return 0;
		}
		
	}
	
	public void createOrder(String order) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Customer\\Tables\\table"+num+".txt"));
			String temp = readtxt(rd);
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Customer\\Tables\\table"+num+".txt"));
			
			wt.write(temp+order);
			
			rd.close();
			wt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void seeOrder() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Customer\\Tables\\table"+num+".txt"));
			printtxt(rd);
			
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printtxt(BufferedReader rd) {
		String line;
		try {
			line = rd.readLine();
			while(line!=null){
				System.out.println(line);
				line = rd.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readtxt(BufferedReader rd) {
		String line;
		String read = "";
		try {
			do{
				line = rd.readLine();
				if(line!=null) {
					read += line+"\n";
				}
			}while(line!=null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 	
		}
		return read;
	}	 
	
}
