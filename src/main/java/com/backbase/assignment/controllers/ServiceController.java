package com.backbase.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.assignment.model.ServiceLocation;
import com.backbase.assignment.model.Response;
import com.backbase.assignment.services.ServiceLocator;

@RestController
public class ServiceController {

    @Autowired
    private ServiceLocator locator;

    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Response<ServiceLocation> getLocationsfromService() throws Exception {
        Response<ServiceLocation> responseObject= new Response<>();
        responseObject.setList(locator.getLocationsfromService());
        return responseObject;
    }

	@RequestMapping(value = "/locations/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Response<ServiceLocation> getLocationsfromByCity(@PathVariable("city") String city)
			throws Exception {
		Response<ServiceLocation> responseObject = new Response<>();
		responseObject.setList(locator.getLocationsByCity(city));
		return responseObject;
	}

}
