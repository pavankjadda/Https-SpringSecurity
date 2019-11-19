package com.pj.springsecurity.https.web;

import com.pj.springsecurity.https.dto.CategoryDTO;
import com.pj.springsecurity.https.model.Category;
import com.pj.springsecurity.https.repo.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v2/category")
public class CategoryController
{
	private final CategoryRepository categoryRepository;

	private final ModelMapper modelMapper;

	public CategoryController(CategoryRepository categoryRepository, ModelMapper modelMapper)
	{
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	@PostMapping(path = "/create")
	public void createCategory(@RequestBody CategoryDTO categoryDTO)
	{
		Category category = modelMapper.map(categoryDTO, Category.class);
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
