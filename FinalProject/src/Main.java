import java.util.Scanner;

public class Main {
	
	static Storage data[] = new Storage[1000];
	static Scanner sc = new Scanner(System.in);
	static int idx = 0;
	
	static void init() {
		for(int i=0;i<1000;i++) {
			data[i] = new Storage();
		}
	}
	
	static void insert() {
		String n;
		do {
			boolean cek = false;
			do {
				System.out.print("Kode Menu: ");
				data[idx].kode = sc.next();
				if(data[idx].kode.startsWith("BC-")) {
					cek = true;
				}
			}while(!cek);
			System.out.print("Name Menu: ");
			sc.nextLine();
			data[idx].nama = sc.nextLine();
			System.out.print("Harga Menu: ");
			data[idx].harga = sc.nextInt();
			System.out.print("Stok Menu: ");
			data[idx].stock = sc.nextInt();
			idx++;
			n = sc.nextLine();
		}while(n.length()<0);
	}
	
	static void view() {
		if(idx>0) {
			for(int i=0;i<idx;i++) {
				System.out.printf("| %-20s | %-20s | %-10d | %-5d |\n", data[i].kode,data[i].nama,data[i].harga,data[i].stock);
			}
		}
		else {
			System.out.println("No Data!");
		}	
		sc.nextLine();
	}
	
	static int checknama(String nama) {
		if(idx<=0) {
			return -1; // kasih tau klo dia false (gaada)
		}
		else {
			for(int i=0;i<idx;i++) {
				if(nama.equals(data[i].nama)) {
					return i;
				}
			}
			return -1;
		}
	}
	
	static void update() {
		boolean cek = false;
		String name;
		int harga, stok;
		sc.nextLine();
		do {
			System.out.print("Nama minuman yang ingin diubah: ");
			name = sc.nextLine();
			if(checknama(name)!=-1) {
				cek = true;
			}
		}while(!cek);	
		// harga stok
		System.out.print("Harga baru: ");
		harga = sc.nextInt();
		System.out.print("Stok baru: ");
		stok = sc.nextInt();
		data[checknama(name)].harga = harga;
		data[checknama(name)].stock = stok;
		System.out.println("Press any key to continue...");
		sc.nextLine(); //getchar
	}
	
	static void delete() {
		boolean cek = false;
		String name;
		sc.nextLine();
		do {
			System.out.print("Nama minuman yang ingin dihapus: ");
			name = sc.nextLine();
			if(checknama(name)!=-1) {
				cek = true;
			}
		}while(!cek);
		for(int i=checknama(name);i<idx-1;i++) {
			data[i] = data[i+1];
		}
		idx--;
	}
	
	static void menu() {
		int option;
		do {
			System.out.println("============");
			System.out.println("| BobaCool |");
			System.out.println("============");
			System.out.println();
			System.out.println("1. Insert");
			System.out.println("2. View");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.print(">> ");
			option = sc.nextInt();
			if(option==1) {
				insert();
			}
			else if(option==2) {
				view();
			}
			else if(option==3) {
				update();		
			}
			else if(option==4) {
				delete();
			}
		}while(option!=5);
	}

	public static void main(String[] args) {
		init();
		menu();
	}

}
