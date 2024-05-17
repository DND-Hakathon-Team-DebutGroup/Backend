package dnd.dndserver.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvgDTO {
    private int temperatureAvg;
    private int precipitationAvg;
    private int sunshineAvg;
}
