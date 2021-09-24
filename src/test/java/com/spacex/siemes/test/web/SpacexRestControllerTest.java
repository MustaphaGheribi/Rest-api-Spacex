package com.spacex.siemes.test.web;

import com.spacex.siemes.test.TestApplication;
import com.spacex.siemes.test.exception.NotFoundException;
import com.spacex.siemes.test.service.RestTemplateResponseErrorHandler;
import com.spacex.siemes.test.web.dto.CrewDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestApplication.class })
@RestClientTest
class SpacexRestControllerTest {

	@Autowired
	private MockRestServiceServer server;

	@Autowired
	private RestTemplate restTemplate;


	@Test
	public void givenRemoteAPIisOK_then_success() {
		Assert.assertNotNull(this.server);

		this.server
				.expect(ExpectedCount.once(), requestTo("/crew/space"))
				.andExpect(method(HttpMethod.GET))
				.andRespond(withStatus(HttpStatus.OK));

		restTemplate
				.getForObject("/crew/space", CrewDTO[].class);
		this.server.verify();
	}

}
