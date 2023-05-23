package com.example.automatic.irrigation.system.entity.dao;

import com.example.automatic.irrigation.system.entity.dto.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop,Integer> {
}
