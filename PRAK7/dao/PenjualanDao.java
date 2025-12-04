package dao;

import models.Penjualan;

import java.util.List;

public interface PenjualanDao {
    List<Penjualan> getAllPenjualan() throws Exception;
    void addPenjualan(Penjualan penjualan) throws Exception;
    void editPenjualan(Penjualan penjualan) throws Exception;
    void deletePenjualan(int id) throws Exception;
}
