package com.akademiakodu.gifs.repository;


import com.akademiakodu.gifs.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> All_CATEGORIES = Arrays.asList(
            new Category(0, "fanny"),
            new Category(1, "sport"),
            new Category(2, "it")

    );

    public List<Category> getAllCategories() {
        return All_CATEGORIES;
    }

    public Category getCategoryById(int id) {
        for (Category allCategory : All_CATEGORIES) {
            if (allCategory.getId() == id) {
                return allCategory;
            }
        }
        return null;
    }

}
