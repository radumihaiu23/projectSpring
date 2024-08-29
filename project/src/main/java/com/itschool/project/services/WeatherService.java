package com.itschool.project.services;

import com.itschool.project.models.entities.Weather;

import java.io.IOException;

public interface WeatherService {

    Weather getWeather(String city) throws IOException;
}
