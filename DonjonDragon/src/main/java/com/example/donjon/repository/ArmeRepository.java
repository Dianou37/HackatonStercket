package com.example.donjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donjon.entity.Arme;

@Repository
public interface ArmeRepository extends JpaRepository<Arme,Long> {
	

}
