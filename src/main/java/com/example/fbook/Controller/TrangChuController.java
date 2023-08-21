package com.example.fbook.Controller;

import com.example.fbook.Entity.NhaXuatBanEntity;
import com.example.fbook.Entity.SachEntity;
import com.example.fbook.Service.ServiceImpl.SachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/K-Book")
public class TrangChuController {
    @Autowired
    SachServiceImpl sachService;

    @GetMapping("")
    public String trangChu(Model model,
                           @RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                           @RequestParam(name = "keyWord", required = false) String keyWord) {
        int totalPage = 0;
        long totalItems = 0;
        List<SachEntity> listSach = new ArrayList<>();
        if (keyWord == null || keyWord.isEmpty()) {
            Page<SachEntity> page = sachService.findAll(pageNumber - 1, 5);
            totalItems = page.getTotalElements();
            totalPage = page.getTotalPages();
            listSach = page.getContent();
        } else {
            Pageable pageable = PageRequest.of(pageNumber - 1, 12);
            Page<SachEntity> page1 = sachService.search("%" + keyWord + "%", pageable);
            totalItems = page1.getTotalElements();
            totalPage = page1.getTotalPages();
            listSach = page1.getContent();
            model.addAttribute("name", keyWord);
        }
        model.addAttribute("listSach", listSach);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPage", totalPage);
        return "TrangChu";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable UUID id, Model model) {
        sachService.findById(id);
        return "detailSach";
    }

}
