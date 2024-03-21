package DAO;

import DTO.NhanVienDTO;
import connectionDB.SQLServerConnection;
import java.sql.*;
import java.util.ArrayList;

public class NhanVienDAO {
    public ArrayList<NhanVienDTO> getDataFromSQL() {
        
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try {
            Connection connection = SQLServerConnection.getConnection();
            Statement state = connection.createStatement();
            ResultSet rs = state.executeQuery("select * from NhanVien");
            
            while(rs.next()) {
                String IDNhanVien = rs.getString("IDNhanVien");
                String HoNhanVien = rs.getString("HoNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                String SDT = rs.getString("SDt");
                String Gmail = rs.getString("Gmail");
                String GioiTinh = rs.getString("GioiTinh");
                
                list.add(new NhanVienDTO(IDNhanVien, HoNhanVien, TenNhanVien, SDT, Gmail, GioiTinh));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addNhanVien(NhanVienDTO nhanVien) {
        String slqQuery = "insert into NhanVien(IDNhanVien, HoNhanVien, TenNhanVien, SDT, Gmail, GioiTinh)"
                        + "values(?, ?, ?, ?, ?, ?)";
        
        try {
            Connection connection = SQLServerConnection.getConnection();
            PreparedStatement pr = connection.prepareStatement(slqQuery);
                
            pr.setString(1, nhanVien.getIDNhanVien());
            pr.setString(2, nhanVien.getHoNhanVien());
            pr.setString(3, nhanVien.getTenNhanVien());
            pr.setString(4, nhanVien.getSDT());
            pr.setString(5, nhanVien.getGmail());
            pr.setString(6, nhanVien.getGioiTinh());
            
            return pr.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
