package dao;

import models.Buku;

import java.util.List;

public interface BukuDao {
    List<Buku> getAllBuku() throws Exception;
    void addBuku(Buku buku) throws Exception;
    void deleteBuku(int id) throws Exception;
    void editBuku(Buku buku) throws Exception;
}
