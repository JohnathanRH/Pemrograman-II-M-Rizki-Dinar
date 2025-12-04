package dao.implementation;

import dao.PenjualanDao;
import models.Buku;
import models.Pelanggan;
import models.Penjualan;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDaoImpl implements PenjualanDao {
    public List<Penjualan> getAllPenjualan() throws Exception
    {
        String sql = "SELECT * FROM penjualan NATURAL JOIN pelanggan NATURAL JOIN buku";
        try(
            Connection db = Database.connect();
            Statement stment = db.createStatement();
        ){
            ResultSet rs = stment.executeQuery(sql);
            List<Penjualan> penjualans = new ArrayList<>();
            while(rs.next())
            {
                Pelanggan pelanggan = new Pelanggan(
                        rs.getInt("pelanggan_id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("telepon")
                );

                Buku buku = new Buku(
                        rs.getInt("buku_id"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getFloat("harga"),
                        rs.getInt("stok")
                );

                Penjualan penjualan = new Penjualan(
                        rs.getInt("penjualan_id"),
                        rs.getInt("jumlah"),
                        rs.getFloat("total_harga"),
                        rs.getDate("tanggal"),
                        pelanggan,
                        buku
                );
                penjualans.add(penjualan);
            }
            return penjualans;
        }
    }

    public void addPenjualan(Penjualan penjualan) throws Exception
    {
        String sql = "INSERT INTO penjualan VALUES(0, ?, ?, ?, ?, ?)";
        try(
            Connection db = Database.connect();
            PreparedStatement prepStment = db.prepareStatement(sql);
        ) {
            prepStment.setInt(1, penjualan.getJumlah());
            prepStment.setFloat(2, penjualan.getTotalHarga());
            prepStment.setDate(3, penjualan.getTanggal());
            prepStment.setInt(4, penjualan.getPelanggan().getPelangganId());
            prepStment.setInt(5, penjualan.getBuku().getBukuId());
            prepStment.execute();
        }
    }

    public void editPenjualan(Penjualan penjualan) throws Exception
    {
        String sql = "UPDATE penjualan SET jumlah = ?, total_harga = ?, tanggal = ?, pelanggan_id = ?, buku_id = ? WHERE penjualan_id = ?";
        try(
            Connection db = Database.connect();
            PreparedStatement prepStment = db.prepareStatement(sql);
        ){
            prepStment.setInt(1, penjualan.getJumlah());
            prepStment.setFloat(2, penjualan.getTotalHarga());
            prepStment.setDate(3, penjualan.getTanggal());
            prepStment.setInt(4, penjualan.getPelanggan().getPelangganId());
            prepStment.setInt(5, penjualan.getBuku().getBukuId());
            prepStment.setInt(6, penjualan.getPenjualanId());
            prepStment.execute();
        }
    }

    public void deletePenjualan(int id) throws Exception
    {
        String sql = "DELETE FROM penjualan WHERE penjualan_id = ?";
        try(
            Connection db = Database.connect();
            PreparedStatement prepStment = db.prepareStatement(sql);
        ){
          prepStment.setInt(1, id);
          prepStment.execute();
        }
    }
}
