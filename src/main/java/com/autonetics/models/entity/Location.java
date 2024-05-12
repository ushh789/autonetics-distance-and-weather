package com.autonetics.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Address")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID", nullable = false)
    private Integer id;

    @Column(name = "Latitude", precision = 8, scale = 6)
    private BigDecimal latitude;

    @Column(name = "Longitude", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "Name")
    private String name;

}