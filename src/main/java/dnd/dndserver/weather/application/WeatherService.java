package dnd.dndserver.weather.application;

import dnd.dndserver.weather.dto.response.FindDayWeatherResponse;
import dnd.dndserver.weather.dto.response.FindTimeWeatherResponse;
import dnd.dndserver.weather.infrastructure.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Transactional
    public FindTimeWeatherResponse findTimeWeather(String stn) {
        return FindTimeWeatherResponse.from(weatherRepository.getTimeWeather(stn));
    }

    @Transactional
    public FindDayWeatherResponse findDayWeather(String stn) {
        return FindDayWeatherResponse.from(weatherRepository.getDayWeather(stn));
    }
}
