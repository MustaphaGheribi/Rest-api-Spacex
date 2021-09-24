package com.spacex.siemes.test.service;

import com.spacex.siemes.test.web.dto.CrewDTO;

import java.util.List;

public interface SpacexService {

	List<CrewDTO> findTotalPersonsSentToSpace() ;

}
