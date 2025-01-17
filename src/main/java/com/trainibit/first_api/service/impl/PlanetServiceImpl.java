package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.dto.response.external.PlanetResponse;
import com.trainibit.first_api.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PlanetResponse getPlanet(int id) {
        String url = "https://www.swapi.tech/api/planets/" + id;
        return restTemplate.getForObject(url, PlanetResponse.class);
        //return restTemplate.getForObject(url, PlanetResponse.class);
    }
}
