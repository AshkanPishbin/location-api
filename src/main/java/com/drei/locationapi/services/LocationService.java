package com.drei.locationapi.services;

import com.drei.locationapi.model.Location;
import com.drei.locationapi.model.Type;
import com.drei.locationapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

/**
 * @author Ashkan Pishbin
 */
@Service
public class LocationService {

    private LocationRepository locationRepo;

    @Autowired
    public void setLocationRepo(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    public Location save(Location location) {
        return locationRepo.save(location);
    }

    public List<Location> getLocationByType(Type type) {
        return locationRepo.findByType(type)
                .orElse(emptyList());
    }

    public List<Location> getLocationByCoordinate(float p1, float p2) {
        return locationRepo.findByLatAndLng(p1, p2)
                .map(this::sortByPremiumTypeFirst)
                .orElse(emptyList());
    }

    private List<Location> sortByPremiumTypeFirst(List<Location> locations) {
        return locations.stream()
                .sorted(Comparator.comparing(Location::getType))
                .collect(Collectors.toList());
    }

}
