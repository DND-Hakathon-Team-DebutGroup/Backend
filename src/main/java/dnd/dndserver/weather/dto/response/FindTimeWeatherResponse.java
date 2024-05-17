package dnd.dndserver.weather.dto.response;

import dnd.dndserver.weather.dto.TimeWeatherDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record FindTimeWeatherResponse(
        String nowTemp,
        String weather,
        String dateTime
) {
    public static FindTimeWeatherResponse from(TimeWeatherDTO timeWeatherDTO) {
        return new FindTimeWeatherResponse(
                timeWeatherDTO.getNowTemp(),
                timeWeatherDTO.getWeather(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        );
    }
}
