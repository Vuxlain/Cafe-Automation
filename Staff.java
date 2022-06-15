import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Staff extends MyClass{
	
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	LocalDateTime time =java.time.LocalDateTime.now();
	MyLinkedList list = new MyLinkedList();
	
	public Staff() {
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Staff\\recruit.txt"));
			createList(rd);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1-Yeni Personel Kayit.");
		System.out.println("2-Isten Personel Cikarma.");
		System.out.println("3-Gunluk Giris Cikis. ");
		System.out.println("4-Personel Odemeleri.");
		System.out.println("5-Haftalik Mesai Çizelgesi.");
		System.out.println("6-Kayitli Elemanlari Gorme");
		System.out.println("7-Personel Kayit Listesi");
		System.out.println("0-Cikis");
		int choose = scan.nextInt();
		switch(choose) {
		case 1:
			System.out.println("Yeni Personelin Adi: ");
			String a = scan.nextLine();
			String name = scan.nextLine();
			System.out.println("Soyadi: ");
			String lastName = scan.nextLine();
			recruit(name, lastName);
			staffLog(name + lastName + " isimli yeni personel sisteme kayit edildi.");
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
					Staff staff = new Staff();
				case 0:
					System.exit(choose2);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 2:
			System.out.println("Cikarilacak Personelin Adi:");
			a = scan.nextLine();
			name = scan.nextLine();
			System.out.println("Cikarilacak Personelin Soyadi:");
			lastName = scan.nextLine();
			System.out.println("Cikarilacak Personelin ID'si:");
			int id = scan.nextInt();
			dismissal(name,lastName,id);
			staffLog(name + lastName + " isimli personel sistemden cikarildi.");
			
			
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
					Staff staff = new Staff();
				case 0:
					System.exit(choose3);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 3:
			list.printList();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			BufferedReader rd;
			try {
				rd = new BufferedReader(new FileReader("txtFiles\\Staff\\recruit.txt"));
				printtxt(rd);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("**********************");
			System.out.println("1-Ana Menu");
			System.out.println("2-Bir Onceki Menu");
			System.out.println("0-Cikis");
			int choose6=scan.nextInt();
			switch(choose6) {
				case 1:
					SystemMenu();
					break;
				case 2:
					Staff staff = new Staff();
				case 0:
					System.exit(choose6);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 7:
			
			try {
				BufferedReader rd2 = new BufferedReader(new FileReader("txtFiles\\Staff\\staffLog.txt"));
				readtxt(rd2);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 0:
			System.exit(choose);
			
			break;
		default:	
		
		}
		
	}
	
	public void daily(String name, String lastName) {
		System.out.println("Giren Personel Adi");	

		
		
		
		
		
	}
	
	//Ise Alma
	public void recruit(String name, String lastName) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Staff\\recruit.txt"));
			String a=rd.readLine();
			int count = 0;
			while(a!=null) {
				count++;
				a=rd.readLine();
			}
			int id=count+10;
			
			BufferedReader rd2 = new BufferedReader(new FileReader("txtFiles\\Staff\\recruit.txt"));
			String temp = readtxt(rd2);
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Staff\\recruit.txt"));
			wt.write(temp+name+" "+lastName+" - "+id);
			list.addLast(name+" "+lastName+" - "+id);
			
			rd.close();
			wt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Isten Cikarma
	public void dismissal(String name, String lastName,int id) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Staff\\recruit.txt"));
			String oldItem = "";
			String line;
			int count = 0;
			line = rd.readLine();
			
			while (line != null){
				count++;
				oldItem = oldItem + line + System.lineSeparator();
				line = rd.readLine();
			}
			String newItem = oldItem.replaceAll(name+" "+lastName+" - "+id,"\b");
			list.deleteIn(count);
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Staff\\recruit.txt"));
			wt.write(newItem);
			rd.close();
			wt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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
	
	public void createList(BufferedReader rd) {
		String line;
		int count=0;
		try {
			line = rd.readLine();
			while(line!=null){
				list.addIn(line, count);					
				count++;
				line = rd.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void staffLog(String process) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Staff\\staffLog.txt"));
			String temp = readtxt(rd);
			
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Staff\\staffLog.txt"));
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
