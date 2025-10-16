package soal2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputGroups {
    private static final Scanner sc = new Scanner(System.in);
    public static HashMap<String, String> InputDataNegara()
    {
        HashMap<String, String> data = new HashMap<>();
        String jenis, nm_pemimpin;

        String nama = sc.nextLine();
        jenis = sc.nextLine();
        nm_pemimpin = sc.nextLine();

        data.put("nama", nama);
        data.put("jenis", jenis);
        data.put("nm_pemimpin", nm_pemimpin);
        return data;
    }

    public static HashMap<String, Integer> InputTglNegara()
    {
        HashMap<String, Integer> data = new HashMap<>();
        int tgl_merdeka = 0, bln_merdeka = 0, thn_merdeka = 0;

        boolean tgl_invalid = true;
        while(tgl_invalid)
        {
            while(tgl_merdeka <= 0 || tgl_merdeka > 31)
            {
                tgl_merdeka = sc.nextInt();
                if(tgl_merdeka <= 0 || tgl_merdeka > 31){
                    System.out.println("Tanggal Tidak boleh <= 0 atau > 31");
                }
            }

            while(bln_merdeka <= 0 || bln_merdeka > 12)
            {
                bln_merdeka = sc.nextInt();
                if(bln_merdeka <= 0 || bln_merdeka > 12){
                    System.out.println("Bulan Tidak boleh <= 0 atau > 12");
                }
            }

            Map.Entry<String, Integer> bln_dipilih = Kalender.getBulan(bln_merdeka);

            if( tgl_merdeka > bln_dipilih.getValue())
            {
                System.out.println(
                        "Tanggal tidak valid untuk bulan "+bln_dipilih.getKey()+
                                " Masukan ulang tanggal dan bulan!"
                );
            }
            else {
                tgl_invalid = false;
            }
        }

        thn_merdeka = sc.nextInt();

        data.put("tgl_merdeka", tgl_merdeka);
        data.put("bln_merdeka", bln_merdeka);
        data.put("thn_merdeka", thn_merdeka);
        sc.nextLine();
        return data;
    }

}
