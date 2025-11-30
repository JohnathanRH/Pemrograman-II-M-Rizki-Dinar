package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PelangganDao;
import model.Pelanggan;
import util.DatabaseHelper;

public class PelangganDaoImpl implements PelangganDao {

	@Override
	public void addPelanggan(Pelanggan pelanggan) throws Exception {
		String sql = "INSERT INTO pelanggan (nama, email, umur) VALUES (?, ?, ?)";
	    
	    try (Connection conn = DatabaseHelper.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, pelanggan.getNama());
	        ps.setString(2, pelanggan.getEmail());
	        ps.setInt(3, pelanggan.getUmur());

	        
	        ps.executeUpdate();
	    }
	}

	@Override
	public void editPelanggan(Pelanggan pelanggan) throws Exception {
		String sql = "UPDATE pelanggan SET nama=?, email=?, umur=? WHERE id=?";
        
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, pelanggan.getNama());
            ps.setString(2, pelanggan.getEmail());
            ps.setInt(3, pelanggan.getUmur());
            ps.setInt(4, pelanggan.getPelangganId()); 
            
            ps.executeUpdate();
        }
		
	}

	@Override
	public void deletePelanggan(int id) throws Exception {
		String sql = "DELETE FROM pelanggan WHERE id=?";
        
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
        }
		
	}

	@Override
	public List<Pelanggan> findAllPelanggan() throws Exception {
		List<Pelanggan> listPelanggan = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan ORDER BY nama ASC";
        
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                int umur = rs.getInt("umur");
                Pelanggan pelanggan = new Pelanggan(id, nama, email, umur);
                
                listPelanggan.add(pelanggan);
            }
        }
        
        return listPelanggan;
    }
}
