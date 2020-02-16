package com.akademiakodu.gifs.controller;


import com.akademiakodu.gifs.model.Category;
import com.akademiakodu.gifs.model.Gif;
import com.akademiakodu.gifs.repository.CategoryRepository;
import com.akademiakodu.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap) {

        List<Category> categoryList = categoryRepository.getAllCategories();

        modelMap.put("categories", categoryList);

        return "categories";

    }

    //@PAthVariable zbieramy z url

    @GetMapping("/category/{id}")
    public String gifsCategory(@PathVariable int id, ModelMap modelMap) {
        //1 pobranie kategorii po id
       Category category = categoryRepository.getCategoryById(id);

        //1.2 pobieranie gifów z id
        List<Gif> gifs = gifRepository.getGifsByCategoryId(id);

        //2 przekazanie
        modelMap.put("category", category);
        modelMap.put("gifs", gifs);
        //3 zwrocenie
        return "category";

    }




}
