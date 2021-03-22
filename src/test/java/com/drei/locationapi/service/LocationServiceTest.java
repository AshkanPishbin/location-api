package com.drei.locationapi.service;

import com.drei.locationapi.model.Location;
import com.drei.locationapi.model.Type;
import com.drei.locationapi.repository.LocationRepository;
import com.drei.locationapi.services.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Ashkan Pishbin
 */
public class LocationServiceTest {

    public static final float LAT = 48.2f;
    public static final float ANY_LAT = LAT;
    public static final float LNG = 15.6f;
    public static final float ANY_LNG = LNG;
    public static final String ANY_NAME = "name";
    public static final Type ANY_TYPE = Type.STANDARD;

    private final LocationRepository locationRepo = mock(LocationRepository.class);
    private final LocationService service = new LocationService();

    @BeforeEach
    void setUp() {
        service.setLocationRepo(locationRepo);
    }

    @Test
    public void getLocationByCoordinateReturnsLocationsForGivenLatAndLng() {
        Location location = new Location(ANY_NAME, LAT, LNG, ANY_TYPE);
        when(locationRepo.findByLatAndLng(LAT, LNG))
                .thenReturn(Optional.of(singletonList(location)));

        List<Location> locations = service.getLocationByCoordinate(LAT, LNG);

        assertThat(locations).extracting(Location::getLat).containsExactly(LAT);
        assertThat(locations).extracting(Location::getLng).containsExactly(LNG);
    }

    @Test
    public void getLocationByCoordinateReturnsLocationsSortedByTypePremiumOnesComeFirstForGivenLatAndLng() {
        Location location1 = new Location(ANY_NAME, ANY_LAT, ANY_LNG, Type.PREMIUM);
        Location location2 = new Location(ANY_NAME, ANY_LAT, ANY_LNG, Type.STANDARD);
        when(locationRepo.findByLatAndLng(ANY_LAT, ANY_LNG))
                .thenReturn(Optional.of(asList(location2, location1)));

        List<Location> locations = service.getLocationByCoordinate(ANY_LAT, ANY_LNG);

        assertThat(locations).extracting(Location::getType).containsExactly(Type.PREMIUM, Type.STANDARD);
    }

}
