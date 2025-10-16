package soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<Negara> ls_negara = new LinkedList();
        int brp_kali = sc.nextInt();

        for (int i = 0; i < brp_kali; i++) {
            Negara ngr;

            HashMap<String, String> data_ngr = InputGroups.InputDataNegara();

            if(!data_ngr.get("jenis").equals("monarki")) {
                HashMap<String, Integer> data_tgl = InputGroups.InputTglNegara();
                ngr = new Negara(
                    data_ngr.get("nama"),
                    data_ngr.get("jenis"),
                    data_ngr.get("nm_pemimpin"),
                    data_tgl.get("tgl_merdeka"),
                    data_tgl.get("bln_merdeka"),
                    data_tgl.get("thn_merdeka")
                );
            }
            else {
                ngr = new Negara(
                    data_ngr.get("nama"),
                    data_ngr.get("jenis"),
                    data_ngr.get("nm_pemimpin")
                );
            }

            ls_negara.add(ngr);
        }

        ls_negara.forEach(ngr -> {
            ngr.print_info();
            System.out.println();
        });

    }
}
