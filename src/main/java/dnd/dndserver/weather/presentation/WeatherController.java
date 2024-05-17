package dnd.dndserver.weather.presentation;

import dnd.dndserver.global.handler.ResponseHandler;
import dnd.dndserver.weather.application.WeatherService;
import dnd.dndserver.weather.dto.response.FindDayWeatherResponse;
import dnd.dndserver.weather.dto.response.FindTimeWeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/weather")
@RequiredArgsConstructor
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/time")
    public ResponseEntity<ResponseHandler<FindTimeWeatherResponse>> findTimeWeather(
            @RequestParam String stn
    ) {
        return ResponseEntity.ok()
                .body(ResponseHandler.<FindTimeWeatherResponse>builder()
                        .statusCode(HttpStatus.OK)
                        .data(weatherService.findTimeWeather(stn))
                        .build()
                );
    }

    @GetMapping("/day")
    public ResponseEntity<ResponseHandler<FindDayWeatherResponse>> findDayWeather(
            @RequestParam String stn
    ) {
        return ResponseEntity.ok()
                .body(ResponseHandler.<FindDayWeatherResponse>builder()
                        .statusCode(HttpStatus.OK)
                        .data(weatherService.findDayWeather(stn))
                        .build());

    }
}
