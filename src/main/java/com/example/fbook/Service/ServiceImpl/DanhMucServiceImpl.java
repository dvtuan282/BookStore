package com.example.fbook.Service.ServiceImpl;

import com.example.fbook.Entity.DanhMucEntity;
import com.example.fbook.Repository.DanhMucRepository;
import com.example.fbook.Service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    private DanhMucRepository repository;

    @Override
    public Page<DanhMucEntity> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public List<DanhMucEntity> selectDM() {
        return repository.findAll();
    }

    @Override
    public Page<DanhMucEntity> findByName(String name, Pageable pageable) {
        return repository.findByTenDanhMucLike(name, pageable);
    }

    @Override
    public DanhMucEntity findById(UUID id) {
        Optional<DanhMucEntity> danhMucOp = repository.findById(id);
        DanhMucEntity danhMucEntity = null;
        if (danhMucOp.isPresent()) {
            danhMucEntity = danhMucOp.get();
        } else {
            throw new RuntimeException("NOT FOUND");
        }
        return danhMucEntity;
    }

    @Override
    public void save(DanhMucEntity danhMuc) {
        this.repository.save(danhMuc);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
