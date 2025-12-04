package models;

import javafx.beans.property.*;

import java.sql.Date;

public class Penjualan {
    private Buku buku;
    private Pelanggan pelanggan;
    private int penjualanId;
    private IntegerProperty jumlah;
    private FloatProperty totalHarga;
    private Date tanggal;

    public Penjualan(int jumlah, float totalHarga, Date tanggal, Buku buku, Pelanggan pelanggan)
    {
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleFloatProperty(totalHarga);
        this.tanggal = tanggal;
        this.buku = buku;
        this.pelanggan = pelanggan;
    }

    public Penjualan(int id, int jumlah, float totalHarga, Date tanggal)
    {
        penjualanId = id;
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleFloatProperty(totalHarga);
        this.tanggal = tanggal;
    }

    public Penjualan(int id, int jumlah, float totalHarga, Date tanggal, Pelanggan p, Buku buku)
    {
        penjualanId = id;
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleFloatProperty(totalHarga);
        this.tanggal = tanggal;
        pelanggan = p;
        this.buku = buku;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public int getPenjualanId() {
        return penjualanId;
    }

    public void setPenjualanId(int penjualanId) {
        this.penjualanId = penjualanId;
    }

    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int jumlah) {
        this.jumlah.set(jumlah);
    }

    public float getTotalHarga() {
        return totalHarga.get();
    }

    public void setTotalHarga(float totalHarga) {
        this.totalHarga.set(totalHarga);
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
