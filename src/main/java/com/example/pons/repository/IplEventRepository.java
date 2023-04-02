package com.example.pons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pons.model.IplEvent;

public interface IplEventRepository extends JpaRepository<IplEvent, Long>{

	Optional<IplEvent> findByMatchName(String matchName);

}
