import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Drinks extends MyClass implements MenuIF{

	Scanner scan = new Scanner(System.in);
	LocalDateTime time =java.time.LocalDateTime.now();
	
	public Drinks() {
		
		System.out.println("1-Icecekler Menusunu Gormek.");
		System.out.println("2-Icecekler Menusune Ekleme.");
		System.out.println("3-Icecekler Menusunden Silme.");
		System.out.println("4-Icecekler Menusunde Degistirme.");
		System.out.println("0-Bir Onceki Menu.");
		
		int choose = scan.nextInt();
		switch(choose) {
			case 1:	
				try {
					BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Menu\\Drinks.txt"));

					printtxt(rd);
					
					rd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("**********************");
				System.out.println("1-Ana Menu");
				System.out.println("2-Bir Onceki Menu");
				System.out.println("0-Cikis");
				int choose2=scan.nextInt();
				switch(choose2) {
					case 1:
						SystemMenu();
						break;
					case 2:
						Drinks drink = new Drinks();
					case 0:
						System.exit(choose2);
					default:
						System.out.println("Gecersiz Deger Girdiniz.");
				}
				break;
			case 2:
				int a;
				do {
					System.out.println("Eklemek Istediniz Icerigi Giriniz.");
					String b = scan.nextLine();
					String item = scan.nextLine();
					System.out.println("Icerigin Fiyatini Giriniz(Sadece Sayiyi Giriniz).");
					int cost= scan.nextInt();
					addItem(item, cost);
					menuLog(item+" "+cost+" TL"+ " olarak eklendi.");
					
					System.out.println("Eklemeye Devam Etmek Icin 1'e Basiniz. Cikis icin 0.");
					a = scan.nextInt();
				}while(a==1);
				
				System.out.println("**********************");
				System.out.println("1-Ana Menu");
				System.out.println("2-Bir Onceki Menu");
				System.out.println("0-Cikis");
				int choose3=scan.nextInt();
				switch(choose3) {
					case 1:
						SystemMenu();
						break;
					case 2:
						Drinks drink = new Drinks();
					case 0:
						System.exit(choose3);
					default:
						System.out.println("Gecersiz Deger Girdiniz.");
				}
				break;
			case 3:
				
				System.out.println("Silmek Istediginiz Icerigi Yaziniz(Fiyati ile Kopyalayarak Yaziniz).");
				String m = scan.nextLine();
				String item2 = scan.nextLine();
				try {
					BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Menu\\Drinks.txt"));
					deleteItem(rd, item2);
					menuLog(item2+" silindi.");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					System.out.println("**********************");
					System.out.println("1-Ana Menu");
					System.out.println("2-Bir Onceki Menu");
					System.out.println("0-Cikis");
					int choose4=scan.nextInt();
					switch(choose4) {
						case 1:
							SystemMenu();
							break;
						case 2:
							Drinks drink = new Drinks();
						case 0:
							System.exit(choose4);
						default:
							System.out.println("Gecersiz Deger Girdiniz.");
					}
					break;
			case 4:
				System.out.println("Degistirmek Istediginiz Icerigi Giriniz: ");
				String b = scan.nextLine();
				String oldItem = scan.nextLine();
				System.out.println("Yeni Icerigi Giriniz: ");
				String newItem = scan.nextLine();
				updateItem(oldItem,newItem);
				menuLog(oldItem+" "+newItem+ " olarak guncellendi.");
				
				System.out.println("**********************");
				System.out.println("1-Ana Menu");
				System.out.println("2-Bir Onceki Menu");
				System.out.println("0-Cikis");
				int choose5=scan.nextInt();
				switch(choose5) {
					case 1:
						SystemMenu();
						break;
					case 2:
						Drinks drink = new Drinks();
					case 0:
						System.exit(choose5);
					default:
						System.out.println("Gecersiz Deger Girdiniz.");
				}
				break;
			case 0:
				Menu menu = new Menu();
				break;
			default:
				System.out.println("Gecersiz Deger Girdiniz.");
		}
	}
	
	@Override
	public void addItem(String item, int cost) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Menu\\Drinks.txt"));
			String temp = readtxt(rd);
			
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Menu\\Drinks.txt"));
			wt.write(temp + item + " - " + cost + " TL");
			wt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteItem(BufferedReader rd, String item) {
		try {
			rd = new BufferedReader(new FileReader("txtFiles\\Menu\\Drinks.txt"));
			
			String oldItem = "";
			String line;
			
			line = rd.readLine();
			
			while (line != null){
				oldItem = oldItem + line + System.lineSeparator();
				line = rd.readLine();
			}
			
			String newItem = oldItem.replaceAll(item,"");
			
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Menu\\Drinks.txt"));
			
			wt.write(newItem+"");
			wt.close();
			rd.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateItem(String oldString, String newString) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Menu\\Drinks.txt"));
			
			String oldItem = "";
			String line;
			
			line = rd.readLine();
			
			while (line != null){
				oldItem = oldItem + line + System.lineSeparator();
				line = rd.readLine();
			}
			
			String newItem = oldItem.replaceAll(oldString, newString);
			
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Menu\\Drinks.txt"));
			
			wt.write(newItem);
			wt.close();
			rd.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void printtxt(BufferedReader rd) {
		String line;
		try {
			do{
				line = rd.readLine();
				if(line!=null) {
					System.out.println(line);
				}
			}while(line!=null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
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

	public void menuLog(String process) {
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Menu\\menuLog.txt"));
			String temp = readtxt(rd);
			
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Menu\\menuLog.txt"));
			getDate();
			wt.write(temp+"\n"+getDate()+" Yapilan Islem: "+process);
			
			wt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public String getDate() {
		int hour = time.getHour();
		int min = time.getMinute();
		int day = time.getDayOfMonth();
		int month = time.getMonthValue();
		int year = time.getYear();
		
		String date = day+"-"+month+"-"+year+" "+hour+":"+min;
		
		return date;
	}
}
