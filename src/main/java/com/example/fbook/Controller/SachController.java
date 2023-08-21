package com.example.fbook.Controller;

import com.example.fbook.Entity.DanhMucEntity;
import com.example.fbook.Entity.SachEntity;
import com.example.fbook.Service.ServiceImpl.DanhMucServiceImpl;
import com.example.fbook.Service.ServiceImpl.NhaXuatBanServiceImpl;
import com.example.fbook.Service.ServiceImpl.SachServiceImpl;
import com.example.fbook.Service.ServiceImpl.TacGiaServiceImpl;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/K-Book/admin/sach")
public class SachController {
    @Value("${upload.path}")
    private String pathFolder;
    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    SachServiceImpl sachService;

    @Autowired
    TacGiaServiceImpl tacGiaService;

    @Autowired
    DanhMucServiceImpl danhMucService;

    @Autowired
    NhaXuatBanServiceImpl nhaXuatBanService;

    @GetMapping("")
    public String danhSach(@RequestParam(name = "name", required = false) String name,
                           @RequestParam(name = "pageNumber", defaultValue = "1", required = false) int pageNumber,
                           Model model) {
        int totalPage = 0;
        long totalItems = 0;
        List<SachEntity> listSach = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            Page<SachEntity> page = sachService.findAll(pageNumber - 1, 5);
            totalItems = page.getTotalElements();
            totalPage = page.getTotalPages();
            listSach = page.getContent();
        } else {
            Pageable pageable = PageRequest.of(pageNumber - 1, 5);
            Page<SachEntity> page1 = sachService.search("%" + name + "%", pageable);
            totalItems = page1.getTotalElements();
            totalPage = page1.getTotalPages();
            listSach = page1.getContent();
            model.addAttribute("name", name);
        }
        model.addAttribute("listSach", listSach);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("sach", new SachEntity());
        model.addAttribute("totalPage", totalPage);

        return "Sach";
    }

    @GetMapping("/form")
    public String formAdd(Model model) {
        selectThuocTinh(model);
        model.addAttribute("sach", new SachEntity());
        model.addAttribute("action", "/K-Book/admin/sach/them");
        return "FormSach";
    }

    @GetMapping("/xoa/{id}")
    public String delete(@PathVariable UUID id,
                         Model model) {
        sachService.delete(id);
        return "redirect:/K-Book/admin/sach";
    }

    @PostMapping("/them")
    public String addSach(@Valid @ModelAttribute("sach") SachEntity sachEntity,
                          BindingResult result,
                          @RequestParam("file") MultipartFile file,
                          Model model) {
        if (result.hasErrors()) {
            return "forward:/them";
        } else {
            try {
                if (!file.isEmpty()) {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(pathFolder + file.getOriginalFilename());
                    Files.write(path, bytes);
                    sachEntity.setId(UUID.randomUUID());
                    sachEntity.setAnh(file.getOriginalFilename());
                    sachService.save(sachEntity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/K-Book/admin/sach/form";
    }

    @PostMapping("sua/{id}")
    public String updateSach(@Valid @ModelAttribute("sach") SachEntity sachEntity,
                             @PathVariable UUID id,
                             BindingResult result,
                             @RequestParam("file") MultipartFile file,
                             Model model) {
        if (result.hasErrors()) {

        }
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(pathFolder + file.getOriginalFilename());
                Files.write(path, bytes);
                sachEntity.setId(id);
                sachEntity.setAnh(file.getOriginalFilename());
                sachService.save(sachEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/K-Book/admin/sach";


    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable UUID id) {
        SachEntity sachEntity = sachService.findById(id);
        model.addAttribute("sach", sachEntity);
        selectThuocTinh(model);
        model.addAttribute("action", "/K-Book/admin/sach/sua/" + id);
        return "formSach";
    }

    public void selectThuocTinh(Model model) {
        model.addAttribute("dm", danhMucService.selectDM());
        model.addAttribute("tg", tacGiaService.selectTG());
        model.addAttribute("nxb", nhaXuatBanService.selectNXB());
    }

}
