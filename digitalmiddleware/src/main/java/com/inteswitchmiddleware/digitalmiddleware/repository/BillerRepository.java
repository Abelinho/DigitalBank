package com.inteswitchmiddleware.digitalmiddleware.repository;

import com.inteswitchmiddleware.digitalmiddleware.entity.Biller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillerRepository extends JpaRepository<Biller,Long> {
    List<Biller> findByCategoryId(Long categoryId);
}
