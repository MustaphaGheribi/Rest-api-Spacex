package com.spacex.siemes.test.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spacex.siemes.test.web.dto.CrewDTO;

import java.util.ArrayList;
import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class ListCrew {
	private List<CrewDTO> crewList;

	public ListCrew() {
		crewList = new ArrayList<>();
	}

	public List<CrewDTO> getCrewList() {
		return crewList;
	}

	public void setCrewList(List<CrewDTO> crewList) {
		this.crewList = crewList;
	}
}
