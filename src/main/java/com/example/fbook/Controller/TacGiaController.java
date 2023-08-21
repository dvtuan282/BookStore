package com.example.fbook.Controller;

import com.example.fbook.Entity.TacGiaEntity;
import com.example.fbook.Service.ServiceImpl.TacGiaServiceImpl;
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
@RequestMapping("/K-Book/admin/tac-gia")
public class TacGiaController {
    @Autowired
    TacGiaServiceImpl tacGiaService;

    @GetMapping("")
    public String hienThi(@RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                          Model model) {
        int totalPage = 0;
        long totalItems = 0;
        List<TacGiaEntity> listTacGia = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            Page<TacGiaEntity> pageTG = tacGiaService.findAll(pageNumber - 1, 5);
            listTacGia = pageTG.getContent();
            totalPage = pageTG.getTotalPages();
            totalItems = pageTG.getTotalElements();
        } else {
            Pageable pageable = PageRequest.of(pageNumber - 1, 5);
            Page<TacGiaEntity> pageTG1 = tacGiaService.findByName("%" + name + "%", pageable);
            listTacGia = pageTG1.getContent();
            totalPage = pageTG1.getTotalPages();
            totalItems = pageTG1.getTotalElements();
            model.addAttribute("name", name);
        }
        model.addAttribute("listTG", listTacGia);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("tacGia", new TacGiaEntity());
        return "TacGia";
    }

    @PostMapping("/them")
    public String addTacGia(@ModelAttribute TacGiaEntity tacGiaEntity) {
        tacGiaEntity.setId(UUID.randomUUID());
        tacGiaService.save(tacGiaEntity);
        return "redirect:/K-Book/admin/tac-gia";
    }

    @GetMapping("/xoa/{id}")
    public String deleteTacGia(@PathVariable UUID id) {
        tacGiaService.delete(id);
        return "redirect:/K-Book/admin/tac-gia";
    }
}
