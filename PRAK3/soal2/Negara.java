package soal2;
import java.util.Scanner;

public class Negara {
    private Scanner sc = new Scanner(System.in);
    protected String nama, jenis, nm_pemimpin;
    protected int tgl_merdeka, bln_merdeka, thn_merdeka;

    public Negara(String nama, String jenis, String nm_pemimpin)
    {
        this.nama = nama;
        this.jenis = jenis;
        this.nm_pemimpin = nm_pemimpin;
    }

    public Negara(
        String nama,
        String jenis,
        String nm_pemimpin,
        int tgl_merdeka,
        int bln_merdeka,
        int thn_merdeka
    ) {
      this.nama = nama;
      this.jenis = jenis;
      this.nm_pemimpin = nm_pemimpin;
      this.tgl_merdeka = tgl_merdeka;
      this.bln_merdeka = bln_merdeka;
      this.thn_merdeka = thn_merdeka;
    }

    public void print_info()
    {
        System.out.println(
            "Negara "+nama+
            " Mempunyai "+capitalizeJenis()
            +" bernama "+nm_pemimpin
        );

        if(!isMonarki())
        {
            System.out.println(
                "Deklarasi Kemerdekaan pada Tanggal "
                + tgl_merdeka +
                " "+ Kalender.getBulan(bln_merdeka).getKey() +
                " "+ thn_merdeka
            );
        }
    }

    public boolean isMonarki()
    {
        return jenis.toLowerCase().equals("monarki");
    }

    private String capitalizeJenis() {
        return jenis.substring(0,1).toUpperCase()+ jenis.substring(1);
    }
}
