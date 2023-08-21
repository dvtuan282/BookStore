package com.example.fbook.Controller;

import com.example.fbook.Entity.NhaXuatBanEntity;
import com.example.fbook.Service.ServiceImpl.NhaXuatBanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/K-Book/admin/nha-xuat-ban")
public class NhaXuatBanController {
    @Autowired
    private NhaXuatBanServiceImpl nhaXuatBanService;

    @GetMapping("")
    public String hienThi(@RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                          Model model) {
        int totalPage = 0;
        long totalItems = 0;
        List<NhaXuatBanEntity> listNXB = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            Page<NhaXuatBanEntity> pageAll = nhaXuatBanService.findAll(pageNumber - 1, 5);
            totalPage = pageAll.getTotalPages();
            totalItems = pageAll.getTotalElements();
            listNXB = pageAll.getContent();
        } else {
            Pageable pageable = PageRequest.of(pageNumber - 1, 5);
            Page<NhaXuatBanEntity> pageAll = nhaXuatBanService.findByKeyWord("%" + name + "%", pageable);
            totalPage = pageAll.getTotalPages();
            totalItems = pageAll.getTotalElements();
            listNXB = pageAll.getContent();
            model.addAttribute("name", name);
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listNXB", listNXB);
        model.addAttribute("nxb", new NhaXuatBanEntity());
        return "NhaXuatBan";
    }

    @PostMapping("/them")
    public String saveNXB(@ModelAttribute NhaXuatBanEntity nhaXuatBanEntity) {
        nhaXuatBanEntity.setId(UUID.randomUUID());
        nhaXuatBanService.save(nhaXuatBanEntity);
        return "redirect:/K-Book/admin/nha-xuat-ban";
    }

    @GetMapping("/xoa/{id}")
    public String deleteNXB(@PathVariable UUID id) {
        nhaXuatBanService.delete(id);
        return "redirect:/K-Book/admin/nha-xuat-ban";

    }

}
