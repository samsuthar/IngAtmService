package com.backbase.assignment.controllers;

import com.backbase.assignment.model.Address;
import com.backbase.assignment.model.Response;
import com.backbase.assignment.model.ServiceLocation;
import com.backbase.assignment.services.ServiceLocator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ServiceControllerTest {


    @InjectMocks
    ServiceController serviceController;

    @Mock
    ServiceLocator serviceLocator;

    private List<ServiceLocation> serviceLocationList;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        serviceLocationList = new ArrayList<>();
        ServiceLocation location1 = new ServiceLocation();
        Address address = new Address();
        address.setCity("GELDROP");
        address.setHousenumber("1");

        location1.setAddress(address);

        ServiceLocation location2 = new ServiceLocation();
        Address address1 = new Address();
        address1.setHousenumber("2");
        address1.setCity("ROTTERDAM");

        location1.setAddress(address1);

        serviceLocationList.add(location1);
        serviceLocationList.add(location2);
    }

    @Test
    public void testGetLocationsFromService() throws Exception {

        when(serviceLocator.getLocationsfromService()).thenReturn(serviceLocationList);
        Response<ServiceLocation> locationsFromService = serviceController.getLocationsfromService();
        assertEquals(locationsFromService.getList().size(),2);

    }

    @Test
    public void testGetLocationsByCityFromService() throws Exception {

    	 when(serviceLocator.getLocationsByCity(Mockito.anyString())).thenReturn(serviceLocationList);
         Response<ServiceLocation> locationsfromINGByCity = serviceController.getLocationsfromByCity("ANY_CITY");
         assertEquals(locationsfromINGByCity.getList().size(),2);


    }
}