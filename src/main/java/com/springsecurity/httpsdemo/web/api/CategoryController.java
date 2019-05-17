package com.springsecurity.httpsdemo.web.api;

import com.springsecurity.httpsdemo.model.Category;
import com.springsecurity.httpsdemo.repo.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v2/category")
public class CategoryController
{
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping(path = "/create")
    public void createCategory(@RequestBody Category category)
    {
        categoryRepository.save(category);
    }

    @GetMapping(value = "/list")
    public List<Category> getCategories()
    {
        return categoryRepository.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Category> getAddressById(@PathVariable long id)
    {
        return categoryRepository.findById(id);
    }
}
