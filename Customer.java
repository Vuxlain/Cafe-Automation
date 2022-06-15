import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Customer extends MyClass{
	
	Scanner scan = new Scanner(System.in);
	LocalDateTime time =java.time.LocalDateTime.now();

	public Customer() {
		
		System.out.println("1-Siparis Olustur.");
		System.out.println("2-Siparis Bak.");
		System.out.println("3-Guncel Siparisleri Listele.");
		System.out.println("4-Siparis Silme.");
		System.out.println("5-Siparis Kayit Listesi.");
		System.out.println("0-Cikis");
		int choose = scan.nextInt();
		
		switch(choose) {
		case 1:
			System.out.println("Masa Numarasini Giriniz.");
			int num = scan.nextInt();
			
			createOrder(num);
			
			
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
					Customer cm = new Customer();
				case 0:
					System.exit(choose3);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 2:
			System.out.println("Masa Numarasini Giriniz.");
			int num2 = scan.nextInt();
			
			seeOrder(num2);
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
					Customer cm = new Customer();
				case 0:
					System.exit(choose2);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 3:
			/*Queue qu = new Queue();
			setQueue(qu);
			getQueue(qu);*/
			
			System.out.println("Toplam Masa Adedini Giriniz: ");
			int sumTable = scan.nextInt();
			listOrders(sumTable);
			
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
					Customer cm = new Customer();
				case 0:
					System.exit(choose6);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 4:
			System.out.println("Masa Numarasini Giriniz.");
			int num3 = scan.nextInt();
			
			System.out.println("Siparis Odendi Mi?(true/false)");
			boolean tf = scan.nextBoolean();
			
			deleteOrder(num3,tf);
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
					Customer cm = new Customer();
				case 0:
					System.exit(choose4);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 5:
			try {
				BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Customer\\customerLog.txt"));
				String temp = readtxt(rd);
			
				System.out.println(temp);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("**********************");
			System.out.println("1-Ana Menu");
			System.out.println("2-Bir Onceki Menu");
			System.out.println("0-Cikis");
			int choose1=scan.nextInt();
			switch(choose1) {
				case 1:
					SystemMenu();
					break;
				case 2:
					Customer cm = new Customer();
				case 0:
					System.exit(choose1);
				default:
					System.out.println("Gecersiz Deger Girdiniz.");
			}
			break;
		case 0:
			System.exit(choose);
			break;
		default:
			System.out.println("Gecersiz Deger Girdiniz.");
		}
		
	}
	
	public void createOrder(int tableNum) {
		Table table = new Table(tableNum, 0);
		int m=1; 
		String log="";
		
		do {
			System.out.println("Siparisi Ekleyiniz.");	
			String a = scan.nextLine();
			String temp = scan.nextLine();
			log += temp + " - ";
			table.createOrder(temp);
			System.out.println("Eklemeye Devam Etmek Icin 1'e Basiniz. Bitirmek icin 0.");
			m = scan.nextInt();
		}while(m==1);
		
		customerLog(tableNum+ " Numarali Masanin Siparisi: " +log );
		 		
	}
	
	public void seeOrder(int tableNum) {
		Table table = new Table(tableNum, 0);
	    table.seeOrder();
	}
	
	public void deleteOrder(int tableNum, boolean tf) {
		Table table = new Table(tableNum, 0);
		int a=table.deleteOrder(tf);
		if(a==1) {
			customerLog(tableNum+ " Numarali Masanin Siparisi Odendi ve Silindi.");
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
	
	public void listOrders(int sumTable) {
		for(int i=1;i<=sumTable;i++) {
			seeOrder(i);
			System.out.println("   *************");
		}
		
	}
	
	public void customerLog(String process) {
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Customer\\customerLog.txt"));
			String temp = readtxt(rd);
			
			BufferedWriter wt = new BufferedWriter(new FileWriter("txtFiles\\Customer\\customerLog.txt"));
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
	
	public void setQueue(Queue qu) {//ekleme
		try {
			int num = 1;
			while(num<=20) {
				BufferedReader rd = new BufferedReader(new FileReader("txtFiles\\Customer\\Tables\\table"+num+".txt"));
				String temp = readtxt(rd);
				qu.pushItem(temp);
				
				num++;
				rd.close();
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getQueue(Queue qu) {
		//silme
		qu.my.printList();
	}
	
}
