package com.trainibit.first_api.response.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetResultResponse
{
    PlanetPropertiesResponse properties;
    private String description;
    private String _id;
    private String uid;
    private Integer __v;
}
