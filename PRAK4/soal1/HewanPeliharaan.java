package soal1;

public class HewanPeliharaan {
    private String nama, ras;
    public HewanPeliharaan(String nama, String ras)
    {
        this.nama = nama;
        this.ras = ras;
    }

    public void display()
    {
        System.out.println(
                "Detail Hewan Peliharaan:"+
                "\nNama hewan peliharaanku adalah : "+ nama +
                "\nDengan ras : " + ras
        );
    }

}
