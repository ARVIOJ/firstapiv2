package com.trainibit.first_api.dto.response.external;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PlanetResponse {
    private String message;
    private PlanetResultResponse result;
}
