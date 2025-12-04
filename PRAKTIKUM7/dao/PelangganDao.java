package dao;

import javafx.collections.ObservableList;
import models.Pelanggan;

import java.util.List;

public interface PelangganDao {
    void addPelanggan(Pelanggan p) throws Exception;
    List<Pelanggan> getAllPelanggan() throws Exception;
    void deletePelanggan(int id) throws Exception;
    void editPelanggan(Pelanggan p) throws Exception;
}
