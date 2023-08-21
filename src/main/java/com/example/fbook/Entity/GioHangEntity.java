package com.example.fbook.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "gioi_hang")
@Data
public class GioHangEntity extends BaseEntity {
}
