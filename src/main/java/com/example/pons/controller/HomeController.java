package com.example.pons.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pons.model.Attendee;
import com.example.pons.model.IplEvent;
import com.example.pons.service.AttendeeServiceImpl;
import com.example.pons.service.IplEventServiceImpl;

@RestController
@RequestMapping("/")
public class HomeController {
	
	Logger log=LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IplEventServiceImpl eventService;
	
	@Autowired
	private AttendeeServiceImpl attendeeService;
	
	@GetMapping("ipleventslist")
	public List<IplEvent> getAllEvents(){
		log.info("Getting list of events");
		return eventService.getEvents();
	}

	@PostMapping("iplevents/post")
	public ResponseEntity<IplEvent> saveEvent(@RequestBody IplEvent event) {
		log.info("IPL Event Created !!!!!!!!!");
		return new ResponseEntity<IplEvent>(eventService.saveEvent(event), HttpStatus.CREATED);
	}
	
	@GetMapping("iplevents/{id}")
	public Optional<IplEvent> getEventById(@PathVariable("id") Long id){
		log.info("Getting IPL event");
		return eventService.getEventByID(id);
	}

	@PutMapping("iplevents/{id}")
	public ResponseEntity<IplEvent> updateEvent(@PathVariable("id") Long id, @RequestBody IplEvent event){
		log.info("Modifying IPL Event");
		return new ResponseEntity<IplEvent>(eventService.updateEvent(event,id), HttpStatus.OK);
	}
	

	@DeleteMapping("iplevents/{id}")
	public ResponseEntity<IplEvent> deleteEvent(@PathVariable("id") Long id){
		log.info("Deleting the IPL Event");
		eventService.deleteEvent(id);
		return new ResponseEntity<IplEvent>(HttpStatus.OK);
	}
	
	@PostMapping("attendees/post")
	public ResponseEntity<Attendee> saveAttendee(@RequestBody Attendee attendee){
		log.info("Registering the Attendee");
		return new ResponseEntity<Attendee>(attendeeService.saveAttendee(attendee), HttpStatus.CREATED);
	}
	
	@GetMapping("attendeeslist")
	public List<Attendee> getAttendees(){
		log.info("Getting List of Attendees");
		return attendeeService.getAttendees();
	}
	
	@GetMapping("attendees/{id}")
	public Optional<Attendee> getAttendeeById(@PathVariable("id") long id){
		log.info("Getting attendee detail");
		return attendeeService.getById(id);
	}
	
	@PutMapping("attendees/{id}")
	public ResponseEntity<Attendee> updateAttendee(@RequestBody Attendee attendee, @PathVariable("id") long id){
		log.info("Modifying the attendee");
		return new ResponseEntity<Attendee>(attendeeService.updateAttendee(attendee, id), HttpStatus.OK);
	}
	
	@DeleteMapping("attendees/{id}")
	public ResponseEntity<Attendee> deleteAttendee(@PathVariable("id") long id){
		log.info("Deleting the attendee");
		attendeeService.deleteAttendee(id);
		return new ResponseEntity<Attendee>(HttpStatus.OK);
	}

}
