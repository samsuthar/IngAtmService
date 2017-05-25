package com.backbase.assignment.repositories;

import com.backbase.assignment.model.ServiceLocation;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author satyam
 *
 */
@Component
public class DataPopulator extends RouteBuilder {

    @Autowired
    private RestTemplate restTemplate;

    public List<ServiceLocation> getDataFromService() throws Exception {


        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

    
        String parseThisString = response.substring(6, response.length());
        ObjectMapper objectMapper = new ObjectMapper();
        ServiceLocation[] locations = objectMapper.readValue(parseThisString, ServiceLocation[].class);
    
        return Arrays.asList(locations);
    }

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
