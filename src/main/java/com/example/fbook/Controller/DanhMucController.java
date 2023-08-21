package com.example.fbook.Controller;

import com.example.fbook.Entity.DanhMucEntity;
import com.example.fbook.Service.ServiceImpl.DanhMucServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/K-Book/admin/danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucServiceImpl danhMucService;

    @GetMapping("")
    public String hienThi(Model model,
                          @RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber
    ) {
        int totalPage = 0;
        long totalItems = 0;
        List<DanhMucEntity> listDM = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            Page<DanhMucEntity> page = danhMucService.findAll(pageNumber - 1, 5);
            listDM = page.getContent();
            totalPage = page.getTotalPages();
            totalItems = page.getTotalElements();
        } else {
            Pageable pageable = PageRequest.of(pageNumber - 1, 5);
            Page<DanhMucEntity> pageName = danhMucService.findByName("%" + name + "%", pageable);
            listDM = pageName.getContent();
            totalItems = pageName.getTotalElements();
            totalPage = pageName.getTotalPages();
            model.addAttribute("name", name);
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listDM", listDM);
        model.addAttribute("danhMuc", new DanhMucEntity());
        return "DanhMuc";
    }

    @PostMapping("/them")
    public String addDanhMuc(@ModelAttribute DanhMucEntity danhMucEntity) {
        danhMucEntity.setId(UUID.randomUUID());
        danhMucService.save(danhMucEntity);
        return "redirect:/K-Book/admin/danh-muc";
    }

    @GetMapping("/xoa/{id}")
    public String deleteDanhMuc(@PathVariable UUID id) {
        danhMucService.delete(id);
        return "redirect:/K-Book/admin/danh-muc";
    }

    @PostMapping("/sua/{id}")
    public String suaDanhMuc(@PathVariable UUID id,
                             @ModelAttribute DanhMucEntity danhMucEntity) {
        danhMucEntity.setId(id);
        danhMucService.save(danhMucEntity);
        return "redirect:/K-Book/admin/danh-muc";

    }


}
