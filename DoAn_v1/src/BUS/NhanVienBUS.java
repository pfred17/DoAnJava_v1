package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienBUS {

    private ArrayList<NhanVienDTO> danhSachNhanVien;
    private NhanVienDAO nhanVienDAO;

    public NhanVienBUS() {
        nhanVienDAO = new NhanVienDAO();
    }

    public void loadData() {
        danhSachNhanVien = nhanVienDAO.getDataFromSQL();
    }

    public boolean addNhanVien(String IDNhanVien, String HoNhanVien, String TenNhanVien, String SDT, String Gmail, String GioiTinh,int daKhoa) {
        NhanVienDTO nhanVienDTO = new NhanVienDTO(IDNhanVien, HoNhanVien, TenNhanVien, SDT, Gmail, GioiTinh, daKhoa);

        if (nhanVienDAO.addNhanVien(nhanVienDTO) > 0) {
            JOptionPane.showMessageDialog(null, "THEM NHAN VIEN THANH CONG");
            return true;
        }
        return false;
    }

    public String searchIDNhanVien(String IDNhanVien) { // Hàm tìm kiem ID nhan vien
        loadData();
        for (NhanVienDTO nhanVien : danhSachNhanVien) {
            if (nhanVien.getIDNhanVien().equals(IDNhanVien)) {
                return nhanVien.getIDNhanVien();
            }
        }
        return "";
    }

    public String searchHoNhanVien(String hoNhanVien) {
        loadData();
        for (NhanVienDTO nhanVien : danhSachNhanVien) {
            if (nhanVien.getHoNhanVien().equals(hoNhanVien)) {
                return nhanVien.getHoNhanVien();
            }
        }
        return "";
    }

    public String searchTenNhanVien(String tenNhanVien) {
        loadData();
        for (NhanVienDTO nhanVien : danhSachNhanVien) {
            if (nhanVien.getTenNhanVien().equals(tenNhanVien)) {
                return nhanVien.getTenNhanVien();
            }
        }
        return "";
    }

    public String searchSDT(String sdt) {
        loadData();
        for (NhanVienDTO nhanVien : danhSachNhanVien) {
            if (nhanVien.getSDT().equals(sdt)) {
                return nhanVien.getSDT();
            }
        }
        return "";
    }

    public String searchGmail(String gmail) {
        loadData();
        for (NhanVienDTO nhanVien : danhSachNhanVien) {
            if (nhanVien.getGmail().equals(gmail)) {
                return nhanVien.getGmail();
            }
        }
        return "";
    }
    
    public String searchGioiTinh(String gioiTinh) {
        loadData();
        for (NhanVienDTO nhanVien : danhSachNhanVien) {
            if (nhanVien.getGioiTinh().equals(gioiTinh)) {
                return nhanVien.getGioiTinh();
            }
        }
        return "";
    } 
    
//    Hàm tìm kiem 1 nhan vien theo ma nhan vien (IDNhanVien)
    public NhanVienDTO searchNhanVienByID(NhanVienDTO nhanVien) {
        loadData();
        for (NhanVienDTO nhanVienDTO : danhSachNhanVien) {
            if (nhanVienDTO.getIDNhanVien().equals(nhanVien.getIDNhanVien())) {
                return nhanVienDTO;
            }
        }        
        return null;
    } 

//    Hàm render du lieu vao bang cho NhanVienGUI su dung
    public void renderTable(DefaultTableModel model) {
        loadData();
        model.setRowCount(0);
        for (NhanVienDTO nhanVien : danhSachNhanVien) {
            if (nhanVien.getDaKhoa() == 0) {
                model.addRow(new Object[]{nhanVien.getIDNhanVien(), nhanVien.getHoNhanVien(), nhanVien.getTenNhanVien(), nhanVien.getSDT(), nhanVien.getGmail(), nhanVien.getGioiTinh()
            });
            } 
        }
    }

}
