package com.spacex.siemes.test.web.dto;

import java.io.Serializable;
import java.util.List;

public class CrewDTO implements Serializable {

	private String name;
	private String agency;
	private String image;
	private String wikipedia;
	private List<String> launches;
	private String status;
	private String id;

	public CrewDTO() {
		//for jackson :(
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getWikipedia() {
		return wikipedia;
	}

	public void setWikipedia(String wikipedia) {
		this.wikipedia = wikipedia;
	}

	public List<String> getLaunches() {
		return launches;
	}

	public void setLaunches(List<String> launches) {
		this.launches = launches;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
