package com.example.pons.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pons.exception.IplMatchExistException;
import com.example.pons.exception.NoIplEventException;
import com.example.pons.model.IplEvent;

import com.example.pons.repository.IplEventRepository;

@Service
public class IplEventServiceImpl implements IplEventService {
	@Autowired
	AttendeeServiceImpl attendeeService;
	@Autowired
	private IplEventRepository eventRepository;
	
	public IplEvent saveEvent(IplEvent event) {
		Optional<IplEvent> existByMatchName=eventRepository.findByMatchName(event.getMatchName());
		
		if(existByMatchName.isPresent()) {
			throw new IplMatchExistException("This match Already exists...");
		}
		return eventRepository.save(event);
		
	}
	@Override
	public List<IplEvent> getEvents() {
		return eventRepository.findAll();
	}
	@Override
	public Optional<IplEvent> getEventByID(long id) {
		Optional<IplEvent> existById=eventRepository.findById(id);
		
		if(existById.isEmpty()) {
			throw new NoIplEventException("No Ipl Match found..");
		}
		
		return eventRepository.findById(id);
	}
	@Override
	public IplEvent updateEvent(IplEvent event, long id) {
		
		Optional<IplEvent> existById=eventRepository.findById(id);
		if(existById.isEmpty()) {
			throw new NoIplEventException("No Ipl Match found..");
		}

		IplEvent oldEvent=existById.get();
		oldEvent.setMatchName(event.getMatchName());
		oldEvent.setMatchDate(event.getMatchDate());
		oldEvent.setMatchTime(event.getMatchTime());
		oldEvent.setVenue(event.getVenue());
		eventRepository.save(oldEvent);
		return oldEvent;
	}
	@Override
	public void deleteEvent(long id) {
		
		Optional<IplEvent> existById=eventRepository.findById(id);
		if(existById.isEmpty()) {
			throw new NoIplEventException("No Ipl Match found..");
			
		}else {
			eventRepository.deleteById(id);
			System.out.println("Match with id :"+id+ " cancelled/deleted....");
		}
		
	}

}
