package com.example.pons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pons.model.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, Long>{	
	
	Optional<Attendee> findByEmail(String email);
	Optional<Attendee> findByPhoneNumber(long phone);
}
