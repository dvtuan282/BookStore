package com.example.fbook.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "nha_xuat_ban")
@Data
public class NhaXuatBanEntity extends BaseEntity {

    @Column(name = "ten_nha_xuat_ban")
    private String tenNhaXuatBan;

    @OneToMany(mappedBy = "nhaXuatBan", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SachEntity> sach;
}
