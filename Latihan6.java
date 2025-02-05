import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Latihan6 {
  public static void main(String[] args) throws IOException {
    String nama;
    int umur;

    // Membuat objek inputstream
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    // Mengisi variabel nama dengan BufferedReader
    System.out.print("Inputkan nama Anda : ");
    nama = br.readLine();

    // Mengisi variabel umur dengan BufferedReader
    System.out.print("Inputkan umur Anda : ");
    umur = Integer.parseInt(br.readLine());  // Convert input to integer

    // Tampilkan output isi variabel nama dan umur
    System.out.println("Nama Anda adalah " + nama);
    System.out.println("Umur Anda adalah " + umur);
  }
}
