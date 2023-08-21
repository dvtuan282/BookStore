package com.example.fbook.Service.ServiceImpl;

import com.example.fbook.Entity.TacGiaEntity;
import com.example.fbook.Repository.TacGiaRepository;
import com.example.fbook.Service.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TacGiaServiceImpl implements TacGiaService {
    @Autowired
    private TacGiaRepository repository;

    @Override
    public Page<TacGiaEntity> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public List<TacGiaEntity> selectTG() {
        return repository.findAll();
    }

    @Override
    public Page<TacGiaEntity> findByName(String name, Pageable pageable) {
        return repository.findByTenTacGiaLike(name, pageable);
    }

    @Override
    public TacGiaEntity findById(UUID id) {
        Optional<TacGiaEntity> tacGiaOp = repository.findById(id);
        TacGiaEntity tacGiaEntity = null;
        if (tacGiaOp.isPresent()) {
            tacGiaEntity = tacGiaOp.get();
        } else {
            throw new RuntimeException("NOT FOUND");
        }
        return tacGiaEntity;
    }

    @Override
    public void save(TacGiaEntity tacGia) {
        this.repository.save(tacGia);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
