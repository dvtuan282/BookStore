package com.example.fbook.Repository;

import com.example.fbook.Entity.DanhMucEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DanhMucRepository extends JpaRepository<DanhMucEntity, UUID> {
    Page<DanhMucEntity> findByTenDanhMucLike(String Name, Pageable pageable);
}
