package com.example.fbook.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "tai_khoan")
@Data
public class TaiKhoanEntity {
    @Id
//    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Column(name = "email")
    private String email;

//    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Column(name = "ho_ten")
    private String hoTen;

//    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Column(name = "mat_khau")
    private String matKhau;

//    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Column(name = "dia_chi")
    private String diaChi;

//    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "anh")
    private String anh;

    @Column(name = "vai_tro")
    private int vai;
}
