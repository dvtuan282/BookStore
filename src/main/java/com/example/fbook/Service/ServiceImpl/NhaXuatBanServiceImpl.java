package com.example.fbook.Service.ServiceImpl;

import com.example.fbook.Entity.NhaXuatBanEntity;
import com.example.fbook.Repository.NhaXuatBanRepository;
import com.example.fbook.Service.NhaXuatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhaXuatBanServiceImpl implements NhaXuatBanService {
    @Autowired
    private NhaXuatBanRepository repository;

    @Override
    public Page<NhaXuatBanEntity> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public List<NhaXuatBanEntity> selectNXB() {
        return repository.findAll();
    }

    @Override
    public Page<NhaXuatBanEntity> findByKeyWord(String keyWord, Pageable pageable) {
        return repository.findByTenNhaXuatBanLike(keyWord, pageable);
    }

    @Override
    public NhaXuatBanEntity findById(UUID id) {
        Optional<NhaXuatBanEntity> nxbOp = repository.findById(id);
        NhaXuatBanEntity nhaXuatBanEntity = null;
        if (nxbOp.isPresent()) {
            nhaXuatBanEntity = nxbOp.get();
        } else {
            throw new RuntimeException("NOT FOUND");
        }
        return nhaXuatBanEntity;
    }

    @Override
    public void save(NhaXuatBanEntity nxb) {
        this.repository.save(nxb);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
