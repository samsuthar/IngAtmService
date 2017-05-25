package com.backbase.assignment.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backbase.assignment.model.Address;
import com.backbase.assignment.model.ServiceLocation;
import com.backbase.assignment.repositories.DataPopulator;

/**
 * @author satyam
 *
 */
public class ServiceLocatorTest {

    @InjectMocks
    ServiceLocator locator;

    @Mock
    DataPopulator dataPopulator;

    private List<ServiceLocation> serviceLocationList;


    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        serviceLocationList = new ArrayList<>();
        ServiceLocation loc1 = new ServiceLocation();
        Address address = new Address();
        address.setCity("Hippolytushoef");
        address.setHousenumber("37");

        loc1.setAddress(address);

        ServiceLocation loc2 = new ServiceLocation();
        Address address1 = new Address();
        address1.setHousenumber("33");
        address1.setCity("Rotterdam");

        loc2.setAddress(address1);

        serviceLocationList.add(loc1);
        serviceLocationList.add(loc2);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testGestLocationsFromService() throws Exception {

        when(dataPopulator.getDataFromService()).thenReturn(serviceLocationList);
        List<ServiceLocation> serviceLocation = dataPopulator.getDataFromService();
        assertEquals(serviceLocation.size(), 2);

    }

}