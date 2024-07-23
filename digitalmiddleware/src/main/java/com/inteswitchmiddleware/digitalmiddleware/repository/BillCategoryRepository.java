package com.inteswitchmiddleware.digitalmiddleware.repository;

import com.inteswitchmiddleware.digitalmiddleware.entity.BillCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillCategoryRepository extends JpaRepository<BillCategory,Long> {
}
