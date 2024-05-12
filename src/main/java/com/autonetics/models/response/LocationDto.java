package com.autonetics.models.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.autonetics.models.entity.Location}
 */
public record LocationDto(BigDecimal latitude, BigDecimal longitude, String name) implements Serializable {
}