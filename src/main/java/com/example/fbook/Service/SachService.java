package com.example.fbook.Service;

import com.example.fbook.Entity.SachEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SachService {
    public Page<SachEntity> findAll(int pageNumber, int pageSize);

    public Page<SachEntity> search(String name, Pageable pageable);

    public SachEntity findById(UUID id);

    public void save(SachEntity sachEntity);

    public void delete(UUID id);
}
