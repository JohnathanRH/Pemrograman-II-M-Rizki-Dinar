package soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);

        System.out.print("Nama Hewan Peliharaan: ");
        String nama = inp.nextLine();
        System.out.print("Ras: ");
        String ras = inp.nextLine();

        HewanPeliharaan hp = new HewanPeliharaan(nama,ras);
        hp.display();
    }
}
