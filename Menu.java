import java.util.Scanner;
import java.io.*;

public class Menu extends MyClass{
	
	Scanner scan = new Scanner(System.in);
	
	public Menu() {
		
		System.out.println("1-Corbalar");
		System.out.println("2-Ana Yemekler");
		System.out.println("3-Kahvalti");
		System.out.println("4-Tatlilar");
		System.out.println("5-Icecekler");
		System.out.println("6-Kayit Listesi");
		System.out.println("0-Ust Menuye Don.");
		int choose = scan.nextInt();
		
		switch(choose) {
			case 1:
				Soups soup = new Soups();
				
				break;
			case 2:
				MainCourses mc = new MainCourses();
				
				break;
			case 3:
				Breakfast breakfast = new Breakfast();
				
				break;
			case 4:
				Desserts desserts = new Desserts();
				
				break;
	 	    case 5:
	 	    	Drinks drink = new Drinks();
	 	    	
	 	    	break;
	 	    case 6:
			BufferedReader rd;
			try {
				rd = new BufferedReader(new FileReader("txtFiles\\Menu\\menuLog.txt"));
				String temp = readtxt(rd);
				
				System.out.println(temp);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	    	break;
	 	    case 0:
	 	    	SystemMenu();
	 	    	break;
			default:
				System.out.println("Gecersiz Deger Girdiniz.");
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
