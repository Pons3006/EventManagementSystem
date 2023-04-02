package com.example.pons.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="attendee")
public class Attendee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attendee_id")
	private long attendeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_number",unique=true)
	private long phoneNumber;
	
	@Column(name="email",unique = true)
	private String email;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "attendee_event",
               joinColumns = @JoinColumn(name = "attendee_id"),
               inverseJoinColumns = @JoinColumn(name = "match_id"))
    private Set<IplEvent> iplEvents = new HashSet<>();

	public long getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(long attendeeId) {
		this.attendeeId = attendeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Attendee() {
		
	}

	public Attendee(String firstName, String lastName, long phoneNumber, String email, Set<IplEvent> iplEvents) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.iplEvents = iplEvents;
	}

	public Set<IplEvent> getIplEvents() {
		return iplEvents;
	}

	public void setIplEvents(Set<IplEvent> iplEvents) {
		this.iplEvents = iplEvents;
	}
	
//	public void addEvent(IplEvent event) {
//        iplEvents.add(event);
//       event.getAttendees().add(this);
//
//    }
//
//    public void removeEvent(IplEvent event) {
//        iplEvents.remove(event);
//        event.getAttendees().remove(this);
//    }

}
