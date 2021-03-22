package com.drei.locationapi.repository;

import com.drei.locationapi.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drei.locationapi.model.Location;

import java.util.List;
import java.util.Optional;

/**
 * @author Ashkan Pishbin
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
	Optional<List<Location>> findByType(@Param("type") Type type);
	Optional<List<Location>> findByLatAndLng(@Param("lat") float p1, @Param("lng") float p2);
}
