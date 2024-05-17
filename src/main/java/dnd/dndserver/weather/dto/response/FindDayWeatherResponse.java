package dnd.dndserver.weather.dto.response;

import dnd.dndserver.weather.dto.DayWeatherDTO;

public record FindDayWeatherResponse(
        String maxTemp,
        String minTemp
) {
    public static FindDayWeatherResponse from(DayWeatherDTO dayWeatherDTO) {
        return new FindDayWeatherResponse(dayWeatherDTO.getMaxTemp(), dayWeatherDTO.getMinTemp());
    }
}
