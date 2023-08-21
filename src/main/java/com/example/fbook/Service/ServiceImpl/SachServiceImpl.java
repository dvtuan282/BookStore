package com.example.fbook.Service.ServiceImpl;

import com.example.fbook.Entity.SachEntity;
import com.example.fbook.Repository.SachRepository;
import com.example.fbook.Service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SachServiceImpl implements SachService {
    @Autowired
    SachRepository repository;

    @Override
    public Page<SachEntity> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public Page<SachEntity> search(String name, Pageable pageable) {
        return repository.findByTenSachLike(name, pageable);
    }

    @Override
    public SachEntity findById(UUID id) {
        Optional<SachEntity> sachOp = repository.findById(id);
        SachEntity sachEntity = null;
        if (sachOp.isPresent()) {
            sachEntity = sachOp.get();
        } else {
            throw new RuntimeException("NOT FOULD");
        }
        return sachEntity;
    }

    @Override
    public void save(SachEntity sachEntity) {
        this.repository.save(sachEntity);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
