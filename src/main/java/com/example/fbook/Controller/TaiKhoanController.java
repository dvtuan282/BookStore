package com.example.fbook.Controller;

import com.example.fbook.Entity.TaiKhoanEntity;
import com.example.fbook.Service.ServiceImpl.TaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/K-Book")
public class TaiKhoanController {
    @Autowired
    TaiKhoanServiceImpl taiKhoanService;

    @GetMapping("/dang-ky")
    public String dangKy(Model model) {
        model.addAttribute("taiKhoan", new TaiKhoanEntity());
        return "DangKy";
    }
}
