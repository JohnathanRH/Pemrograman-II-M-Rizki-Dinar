package services;

import dao.PenjualanDao;
import dao.implementation.PenjualanDaoImpl;
import models.Penjualan;

import java.util.List;

public class PenjualanService {
    PenjualanDaoImpl penjualanDao = new PenjualanDaoImpl();

    public List<Penjualan> getAllPenjualan() throws Exception
    {
        return penjualanDao.getAllPenjualan();
    }

    public void addPenjualan(Penjualan penjualan) throws Exception
    {
        penjualanDao.addPenjualan(penjualan);
    }

    public void editPenjualan(Penjualan penjualan) throws Exception
    {
        penjualanDao.editPenjualan(penjualan);
    }

    public void deletePenjualan(int id) throws Exception
    {
        penjualanDao.deletePenjualan(id);
    }
}
