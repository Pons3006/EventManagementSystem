package com.example.pons.service;

import java.util.List;
import java.util.Optional;

import com.example.pons.model.IplEvent;

public interface IplEventService {

	public IplEvent saveEvent(IplEvent event);
	
	public List<IplEvent> getEvents();
	
	public Optional<IplEvent> getEventByID(long id);
	
	public IplEvent updateEvent(IplEvent event, long id);
	
	public void deleteEvent(long id);

}
