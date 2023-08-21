package com.example.fbook.Repository;

import com.example.fbook.Entity.GioHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHangEntity, UUID> {
}
