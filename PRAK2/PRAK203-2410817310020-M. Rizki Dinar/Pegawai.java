package praktikum2.soal3;

// Nama class salah, seharus nya 'Pegawai'
//public class Employee {
public class Pegawai {
    public String nama;
    // Variabel 'asal' harunya menggunakan tipe data String
    // public char asal;
    public String asal;
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    // Parameter J tidak ditulis.
    //public void setJabatan() {
    public void setJabatan(String j){
        this.jabatan = j;
    }
}
