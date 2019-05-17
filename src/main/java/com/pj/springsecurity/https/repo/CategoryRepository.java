package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}
