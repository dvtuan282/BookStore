package com.example.fbook.RestController;

import com.example.fbook.Entity.TacGiaEntity;
import com.example.fbook.Service.ServiceImpl.TacGiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/K-Book/admin/tac-gia")
@CrossOrigin(origins = "*")
public class TacGiaRestController {
    @Autowired
    TacGiaServiceImpl tacGiaService;

    @GetMapping("/{id}")
    public TacGiaEntity findById(@PathVariable UUID id) {
        TacGiaEntity tacGiaEntity = tacGiaService.findById(id);
        return tacGiaEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TacGiaEntity> updateTacGia(@PathVariable UUID id,
                                                     @RequestBody TacGiaEntity tacGiaEntity) {
        tacGiaEntity.setId(id);
        tacGiaService.save(tacGiaEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
