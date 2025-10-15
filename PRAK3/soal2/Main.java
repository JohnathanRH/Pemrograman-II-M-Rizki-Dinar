package soal2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        LinkedList<Negara> ls_negara = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int brp_kali = sc.nextInt();

        for (int i = 0; i < brp_kali; i++) {
            Negara negara = new Negara();
            ls_negara.add(negara);
        }

        ls_negara.forEach(ngr -> {
            ngr.print_pesan();
            System.out.println();
        });

    }
}
