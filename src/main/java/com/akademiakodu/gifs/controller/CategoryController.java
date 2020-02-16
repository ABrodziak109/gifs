package com.akademiakodu.gifs.controller;


import com.akademiakodu.gifs.model.Category;
import com.akademiakodu.gifs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {

        List<Category> categoryList = categoryRepository.getAllCategories();

        modelMap.put("categories", categoryList);

        return "categories";

    }




}
