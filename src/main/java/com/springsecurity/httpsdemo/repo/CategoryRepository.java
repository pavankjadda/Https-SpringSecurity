package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}
