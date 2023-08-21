package com.example.fbook.Repository;

import com.example.fbook.Entity.SachEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SachRepository extends JpaRepository<SachEntity, UUID> {
    Page<SachEntity> findByTenSachLike(String name, Pageable pageable);
}
