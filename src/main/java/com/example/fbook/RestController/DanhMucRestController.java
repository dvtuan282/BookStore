package com.example.fbook.RestController;

import com.example.fbook.Entity.DanhMucEntity;
import com.example.fbook.Entity.SachEntity;
import com.example.fbook.Service.ServiceImpl.DanhMucServiceImpl;
import com.example.fbook.Service.ServiceImpl.SachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/K-Book/admin/danh-muc")
public class DanhMucRestController {
    @Autowired
    SachServiceImpl sachService;
    @Autowired
    DanhMucServiceImpl danhMucService;

    @GetMapping("/{id}")
    public DanhMucEntity findById(@PathVariable UUID id) {
        DanhMucEntity danhMuc = danhMucService.findById(id);
        return danhMuc;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DanhMucEntity> update(@PathVariable UUID id, @RequestBody DanhMucEntity danhMucEntity) {
        danhMucEntity.setId(id);
        danhMucService.save(danhMucEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
