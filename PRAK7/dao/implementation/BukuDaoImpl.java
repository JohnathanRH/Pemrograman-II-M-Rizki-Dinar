package dao.implementation;

import dao.BukuDao;
import models.Buku;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BukuDaoImpl implements BukuDao {
    public List<Buku> getAllBuku() throws Exception
    {
        try(
            Connection db = Database.connect();
            Statement stment = db.createStatement();
        ){
            String sql = "SELECT * FROM buku";
            List<Buku> bukus = new ArrayList<>();


            ResultSet results = stment.executeQuery(sql);

            while(results.next())
            {
                Buku buku = new Buku(
                        results.getInt("buku_id"),
                        results.getString("judul"),
                        results.getString("penulis"),
                        results.getFloat("harga"),
                        results.getInt("stok")
                );
                bukus.add(buku);
            }
            return bukus;
        }
    }

    public void addBuku(Buku buku) throws Exception
    {
        String sql = "INSERT INTO buku VALUES(0, ?, ?, ?, ?)";
        try(
            Connection db = Database.connect();
            PreparedStatement prepStment = db.prepareStatement(sql);
        ){
            prepStment.setString(1, buku.getJudul());
            prepStment.setString(2, buku.getPenulis());
            prepStment.setFloat(3, buku.getHarga());
            prepStment.setInt(4, buku.getStok());
            prepStment.execute();
        }
    }

    public void editBuku(Buku buku) throws Exception
    {
        String sql = "UPDATE buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
        try(
            Connection db = Database.connect();
            PreparedStatement prepStment = db.prepareStatement(sql);
        ){
            prepStment.setString(1, buku.getJudul());
            prepStment.setString(2, buku.getPenulis());
            prepStment.setFloat(3, buku.getHarga());
            prepStment.setInt(4, buku.getStok());
            prepStment.setInt(5, buku.getBukuId());
            prepStment.execute();
        }
    }

    public void deleteBuku(int id) throws Exception
    {
        String sql = "DELETE FROM buku WHERE buku_id = ?";
        try(
            Connection db = Database.connect();
        ){
            PreparedStatement prepStment = db.prepareStatement(sql);
            prepStment.setInt(1, id);
            prepStment.execute();
        }
    }
}
