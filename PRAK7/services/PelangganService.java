package services;

import dao.implementation.PelangganDaoImpl;
import models.Pelanggan;

import java.util.List;

public class PelangganService {
    PelangganDaoImpl pelangganDao = new PelangganDaoImpl();

    public List<Pelanggan> getAllPelanggan() throws Exception
    {
        List<Pelanggan> pelanggans = pelangganDao.getAllPelanggan();
        if(pelanggans.isEmpty() || pelanggans == null)
        {
            throw new Exception("Pelanggan list is empty");
        }
        return pelanggans;
    }

    public void addPelanggan(Pelanggan p) throws Exception
    {
        validator(p);
        pelangganDao.addPelanggan(p);
    }

    public void deletePelanggan(int id) throws Exception
    {
        if(id <= 0) {
            throw new Exception("ID pelanggan tidak valid");
        }
        pelangganDao.deletePelanggan(id);
    }

    public void editPelanggan(Pelanggan p) throws Exception
    {
        if(p.getPelangganId() <= 0) {
            throw new Exception("ID pelanggan tidak valid");
        }
        validator(p);
        pelangganDao.editPelanggan(p);
    }

    public void validator(Pelanggan p) throws Exception
    {
        if(p.getNama().isEmpty() || p.getNama() == null)
        {
            throw new Exception("Nama Harus di isi");
        }
        if(p.getEmail().isEmpty() || p.getEmail() == null)
        {
            throw new Exception("Email Harus di isi");
        }
        if(p.getTelepon().isEmpty() || p.getTelepon() == null)
        {
            throw new Exception("Telepon Harus di isi");
        }
    }
}
