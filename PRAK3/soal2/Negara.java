package soal2;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Negara {
    private Scanner sc = new Scanner(System.in);
    protected String nama, jenis, nm_pemimpin;
    protected int tgl_merdeka, bln_merdeka, thn_merdeka;

    HashMap<Integer, Entry<String, Integer>> bulan = new HashMap<>();

    public Negara()
    {
        isi_bulan();
        input_attr();
    }

    private void isi_bulan()
    {
        bulan.put(1, Map.entry("Januari",31));
        bulan.put(2, Map.entry("Februari", 29));
        bulan.put(3, Map.entry("Maret", 31));
        bulan.put(4, Map.entry("April", 30));
        bulan.put(5, Map.entry("Mei", 31));
        bulan.put(6, Map.entry("Juni", 30));
        bulan.put(7, Map.entry("Juli", 31));
        bulan.put(8, Map.entry("Agustus", 31));
        bulan.put(9, Map.entry("September", 30));
        bulan.put(10, Map.entry("Oktober", 31));
        bulan.put(11, Map.entry("November", 30));
        bulan.put(12, Map.entry("Desember", 31));
    }

    private void input_attr()
    {
        boolean input_invalid = true;

        nama = sc.nextLine();
        jenis = sc.nextLine();
        jenis = jenis.substring(0,1).toUpperCase()+ jenis.substring(1);
        nm_pemimpin = sc.nextLine();
        // Input tanggal dan bulan + validasi nya
        while (input_invalid && !jenis.toLowerCase().equals("monarki"))
        {
            tgl_merdeka = 0;
            bln_merdeka = 0;

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

            Entry<String, Integer> bln_dipilih = bulan.get(bln_merdeka);

            if( tgl_merdeka > bln_dipilih.getValue())
            {
                System.out.println(
                    "Tanggal tidak valid untuk bulan "+bln_dipilih.getKey()+
                    " Masukan ulang tanggal dan bulan!"
                );
            }
            else {
                thn_merdeka = sc.nextInt();
                input_invalid = false;
            }
        }
//        this.sc.close();
    }

    public void print_pesan()
    {
        System.out.println("Negara "+nama+" Mempunyai "+ jenis +" bernama "+nm_pemimpin);
        if(!jenis.toLowerCase().equals("monarki"))
        {
            System.out.println(
                    "Deklarasi Kemerdekaan pada Tanggal "+
                    tgl_merdeka+" "+ bulan.get(bln_merdeka).getKey() +" "+ thn_merdeka
            );
        }
    }
}
