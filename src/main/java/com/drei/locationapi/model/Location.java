package com.drei.locationapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author Ashkan Pishbin
 */
@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should be not blank")
    @NonNull
    private String name;

    @NonNull
    private float lat;

    @NonNull
    private float lng;

    @NotBlank(message = "Type should be not blank")
    @NonNull
    private Type type;

}
