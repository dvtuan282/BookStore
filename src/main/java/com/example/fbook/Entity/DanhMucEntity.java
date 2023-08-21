package com.example.fbook.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "danh_muc")
@Data
public class DanhMucEntity extends BaseEntity {
    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;

    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SachEntity> sach;
}
