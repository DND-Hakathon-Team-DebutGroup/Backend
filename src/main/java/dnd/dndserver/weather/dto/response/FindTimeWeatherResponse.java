package dnd.dndserver.weather.dto.response;

import dnd.dndserver.weather.dto.TimeWeatherDTO;

public record FindTimeWeatherResponse(
        String nowTemp,
        String weather
) {
    public static FindTimeWeatherResponse from(TimeWeatherDTO timeWeatherDTO) {
        return new FindTimeWeatherResponse(timeWeatherDTO.getNowTemp(), timeWeatherDTO.getWeather());
    }
}
