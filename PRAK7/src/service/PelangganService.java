package service;

import java.util.List;

import dao.PelangganDao;
import dao.impl.PelangganDaoImpl;
import model.Pelanggan;

public class PelangganService {
	private final PelangganDao pelangganDAO = new PelangganDaoImpl();

    public List<Pelanggan> getAllPelanggan() throws Exception {
        return pelangganDAO.findAllPelanggan();
    }
    
    public void addPelanggan(Pelanggan pelanggan) throws Exception {
        validasiData(pelanggan); 
        pelangganDAO.addPelanggan(pelanggan);
    }


    public void editPelanggan(Pelanggan pelanggan) throws Exception {
        if (pelanggan.getPelangganId() <= 0) {
            throw new Exception("Gagal Edit: Data tidak ditemukan (ID Invalid).");
        }

        validasiData(pelanggan);
        pelangganDAO.editPelanggan(pelanggan);
    }

    // --- 4. HAPUS ---
    public void deletePelanggan(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Gagal Hapus: ID tidak valid.");
        }
        pelangganDAO.deletePelanggan(id);
    }


    private void validasiData(Pelanggan p) throws Exception {
        if (p.getNama() == null || p.getNama().trim().isEmpty()) {
            throw new Exception("Nama pelanggan wajib diisi!");
        }

        if (p.getEmail() == null || p.getEmail().trim().isEmpty()) {
            throw new Exception("Email wajib diisi!");
        }
        if (!p.getEmail().contains("@")) {
            throw new Exception("Format email salah (harus ada @).");
        }

        if (p.getUmur() <= 0) {
            throw new Exception("Umur harus lebih dari 0 tahun!");
        }
        if (p.getUmur() > 150) {
            throw new Exception("Umur tidak masuk akal (max 150).");
        }
    }
}
