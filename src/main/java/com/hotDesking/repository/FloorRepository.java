package com.hotDesking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotDesking.entity.Floor;


@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {

}
