package praktikum2.soal1;

public class Buah {
    String nama;
    float berat;
    float harga;
    int jumlah_beli;

    public Buah(
            String nama,
            float berat,
            float harga,
            int jumlah_beli
    ) {
      this.nama = nama;
      this.berat = berat;
      this.harga = harga;
      this.jumlah_beli = jumlah_beli;
    }

    public void show_data()
    {
        double total = harga * (jumlah_beli/berat);
        double diskon = harga * ((jumlah_beli/4) * 0.02 * 4);
        double akhir = total-diskon;

        System.out.println("Nama Buah: " + this.nama);
        System.out.println("Berat: " + this.berat);
        System.out.println("Harga: " + this.harga);
        System.out.println("Jumlah Beli: " + this.jumlah_beli + "kg");
        System.out.println("Harga Sebelum Diskon: Rp" + total);
        System.out.println("Total Diskon: Rp" + diskon);
        System.out.println("Harga Setelah Diskon: Rp."+ akhir +"\n");

    }

}
