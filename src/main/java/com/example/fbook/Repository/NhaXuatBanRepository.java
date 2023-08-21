package com.example.fbook.Repository;

import com.example.fbook.Entity.NhaXuatBanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBanEntity, UUID> {
    Page<NhaXuatBanEntity> findByTenNhaXuatBanLike(String name, Pageable pageable);
}
