package com.example.pons.service;

import java.util.List;
import java.util.Optional;

import com.example.pons.model.Attendee;

public interface AttendeeService {

	public Attendee saveAttendee(Attendee attendee);
	
	public List<Attendee> getAttendees();
	
	public Optional<Attendee> getById(long id);
	
	public Attendee updateAttendee(Attendee attendee,long id);
	
	public void deleteAttendee(long id);
	
}
