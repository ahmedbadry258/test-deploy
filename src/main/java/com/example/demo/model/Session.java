package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long session_id;
	
	private String session_name;
	
	@ManyToMany
	@JoinTable(
			name = "sessions_speakers",
			joinColumns = @JoinColumn(name="session_id"),
			inverseJoinColumns = @JoinColumn(name="speaker_id")
			)
	@JsonIgnore
	List<Speaker> speakers;

	public long getSession_id() {
		return session_id;
	}

	public void setSession_id(long session_id) {
		this.session_id = session_id;
	}

	public String getSession_name() {
		return session_name;
	}

	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	
}
