package com.example.donjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donjon.entity.Monstre;

@Repository
public interface MonstreRepository extends JpaRepository<Monstre,Long>{

}
