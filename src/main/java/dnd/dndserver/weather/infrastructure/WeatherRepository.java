package dnd.dndserver.weather.infrastructure;

import dnd.dndserver.weather.dto.DayWeatherDTO;
import dnd.dndserver.weather.dto.TimeWeatherDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository {

    TimeWeatherDTO getTimeWeather(String stn);

    DayWeatherDTO getDayWeather(String stn);
}
