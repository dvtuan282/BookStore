package com.example.fbook.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @Column(name = "id")
    private UUID id;
}
