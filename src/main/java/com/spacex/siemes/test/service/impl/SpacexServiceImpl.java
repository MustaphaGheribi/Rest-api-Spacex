package com.spacex.siemes.test.service.impl;

import com.spacex.siemes.test.service.SpacexAPIHttpClient;
import com.spacex.siemes.test.service.SpacexService;
import com.spacex.siemes.test.web.dto.CrewDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpacexServiceImpl implements SpacexService {

	private SpacexAPIHttpClient spacexAPIHttpClient;

	public SpacexServiceImpl(SpacexAPIHttpClient spacexAPIHttpClient) {
		this.spacexAPIHttpClient = spacexAPIHttpClient;
	}

	@Override
	public List<CrewDTO> findTotalPersonsSentToSpace() {
		List<CrewDTO> allCrew = spacexAPIHttpClient.getAllCrew();
		return allCrew.parallelStream().filter(crewDTO -> !crewDTO.getLaunches().isEmpty()).collect(Collectors.toList());
	}

}
