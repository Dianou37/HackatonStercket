package com.example.donjon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donjon.entity.Perso;

@Repository
public interface PersoRepository extends JpaRepository<Perso,Long> {

}
