package com.spacex.siemes.test.service;

import com.spacex.siemes.test.web.dto.CrewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class SpacexAPIHttpClient {

	private static final String spacexAPIURL = "https://api.spacexdata.com/v4";
	private static final String crewURL = "/crew";
	private final static Logger LOGGER = LoggerFactory.getLogger(SpacexAPIHttpClient.class);

	private final RestTemplate restTemplate;

	public SpacexAPIHttpClient(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler())
				.build();
	}

	public List<CrewDTO> getAllCrew() {
		List<CrewDTO> crewDTOS = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(spacexAPIURL + crewURL, CrewDTO[].class)));
		LOGGER.info("Succesfuly got all Crew from Spacex API");
		return crewDTOS;
	}
}
