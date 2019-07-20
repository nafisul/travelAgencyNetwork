package com.bs23.travelagencynetwork.service;

import com.bs23.travelagencynetwork.entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    public List<Location> getAllLocation();
    public Optional<Location> getLocationById(Long locationId);
}
