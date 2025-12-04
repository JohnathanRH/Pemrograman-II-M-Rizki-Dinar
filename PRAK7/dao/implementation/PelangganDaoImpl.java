package dao.implementation;

import dao.PelangganDao;
import javafx.collections.ObservableList;
import models.Pelanggan;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PelangganDaoImpl implements PelangganDao {

    public void addPelanggan(Pelanggan p) throws Exception
    {
        String sql = "INSERT INTO pelanggan VALUES (0,?,?,?)";
        try (
            Connection db = Database.connect();
            PreparedStatement ps = db.prepareStatement(sql);
        ){
            ps.setString(1, p.getNama());
            ps.setString(2,p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.executeUpdate();
        }
    }

    public void deletePelanggan(int id) throws Exception
    {
        String sql = "DELETE FROM pelanggan WHERE pelanggan_id = ?";
        try(
            Connection db = Database.connect();
            PreparedStatement ps = db.prepareStatement(sql);
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void editPelanggan(Pelanggan p) throws Exception
    {
        String sql = "UPDATE pelanggan SET nama = ?, email = ?, telepon = ? WHERE pelanggan_id = ?";
        try (
            Connection db = Database.connect();
            PreparedStatement ps = db.prepareStatement(sql);
        ){
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.setInt(4, p.getPelangganId());
            ps.executeUpdate();
        }
    }

    public List<Pelanggan> getAllPelanggan() throws Exception
    {
        String sql = "SELECT * FROM pelanggan";
        List<Pelanggan> pelanggans = new ArrayList<>();

        try(
            Connection db = Database.connect();
            Statement st = db.createStatement();
        ){
            ResultSet results = st.executeQuery(sql);
            while(results.next())
            {
                Pelanggan p = new Pelanggan(
                    results.getInt("pelanggan_id"),
                    results.getString("nama"),
                    results.getString("email"),
                    results.getString("telepon")
                );
                pelanggans.add(p);
            }
        }

        return pelanggans;
    }
}
