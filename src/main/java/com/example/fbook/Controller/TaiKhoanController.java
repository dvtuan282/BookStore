package com.example.fbook.Controller;

import com.example.fbook.Entity.TaiKhoanEntity;
import com.example.fbook.Service.ServiceImpl.TaiKhoanServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/K-Book")
public class TaiKhoanController {
    @Autowired
    TaiKhoanServiceImpl taiKhoanService;

    @GetMapping("/dang-ky")
    public String dangKy(Model model) {
        model.addAttribute("taiKhoan", new TaiKhoanEntity());
        return "register";
    }

    @PostMapping("/dang-ky")
    public String dangKy(@Valid @ModelAttribute("taiKhoan") TaiKhoanEntity taiKhoan,
                         BindingResult result, Model model,
                         @RequestParam(name = "ho") String ho,
                         @RequestParam(name = "ten") String ten,
                         @RequestParam(name = "matKhau") String matKhau) {
        if (result.hasErrors()) {
            return "register";
        }
        taiKhoan.setHoTen(ho + " " + ten);
        taiKhoanService.dangKyTaiKhoan(taiKhoan);
        return "redirect:/K-Book/dang-nhap";
    }

    @GetMapping("/dang-nhap")
    public String formDangNhap(Model model) {
        return "login";
    }

    @PostMapping("/dang-nhap")
    public String dangNhap(Model model,
                           @RequestParam("email") String emial,
                           @RequestParam("matKhau") String matKhau) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanService.dangNhap(emial, matKhau);
        if (taiKhoanEntity == null) {
            return "redirect:/K-Book/dang-nhap";
        }
        return "redirect:/K-Book/admin/trang-chu";
    }
}
