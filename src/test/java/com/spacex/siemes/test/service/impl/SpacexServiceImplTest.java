package com.spacex.siemes.test.service.impl;

import com.spacex.siemes.test.service.SpacexAPIHttpClient;
import com.spacex.siemes.test.web.dto.CrewDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest()
class SpacexServiceImplTest {
	@Mock
	private SpacexAPIHttpClient spacexAPIHttpClient;

	@InjectMocks
	private SpacexServiceImpl spacexService;

	@Test
	public void findTotalPersonsSentToSpace_should_filterCrewWithNoLaunches() {
		//given
		given(spacexAPIHttpClient.getAllCrew()).willReturn(getAllCrew());

		//when
		List<CrewDTO> totalPersonsSentToSpace = spacexService.findTotalPersonsSentToSpace();

		//should filter out crew with no launches
		assertThat(totalPersonsSentToSpace.size()).isEqualTo(2);
	}

	private List<CrewDTO> getAllCrew() {
		CrewDTO crewDTO1 = new CrewDTO();
		crewDTO1.setLaunches(Arrays.asList("launch1", "launch2"));

		CrewDTO crewDTO2 = new CrewDTO();
		crewDTO2.setLaunches(Arrays.asList("launch1", "launch2"));

		CrewDTO crewDTO3 = new CrewDTO();
		crewDTO3.setLaunches(Collections.emptyList());

		CrewDTO crewDTO4 = new CrewDTO();
		crewDTO4.setLaunches(Collections.emptyList());

		return Arrays.asList(crewDTO1, crewDTO2, crewDTO3, crewDTO4);
	}

}
