package com.seniorsteps.doctorist.models;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "DOCTOR")
public class Doctor {
	
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "FIRST_NAME")
    private String firstName;
    
	@Column(name = "LAST_NAME")
    private String lastName;
    
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "ABOUT")
	private String about;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private Set<TimeSchedule> timeSchedules;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Set<TimeSchedule> getTimeSchedules() {
		return timeSchedules;
	}

	public void setTimeSchedules(Set<TimeSchedule> timeSchedules) {
		this.timeSchedules = timeSchedules;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", about=" + about + ", timeSchedules=" + timeSchedules + "]";
	}

	

}
