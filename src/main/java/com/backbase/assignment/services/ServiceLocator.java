package com.backbase.assignment.services;

import com.backbase.assignment.model.ServiceLocation;
import com.backbase.assignment.repositories.DataPopulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLocator {

    @Autowired
    private DataPopulator dataPopulator;

    public List<ServiceLocation> getLocationsfromService() throws Exception {

        return dataPopulator.getDataFromService();
    }

    public List<ServiceLocation> getLocationsByCity(String city) throws Exception {

        List<ServiceLocation> locations = new ArrayList<>();
        List<ServiceLocation> atmLocationsfromING = getLocationsfromService();
        for (ServiceLocation location : atmLocationsfromING) {
            if (city.equalsIgnoreCase(location.getAddress().getCity())) {
                locations.add(location);
            }
        }
        return locations;
    }
}
