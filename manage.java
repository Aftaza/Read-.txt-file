import java.io.*;
import java.util.*;
import java.lang.*;

public class manage {

	public static Scanner in = new Scanner(System.in);
	public static String records[];

	public static void choose(int id){
		System.out.println("[1] Dapatkan data barang dengan id");
		System.out.println("[2] Dapatkan nama barang dengan id");
		System.out.println("[3] Dapatkan harga barang dengan id");
		System.out.println("Silahkan pilih metode yang ingin digunakan : ");
		int method = in.nextInt();
		switch(method){
		case 1:
			System.out.println(getBarangbyId(id));
			break;
		case 2:
			System.out.println(getNamaBarangbyId(id));
			break;
		case 3:
			System.out.println(getHargaBarangbyId(id));
			break;
		default:
			System.out.print("Maaf input yang anda pilih tidak sesuai!");
			System.exit(0);
		}
	}
	
	
	public static void store() throws IOException{
		List<String> tempStrings = new ArrayList<String>(); //make temporary array
		BufferedReader read = new BufferedReader(new FileReader("data.txt")); //read data from .txt file
		String line = read.readLine(); //make temporary var

		while(line != null){ //selama line dalam text tidak null
			tempStrings.add(line); //menambahkan ke temporary array
			line = read.readLine(); //mengambil data nextline
		}
		read.close();
		records = tempStrings.toArray(new String[0]);
	}

	public static String getBarangbyId(int id){
		String temp = "null";
		for ( String str : records) {
			String data[] = str.split("/");
			if (Integer.parseInt(data[0]) == id) {
				temp = str;
				break;
			}
		}
		return temp;
	}

	public static String getNamaBarangbyId(int id){
		String temp = "null";
		for ( String str : records) {
			String data[] = str.split("/");
			if (Integer.parseInt(data[0]) == id) {
				temp = data[1];
				break;
			}
		}
		return temp;
	}

	public static String getHargaBarangbyId(int id){
		String temp = "null";
		for ( String str : records) {
			String data[] = str.split("/");
			if (Integer.parseInt(data[0]) == id) {
				temp = data[2];
				break;
			}
		}
		return temp;
	}

	public static void main(String[] args) throws IOException{
		// put data from txt
		store();
		// print the data
		for ( String barang : records ) {
			System.out.println("\t\t" + barang);
		}
		while(true){
			System.out.print("Silahkan Masukkan id : ");
			int id = in.nextInt();
			choose(id);
		}
		
		
	}
	
}