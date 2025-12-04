package services;

import dao.implementation.BukuDaoImpl;
import models.Buku;

import java.util.List;

public class BukuService {
    BukuDaoImpl dao = new BukuDaoImpl();
    public List<Buku> getAllBuku() throws Exception
    {
        List<Buku> bukus = dao.getAllBuku();
        if(bukus.isEmpty() || bukus == null)
        {
            throw new Exception("Tabel buku kosong");
        }
        return bukus;
    }

    public void addBuku(Buku buku) throws Exception
    {
        validator(buku);
        dao.addBuku(buku);
    }

    public void deleteBuku(int id) throws Exception
    {
        if(id <= 0){
            throw new Exception("ID Buku tidak valid");
        }
        dao.deleteBuku(id);
    }

    public void editBuku(Buku buku) throws Exception
    {
        if(buku.getBukuId() <= 0){
            throw new Exception("ID Buku tidak valid");
        }
        validator(buku);
        dao.editBuku(buku);
    }

    public void validator(Buku b) throws Exception
    {
        if(b.getJudul().isEmpty() || b.getJudul() == null){
            throw new Exception("Judul Buku harus di isi");
        }
        if(b.getPenulis().isEmpty() || b.getPenulis() == null){
            throw new Exception("Penulis Buku harus di isi");
        }
        if(b.getHarga() <= 0){
            throw new Exception("Harga Buku tidak boleh gratis");
        }
        if(b.getStok() < 0) {
            throw new Exception("Stok buku tidak boleh minus");
        }
    }
}
