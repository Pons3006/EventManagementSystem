package com.example.pons.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;



@Entity
@Table(name="ipl_event")
public class IplEvent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="match_id")
	private long matchId;
	
	@Column(name="match_name")
	private String matchName;
	
	@Column(name="venue")
	private String venue;
	
	@Column(name="match_date")
	private String matchDate;

	@Column(name="match_time")
	private String matchTime;
	
	@ManyToMany(mappedBy = "iplEvents")
    private Set<Attendee> attendees = new HashSet<>();
		
	public IplEvent() {
		
	}

	public long getMatchId() {
		return matchId;
	}

//	public Set<Attendee> getAttendees() {
//		return attendees;
//	}
//
//	public void setAttendees(Set<Attendee> attendees) {
//		this.attendees = attendees;
//	}

	public IplEvent(String matchName, String venue, String matchDate, String matchTime) {
	super();
	this.matchName = matchName;
	this.venue = venue;
	this.matchDate = matchDate;
	this.matchTime = matchTime;
//	this.attendees = attendees;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}

}
