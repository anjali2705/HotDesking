package com.hotDesking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotDesking.entity.Seat;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
