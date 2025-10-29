package soal2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);

        System.out.print(
                "Pilih jenis hewan yang ingin diinputkan:\n" +
                "1 = Kucing\n" +
                "2 = Anjing\n" +
                "Masukan pilihan: "
        );
        int pilihan = inp.nextInt();
        inp.nextLine();

        String nama, ras;
        switch (pilihan)
        {
            case 1:
                String warnaBulu;

                System.out.print("Nama hewan peliharaan : ");
                nama = inp.nextLine();

                System.out.print("Ras : ");
                ras = inp.nextLine();

                System.out.print("Warna Bulu : ");
                warnaBulu = inp.nextLine();

                Kucing k = new Kucing(nama, ras, warnaBulu);
                k.displayDetailKucing();
                break;

            case 2:
                List<String> kemampuan;

                System.out.print("Nama hewan peliharaan : ");
                nama = inp.nextLine();

                System.out.print("Ras: ");
                ras = inp.nextLine();

                System.out.print("Warna Bulu : ");
                warnaBulu = inp.nextLine();

                System.out.print("Kemampuan : ");
                String[] kmp = inp.nextLine().split(", ");
                kemampuan = Arrays.asList(kmp);

                Anjing anj = new Anjing(nama, ras, warnaBulu, kemampuan);
                anj.displayDetailAnjing();

                break;
        }
    }
}
