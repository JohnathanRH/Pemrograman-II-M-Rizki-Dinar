package praktikum2.soal2;

public class Kopi {
    String namaKopi;
    String ukuran;
    float harga;
    private float pajak;
    private String pembeli;

    public void info()
    {
        System.out.println("Nama Kopi: " + namaKopi);
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Harga: Rp." + harga);
    }

    public void setPembeli(String pembeli)
    {
        this.pembeli = pembeli;
    }

    public String getPembeli()
    {
        return pembeli;
    }

    public float getPajak() {
        this.pajak = this.harga*0.11f;
        return pajak;
    }
}
