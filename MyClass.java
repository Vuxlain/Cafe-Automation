import java.util.Scanner;

public class MyClass {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		SystemMenu();
		
	}
	public static void SystemMenu() {
		
		
		System.out.println("                  Kafe Otomasyon Sistemine Hosgeldiniz. Yapmak Istediginiz Islemi Seciniz.");
		System.out.println("1-Menu Bilgileri.");
		System.out.println("2-Personel Bilgileri.");
		System.out.println("3-Musteri Bilgileri.");
		System.out.println("4-Kasa Bilgileri.");
		System.out.println("0-Cikis.");
		int choose = scan.nextInt();
		
		switch(choose) {
			case 1:
				//Menu
				Menu menu = new Menu();
				
				break;
			case 2:
				//Personel
				Staff staff = new Staff();
				
				break;
			case 3:
				//Musteri
				Customer customer = new Customer();
				
				break;
			case 4:
				//Kasa
				CashBox cashbox = new CashBox();
				
				break;
			case 0:
				System.out.println("Programdan Cikiliyor.");
				System.exit(choose);
				break;
			default:
				System.out.println("Gecersiz Deger Girdiniz.");
		}

		scan.close();
	}

}
