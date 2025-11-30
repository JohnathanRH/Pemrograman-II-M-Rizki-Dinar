package dao;

import java.util.List;

import model.Pelanggan;

public interface PelangganDao {
	void addPelanggan(Pelanggan pelanggan) throws Exception;
	void editPelanggan(Pelanggan pelanggan) throws Exception;
	void deletePelanggan(int id) throws Exception;
	List<Pelanggan> findAllPelanggan() throws Exception;
}