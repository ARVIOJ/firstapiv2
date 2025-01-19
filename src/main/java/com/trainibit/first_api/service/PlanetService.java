package com.trainibit.first_api.service;

import com.trainibit.first_api.response.external.PlanetResponse;

public interface PlanetService {
    PlanetResponse getPlanet(int id);
}
