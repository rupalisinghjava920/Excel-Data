package com.Excel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Excel.entity.ImageData;

@Repository
public interface StorageRepository extends JpaRepository<ImageData,Long>{

	Optional<ImageData>findByName(String name);
}
