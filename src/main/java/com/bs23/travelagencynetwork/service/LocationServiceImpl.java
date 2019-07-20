package com.bs23.travelagencynetwork.service;

import com.bs23.travelagencynetwork.entity.Location;
import com.bs23.travelagencynetwork.repository.LocationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private static final Logger logger = LogManager.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> getLocationById(Long locationId) {
        return locationRepository.findById(locationId);
    }
}
