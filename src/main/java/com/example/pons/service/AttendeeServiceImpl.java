package com.example.pons.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pons.exception.ExistingUserException;
import com.example.pons.exception.NoAttendeeException;
import com.example.pons.model.Attendee;

import com.example.pons.repository.AttendeeRepository;


@Service
public class AttendeeServiceImpl implements AttendeeService{
	
	@Autowired
	private AttendeeRepository attendeeRepository;

	@Override
	public Attendee saveAttendee(Attendee attendee) {
		
		Optional<Attendee> existByEmail=attendeeRepository.findByEmail(attendee.getEmail());
		Optional<Attendee> existByPhone=attendeeRepository.findByPhoneNumber(attendee.getPhoneNumber());
		
		if(existByEmail.isPresent() || existByPhone.isPresent()) {
			throw new ExistingUserException("This Attendee details already exists ");
		}
		return attendeeRepository.save(attendee);
	}

	@Override
	public List<Attendee> getAttendees() {
		return attendeeRepository.findAll();
	}

	@Override
	public Optional<Attendee> getById(long id) {

		
		Optional<Attendee> existsById=attendeeRepository.findById(id);
		
		if(existsById.isEmpty()) {
			throw new NoAttendeeException("No Attendee by this id "+id);
		}
		return attendeeRepository.findById(id);

	}

	@Override
	public Attendee updateAttendee(Attendee attendee,long id) {

		Optional<Attendee> existById=attendeeRepository.findById(id);
		
		if(existById.isEmpty()) {
			throw new NoAttendeeException("No Attendee by this id "+id);
		}
		
		Attendee update=existById.get();
		update.setFirstName(attendee.getFirstName());
		update.setLastName(attendee.getLastName());
		update.setPhoneNumber(attendee.getPhoneNumber());
		update.setEmail(attendee.getEmail());
		update.setIplEvents(attendee.getIplEvents());
		
		return attendeeRepository.save(update);
	}
	@Override
	public void deleteAttendee(long id) {

		
		Optional<Attendee> existById=attendeeRepository.findById(id);
		
		if(existById.isEmpty()) {
			throw new NoAttendeeException("No Attendee by this id "+id);
		}
		else {
			attendeeRepository.deleteById(id);
			System.out.println("Attendee id "+id+" deleted");
		}
	}	

}
