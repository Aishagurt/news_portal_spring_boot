package kz.bitlab.techboot.springsecurityboot.controller;

import kz.bitlab.techboot.springsecurityboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin-panel")
    public String addPostPage(Model model){
        model.addAttribute("categories", categoryService.getCategories());
        return "add-post";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/add-tag")
    public String addTagPage(Model model){
        model.addAttribute("categories", categoryService.getCategories());
        return "add-tag";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/add-category")
    public String addCategoryPage(Model model){
        model.addAttribute("categories", categoryService.getCategories());
        return "add-category";
    }
}