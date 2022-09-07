package com.hotDesking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotDesking.entity.Building;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

}
