package com.spacex.siemes.test.web;


import com.spacex.siemes.test.service.SpacexService;
import com.spacex.siemes.test.web.dto.CrewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpacexRestController {
	private final static Logger LOGGER = LoggerFactory.getLogger(SpacexRestController.class);


	private SpacexService spacexService;

	public SpacexRestController(SpacexService spacexService) {
		this.spacexService = spacexService;
	}

	@GetMapping("/crew/space")
	public List<CrewDTO> findTotalPersonsSentToSpace() {
		LOGGER.info("Rest request to get All crew sent to space ");
		return spacexService.findTotalPersonsSentToSpace();
	}

}
