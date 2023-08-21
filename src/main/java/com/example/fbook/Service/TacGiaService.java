package com.example.fbook.Service;

import com.example.fbook.Entity.DanhMucEntity;
import com.example.fbook.Entity.TacGiaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TacGiaService {

    public Page<TacGiaEntity> findAll(int pageNumber, int pageSize);

    public List<TacGiaEntity> selectTG();

    public Page<TacGiaEntity> findByName(String name, Pageable pageable);

    public TacGiaEntity findById(UUID id);

    public void save(TacGiaEntity tacGia);

    public void delete(UUID id);
}
