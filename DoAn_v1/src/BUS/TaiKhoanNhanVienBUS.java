package BUS;

import DAO.TaiKhoanNhanVienDAO;
import DTO.TaiKhoanNhanVienDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TaiKhoanNhanVienBUS {
    private ArrayList<TaiKhoanNhanVienDTO> listTaiKhoanNhanVien;
    private TaiKhoanNhanVienDAO taiKhoanNhanVienDAO;
    
    public void loadData() {
        listTaiKhoanNhanVien = taiKhoanNhanVienDAO.getDataFromSQL();
    }
    
    public String searchIDNhanVien(String IdNhanVien) {
        loadData();
        for (TaiKhoanNhanVienDTO taiKhoanNhanVienDTO : listTaiKhoanNhanVien) {
            if (taiKhoanNhanVienDTO.getIDNhanVien().equals(IdNhanVien)) {
                return taiKhoanNhanVienDTO.getIDNhanVien();
            } 
        }
        return "";
    }
    
    public String searchMatKhau(String matKhau) {
        loadData();
        for (TaiKhoanNhanVienDTO taiKhoanNhanVienDTO : listTaiKhoanNhanVien) {
            if (taiKhoanNhanVienDTO.getMatKhau().equals(matKhau)) {
                return taiKhoanNhanVienDTO.getMatKhau();
            } 
        }
        return "";
    }
    
    public boolean login(String IdNhanVien, String matKhau) {
        
        if (searchIDNhanVien(IdNhanVien).equals(IdNhanVien) && searchMatKhau(matKhau).equals(matKhau)) {
            return true;
        }
        
        if (IdNhanVien.equals("") || matKhau.equals("")) return false;
        return false;
    }
    
}
