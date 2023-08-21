package com.example.fbook.Repository;

import com.example.fbook.Entity.TacGiaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TacGiaRepository extends JpaRepository<TacGiaEntity, UUID> {
    Page<TacGiaEntity> findByTenTacGiaLike(String name, Pageable pageable);
}
