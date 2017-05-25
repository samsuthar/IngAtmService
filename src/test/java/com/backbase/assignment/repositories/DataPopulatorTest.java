package com.backbase.assignment.repositories;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.backbase.assignment.LocatorApplication;
import com.backbase.assignment.model.ServiceLocation;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LocatorApplication.class)
@WebAppConfiguration
public class DataPopulatorTest {

    @Autowired
    DataPopulator dataPopulator;

    @Test
    public void fetchDataFromService() throws Exception {

        List<ServiceLocation> data = dataPopulator.getDataFromService();
        assertEquals(data.size(), 1538);
    }

}
