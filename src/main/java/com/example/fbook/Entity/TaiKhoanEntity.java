package com.example.fbook.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tai_khoan")
@Data
public class TaiKhoanEntity {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "anh")
    private String anh;

    @Column(name = "vai_tro")
    private int vai;
}
