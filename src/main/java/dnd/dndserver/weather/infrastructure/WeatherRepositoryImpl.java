package dnd.dndserver.weather.infrastructure;

import dnd.dndserver.weather.dto.DayWeatherDTO;
import dnd.dndserver.weather.dto.TimeWeatherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class WeatherRepositoryImpl implements WeatherRepository {

    private final WebClient webClient = WebClient.builder().baseUrl("https://apihub.kma.go.kr").build();
    @Value("${api.kma.authKey}")
    private String authKey;


    @Override
    public TimeWeatherDTO getTimeWeather(String stn) {
        TimeWeatherDTO timeWeatherDTO = new TimeWeatherDTO();

        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/typ01/url/kma_sfctm2.php")
                        .queryParam("stn", stn)
                        .queryParam("authKey", authKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println("response = " + response);
        String[] lines = response.split("\n");
        String aline = "";
        for (String line : lines) {
            if (line.startsWith("2024")) {
                aline = line;
                break;
            }
        }
        String[] parts = aline.split("\\s+");
        String nowTemperature = parts[11];
        String rn = parts[15];

        double rnNum = Double.parseDouble(rn);

        if (rnNum < 0) {
            timeWeatherDTO.setWeather("맑음");
        }
        if (0 <= rnNum && rnNum <= 3) {
            timeWeatherDTO.setWeather("흐림");
        }
        if (3 < rnNum) {
            timeWeatherDTO.setWeather("비");
        }

        timeWeatherDTO.setNowTemp(nowTemperature);

        return timeWeatherDTO;
    }

    @Override
    public DayWeatherDTO getDayWeather(String stn) {
        DayWeatherDTO dayWeatherDTO = new DayWeatherDTO();

        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/typ01/url/kma_sfcdd.php")
                        .queryParam("stn", stn)
                        .queryParam("authKey", authKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String[] lines = response.split("\n");
        String aline = "";
        for (String line : lines) {
            if (line.startsWith("2024")) {
                aline = line;
                break;
            }
        }
        String[] parts = aline.split(",");
        String maxTemperature = parts[11];
        String minTemperature = parts[13];

        dayWeatherDTO.setMaxTemp(maxTemperature);
        dayWeatherDTO.setMinTemp(minTemperature);

        return dayWeatherDTO;
    }
}
