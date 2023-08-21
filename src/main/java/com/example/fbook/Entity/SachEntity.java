package com.example.fbook.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "sach")
@Data
public class SachEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "danh_muc")
    @ToString.Exclude
    private DanhMucEntity danhMuc;

    @ManyToOne
    @JoinColumn(name = "tac_gia")
    @ToString.Exclude
    private TacGiaEntity tacGia;

    @ManyToOne
    @JoinColumn(name = "nha_xuat_ban")
    @ToString.Exclude
    private NhaXuatBanEntity nhaXuatBan;

    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Column(name = "ten_sach")
    private String tenSach;

    @NotNull(message = "Vui lòng nhập dữ liệu")
    @Column(name = "gia_tien")
    private Double giaTien;

    @NotNull(message = "Vui lòng nhập dữ liệu")
    @Column(name = "so_luong")
    private int soLuong;

    @NotEmpty(message = "Vui lòng nhập dữ liệu")
    @Column(name = "ngay_xuat_ban")
    private String ngayXuatBan;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "anh")
    private String anh;

    @Column(name = "trang_thai")
    private int trangThai;
}
