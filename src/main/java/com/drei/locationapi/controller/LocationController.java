package com.drei.locationapi.controller;

import com.drei.locationapi.model.Location;
import com.drei.locationapi.model.Type;
import com.drei.locationapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Ashkan Pishbin
 */
@RestController
@RequestMapping("/api/location")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locationByType/{type}")
    public List<Location> searchLocationByType(@PathVariable(value = "type") Type type) {
        return locationService.getLocationByType(type);
    }

    @GetMapping("/locationByCoordinate/{lat}/{lng}")
    public List<Location> searchLocationByCoordinate(
            @PathVariable(value = "lat") float p1,
            @PathVariable(value = "lng") float p2
    ) {
        return locationService.getLocationByCoordinate(p1, p2);
    }

    @PostMapping(value = "/createLocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Location createLocation(@Valid @RequestBody Location location) {
        return locationService.save(location);
    }

}
