package com.example.fbook.Repository;

import com.example.fbook.Entity.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, String> {
    TaiKhoanEntity findByEmailAndMatKhau(String email, String matKhau);
}
