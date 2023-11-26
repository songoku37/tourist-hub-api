package com.leesungjae.tourist_hub_api.main.repository;

import com.leesungjae.tourist_hub_api.entity.TouristAttraction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TouristAttractionRepository extends JpaRepository<TouristAttraction, Long> {


//    @Query("select t from TouristAttraction t offset ")
    Page<TouristAttraction> findAllBy(Pageable pageable);
}

