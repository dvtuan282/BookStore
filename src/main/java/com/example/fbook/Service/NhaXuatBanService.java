package com.example.fbook.Service;

import com.example.fbook.Entity.DanhMucEntity;
import com.example.fbook.Entity.NhaXuatBanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhaXuatBanService {
    public Page<NhaXuatBanEntity> findAll(int pageNumber, int pageSize);

    public List<NhaXuatBanEntity> selectNXB();

    public Page<NhaXuatBanEntity> findByKeyWord(String keyWord, Pageable pageable);

    public NhaXuatBanEntity findById(UUID id);

    public void save(NhaXuatBanEntity nxb);

    public void delete(UUID id);
}
