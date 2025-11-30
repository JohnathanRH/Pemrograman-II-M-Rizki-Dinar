package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pelanggan {
	private int pelangganId;
    private StringProperty nama;
    private StringProperty email;
    private IntegerProperty umur;
    
    
    //konstruktor untuk add
    public Pelanggan(String nama, String email, int umur) {
        this.pelangganId = 0; 
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.umur = new SimpleIntegerProperty(umur);
    }
    
    //konstruktor untuk read
    public Pelanggan(int id, String nama, String email, int umur) {
    	this.pelangganId = id;
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.umur = new SimpleIntegerProperty(umur);
    }

    
    public StringProperty namaProperty() {
        return nama;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public IntegerProperty umurProperty() {
        return umur;
    }

    public int getUmur() {
        return umur.get();
    }

    public void setUmur(int umur) {
        this.umur.set(umur);
    }
    

    public int getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(int id) {
        this.pelangganId = id;
    }
}
