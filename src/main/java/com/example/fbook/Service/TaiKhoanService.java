package com.example.fbook.Service;

import com.example.fbook.Entity.TaiKhoanEntity;
import org.springframework.data.domain.Page;

public interface TaiKhoanService {
    public TaiKhoanEntity dangNhap(String email, String matKhau);

    public void dangKyTaiKhoan(TaiKhoanEntity taiKhoanEntity);

}
