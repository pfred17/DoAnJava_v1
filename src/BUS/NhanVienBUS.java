package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NhanVienBUS {
    private ArrayList<NhanVienDTO> danhSachNhanVien;
    private NhanVienDAO nhanVienDAO;
    
    public NhanVienBUS() {
        nhanVienDAO = new NhanVienDAO();
    }
    
    public void loadData() {
        danhSachNhanVien = nhanVienDAO.getDataFromSQL();
    }
    
    public boolean addNhanVien(String IDNhanVien, String HoNhanVien, String TenNhanVien, String SDT, String Gmail, String GioiTinh) {
        NhanVienDTO nhanVienDTO = new NhanVienDTO(IDNhanVien, HoNhanVien, TenNhanVien, SDT, Gmail, GioiTinh);
            
        if (nhanVienDAO.addNhanVien(nhanVienDTO) > 0) {
            JOptionPane.showMessageDialog(null, "THEM NHAN VIEN THANH CONG");
            return true;
        }
        return false;
    }
    
}
