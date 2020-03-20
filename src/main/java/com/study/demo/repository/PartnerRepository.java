package com.study.demo.repository;

import com.study.demo.model.entity.Category;
import com.study.demo.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByCategory(Category category);
}
