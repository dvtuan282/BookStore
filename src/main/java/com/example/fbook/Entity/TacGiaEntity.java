package com.example.fbook.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tac_gia")
@Data
public class TacGiaEntity extends BaseEntity {
    @Column(name = "ten_tac_gia")
    private String tenTacGia;

    @OneToMany(mappedBy = "tacGia", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SachEntity> sach;
}
