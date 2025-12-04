package models;

import javafx.beans.property.*;

public class Buku {
    private int bukuId;
    private StringProperty judul;
    private StringProperty penulis;
    private FloatProperty harga;
    private IntegerProperty stok;

    public Buku(int id, String judul, String penulis, float harga, int stok)
    {
        bukuId = id;
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleFloatProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public Buku(String judul, String penulis, float harga, int stok)
    {
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleFloatProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public int getBukuId() {
        return bukuId;
    }

    public void setBukuId(int bukuId) {
        this.bukuId = bukuId;
    }

    public String getJudul() {
        return judul.get();
    }

    public void setJudul(String judul) {
        this.judul.set(judul);
    }

    public String getPenulis() {
        return penulis.get();
    }

    public void setPenulis(String penulis) {
        this.penulis.set(penulis);
    }

    public float getHarga() {
        return harga.get();
    }

    public void setHarga(float harga) {
        this.harga.set(harga);
    }

    public int getStok() {
        return stok.get();
    }

    public void setStok(int stok) {
        this.stok.set(stok);
    }
}
