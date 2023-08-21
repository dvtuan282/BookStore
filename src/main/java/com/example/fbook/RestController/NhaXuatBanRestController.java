package com.example.fbook.RestController;

import com.example.fbook.Entity.NhaXuatBanEntity;
import com.example.fbook.Service.ServiceImpl.NhaXuatBanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/K-Book/admin/nha-xuat-ban")
public class NhaXuatBanRestController {
    @Autowired
    NhaXuatBanServiceImpl nhaXuatBanService;

    @GetMapping("/{id}")
    public NhaXuatBanEntity findById(@PathVariable UUID id) {
        NhaXuatBanEntity nhaXuatBanEntity = nhaXuatBanService.findById(id);
        return nhaXuatBanEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhaXuatBanEntity> updateNXB(@PathVariable UUID id,
                                                      @RequestBody NhaXuatBanEntity nhaXuatBanEntity) {
        nhaXuatBanEntity.setId(id);
        nhaXuatBanService.save(nhaXuatBanEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
