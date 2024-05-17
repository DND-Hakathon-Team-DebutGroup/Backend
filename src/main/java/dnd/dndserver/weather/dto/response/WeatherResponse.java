package dnd.dndserver.weather.dto.response;

import lombok.Getter;

@Getter
public class WeatherResponse {
    private Weather weather;

    @Getter
    public static class Weather {
        private String temperature;
    }
}
