package com.example.fbook.Service;

import com.example.fbook.Entity.DanhMucEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DanhMucService {
    public Page<DanhMucEntity> findAll(int pageNumber, int pageSize);

    public List<DanhMucEntity> selectDM();

    public Page<DanhMucEntity> findByName(String name, Pageable pageable);

    public DanhMucEntity findById(UUID id);

    public void save(DanhMucEntity danhMuc);

    public void delete(UUID id);
}
