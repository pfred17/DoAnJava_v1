package DTO;

public class TaiKhoanNhanVienDTO {
    private String IDNhanVien;
    private String MatKhau;
    
    public TaiKhoanNhanVienDTO() {
        
    }

    public TaiKhoanNhanVienDTO(String IDNhanVien, String MatKhau) {
        this.IDNhanVien = IDNhanVien;
        this.MatKhau = MatKhau;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    
    
}
