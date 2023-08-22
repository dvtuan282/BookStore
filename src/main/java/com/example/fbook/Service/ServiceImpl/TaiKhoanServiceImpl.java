package com.example.fbook.Service.ServiceImpl;

import com.example.fbook.Entity.TaiKhoanEntity;
import com.example.fbook.Repository.TaiKhoanRepository;
import com.example.fbook.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Override
    public TaiKhoanEntity dangNhap(String email, String matKhau) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findByEmailAndMatKhau(email, matKhau);
        return taiKhoanEntity;
    }

    @Override
    public void dangKyTaiKhoan(TaiKhoanEntity taiKhoanEntity) {
        this.taiKhoanRepository.save(taiKhoanEntity);
    }
}
